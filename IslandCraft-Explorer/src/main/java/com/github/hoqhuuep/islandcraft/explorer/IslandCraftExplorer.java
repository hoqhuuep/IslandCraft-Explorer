package com.github.hoqhuuep.islandcraft.explorer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

import com.github.hoqhuuep.islandcraft.api.ICBiome;
import com.github.hoqhuuep.islandcraft.api.ICWorld;
import com.github.hoqhuuep.islandcraft.core.DefaultWorld;
import com.github.hoqhuuep.islandcraft.core.ICClassLoader;
import com.github.hoqhuuep.islandcraft.core.ICLogger;
import com.github.hoqhuuep.islandcraft.core.IslandCache;
import com.github.hoqhuuep.islandcraft.core.IslandDatabase;

public class IslandCraftExplorer extends HttpServlet {
    private static final long serialVersionUID = -3046171450169108023L;
    private ICWorld world;

    public IslandCraftExplorer() {
        ICLogger.logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        ICLogger.logger.setLevel(Level.WARNING);

        IslandDatabase database = new IslandDatabase() {
            public void save(String worldName, int centerX, int centerZ, long islandSeed, String generator) {
                // NOP
            }

            public Result load(String worldName, int centerX, int centerZ) {
                return null;
            }

            public boolean isEmpty(String worldName) {
                return false;
            }
        };

        ConfigurationSection config = YamlConfiguration.loadConfiguration(new InputStreamReader(getClass().getResourceAsStream("/config.yml")));

        world = new DefaultWorld("world_islandcraft", new Random().nextLong(), database, config.getConfigurationSection("worlds.world_islandcraft"), new IslandCache(), new ICClassLoader());
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().endsWith("/img.png")) {
            showImage(request, response);
        } else if (request.getRequestURI().endsWith("/script.js")) {
            showScript(request, response);
        } else {
            showMap(request, response);
        }
    }

    private void showScript(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        String script = "";
        script += "onload = function() {";
        script += "var map = L.map('map').setView([0, 0], 13);";
        script += "L.tileLayer('http://localhost:5000/{z}/{x}/{y}/img.png', {";
        script += "continuousWorld: true,";
        script += "minZoom: 0,";
        script += "maxZoom: 8,";
        script += "}).addTo(map);";
        script += "};";
        response.getWriter().print(script);
    }

    private void showMap(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        String page = "";
        page += "<!DOCTYPE html>";
        page += "<html>";
        page += "<head>";
        page += "<link rel=\"stylesheet\" href=\"http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.css\" />";
        page += "<script src=\"http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js\"></script>";
        page += "<script src=\"http://localhost:5000/script.js\"></script>";
        page += "</head>";
        page += "<body>";
        page += "<div id=\"map\" style=\"height:768px\"></div>";
        page += "</body>";
        page += "</html>";
        response.getWriter().print(page);
    }

    private void showImage(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        String req = request.getRequestURI();
        String[] args = req.split("[^0-9\\-]+");
        final int zoom = Integer.parseInt(args[1]);
        final int tileX = ((Integer.parseInt(args[2]) * 256) << 4) >> zoom;
        final int tileZ = ((Integer.parseInt(args[3]) * 256) << 4) >> zoom;

        final BufferedImage image = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
        // final Graphics2D graphics = image.createGraphics();
        for (int z = 0; z < 256; ++z) {
            final int zz = tileZ + ((z << 4) >> zoom);
            for (int x = 0; x < 256; ++x) {
                final int xx = tileX + ((x << 4) >> zoom);
                final ICBiome biome = world.getBiomeAt(xx, zz);
                final Color color = BiomeColor.get(biome);
                final int rgb = color.getRGB();
                image.setRGB(x, z, rgb);
            }
        }
        // graphics.setColor(Color.WHITE);
        // graphics.drawString("x: " + tileX, 10, 20);
        // graphics.drawString("z: " + tileZ, 10, 40);
        // graphics.drawString("zoom: " + zoom, 10, 60);
        // graphics.dispose();

        response.setContentType("image/png");
        final OutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "png", outputStream);
        outputStream.close();
    }

    public static void main(final String[] args) throws Exception {
        // final Server server = new
        // Server(Integer.valueOf(System.getenv("PORT")));
        final Server server = new Server(5000);
        final ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new IslandCraftExplorer()), "/*");
        server.start();
        server.join();
    }
}
