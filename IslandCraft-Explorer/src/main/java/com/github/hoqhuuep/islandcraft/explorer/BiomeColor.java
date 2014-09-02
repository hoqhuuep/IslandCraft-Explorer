package com.github.hoqhuuep.islandcraft.explorer;

import java.awt.Color;
import java.util.EnumMap;
import java.util.Map;

import com.github.hoqhuuep.islandcraft.api.ICBiome;

public class BiomeColor {
    private static final Map<ICBiome, Color> colorMap = new EnumMap<ICBiome, Color>(ICBiome.class);

    static {
        colorMap.put(ICBiome.BEACH, new Color(250, 222, 85));
        colorMap.put(ICBiome.BIRCH_FOREST, new Color(48, 116, 68));
        colorMap.put(ICBiome.BIRCH_FOREST_HILLS, new Color(31, 95, 50));
        colorMap.put(ICBiome.BIRCH_FOREST_HILLS_M, new Color(71, 135, 90));
        colorMap.put(ICBiome.BIRCH_FOREST_M, new Color(88, 156, 108));
        colorMap.put(ICBiome.COLD_BEACH, new Color(250, 240, 192));
        colorMap.put(ICBiome.COLD_TAIGA, new Color(49, 85, 74));
        colorMap.put(ICBiome.COLD_TAIGA_HILLS, new Color(36, 63, 54));
        colorMap.put(ICBiome.COLD_TAIGA_M, new Color(89, 125, 114));
        colorMap.put(ICBiome.DEEP_OCEAN, new Color(0, 0, 48));
        colorMap.put(ICBiome.DESERT, new Color(250, 148, 24));
        colorMap.put(ICBiome.DESERT_HILLS, new Color(210, 95, 18));
        colorMap.put(ICBiome.DESERT_M, new Color(255, 188, 64));
        colorMap.put(ICBiome.EXTREME_HILLS, new Color(96, 96, 96));
        colorMap.put(ICBiome.EXTREME_HILLS_EDGE, new Color(114, 120, 154));
        colorMap.put(ICBiome.EXTREME_HILLS_M, new Color(136, 136, 136));
        colorMap.put(ICBiome.EXTREME_HILLS_PLUS, new Color(80, 112, 80));
        colorMap.put(ICBiome.EXTREME_HILLS_PLUS_M, new Color(120, 152, 120));
        colorMap.put(ICBiome.FLOWER_FOREST, new Color(45, 142, 73));
        colorMap.put(ICBiome.FOREST, new Color(5, 102, 33));
        colorMap.put(ICBiome.FOREST_HILLS, new Color(34, 85, 28));
        colorMap.put(ICBiome.FROZEN_OCEAN, new Color(144, 144, 160));
        colorMap.put(ICBiome.FROZEN_RIVER, new Color(160, 160, 255));
        colorMap.put(ICBiome.NETHER, new Color(255, 0, 0));
        colorMap.put(ICBiome.ICE_MOUNTAINS, new Color(160, 160, 160));
        colorMap.put(ICBiome.ICE_PLAINS, new Color(255, 255, 255));
        colorMap.put(ICBiome.ICE_PLAINS_SPIKES, new Color(180, 220, 220));
        colorMap.put(ICBiome.JUNGLE, new Color(83, 123, 9));
        colorMap.put(ICBiome.JUNGLE_EDGE, new Color(98, 139, 23));
        colorMap.put(ICBiome.JUNGLE_EDGE_M, new Color(138, 179, 63));
        colorMap.put(ICBiome.JUNGLE_HILLS, new Color(44, 66, 5));
        colorMap.put(ICBiome.JUNGLE_M, new Color(123, 163, 49));
        colorMap.put(ICBiome.MEGA_SPRUCE_TAIGA, new Color(129, 142, 121));
        colorMap.put(ICBiome.MEGA_SPRUCE_TAIGA_HILLS, new Color(109, 119, 102));
        colorMap.put(ICBiome.MEGA_TAIGA, new Color(89, 102, 81));
        colorMap.put(ICBiome.MEGA_TAIGA_HILLS, new Color(69, 79, 62));
        colorMap.put(ICBiome.MESA, new Color(217, 69, 21));
        colorMap.put(ICBiome.MESA_BRYCE, new Color(255, 109, 61));
        colorMap.put(ICBiome.MESA_PLATEAU, new Color(202, 140, 101));
        colorMap.put(ICBiome.MESA_PLATEAU_F, new Color(176, 151, 101));
        colorMap.put(ICBiome.MESA_PLATEAU_F_M, new Color(216, 191, 141));
        colorMap.put(ICBiome.MESA_PLATEAU_M, new Color(242, 180, 141));
        colorMap.put(ICBiome.MUSHROOM_ISLAND, new Color(255, 0, 255));
        colorMap.put(ICBiome.MUSHROOM_ISLAND_SHORE, new Color(160, 0, 255));
        colorMap.put(ICBiome.OCEAN, new Color(0, 0, 112));
        colorMap.put(ICBiome.PLAINS, new Color(141, 179, 96));
        colorMap.put(ICBiome.RIVER, new Color(0, 0, 255));
        colorMap.put(ICBiome.ROOFED_FOREST, new Color(64, 81, 26));
        colorMap.put(ICBiome.ROOFED_FOREST_M, new Color(104, 121, 66));
        colorMap.put(ICBiome.SAVANNA, new Color(189, 178, 95));
        colorMap.put(ICBiome.SAVANNA_M, new Color(229, 218, 135));
        colorMap.put(ICBiome.SAVANNA_PLATEAU, new Color(167, 157, 100));
        colorMap.put(ICBiome.SAVANNA_PLATEAU_M, new Color(207, 197, 140));
        colorMap.put(ICBiome.END, new Color(128, 128, 255));
        colorMap.put(ICBiome.STONE_BEACH, new Color(162, 162, 132));
        colorMap.put(ICBiome.SUNFLOWER_PLAINS, new Color(181, 219, 136));
        colorMap.put(ICBiome.SWAMPLAND, new Color(7, 249, 178));
        colorMap.put(ICBiome.SWAMPLAND_M, new Color(47, 255, 218));
        colorMap.put(ICBiome.TAIGA, new Color(11, 102, 89));
        colorMap.put(ICBiome.TAIGA_HILLS, new Color(22, 57, 51));
        colorMap.put(ICBiome.TAIGA_M, new Color(51, 142, 129));
    }

    public static Color get(final ICBiome biome) {
        return colorMap.get(biome);
    }

    private BiomeColor() {
        // Utility class
    }
}