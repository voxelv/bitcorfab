package com.derelictech.bitcorfab.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import java.util.HashMap;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping
 * Author:  voxelv
 * Creation Date: 2017-07-22
 * Description:
 */
public class VoxAssets {
    public static final Integer voxelv_freemono_font_sizes[] = {8, 12, 16, 24, 32, 48, 56, 64, 96, 128};
    private static final HashMap<Integer, BitmapFont> voxelv_freemono_fonts = new HashMap<Integer, BitmapFont>();
    static
    {
        // Initialize voxelv_freemono_fonts HashMap
        for( Integer i : voxelv_freemono_font_sizes) {
            String format_string = "font/voxelv_freemono/voxelv_freemono_%dpx.fnt";
            voxelv_freemono_fonts.put(i, new BitmapFont(Gdx.files.internal(String.format(format_string, i))));
        }
    }

    public static BitmapFont getVoxelvFreemonoFont(Integer size) {
        return voxelv_freemono_fonts.get(size);
    }
}
