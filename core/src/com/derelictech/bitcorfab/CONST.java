package com.derelictech.bitcorfab;

/**
 * Project: bitcorfab
 * Package: PACKAGE_NAME
 * Author:  voxelv
 * Creation Date: 2017-07-15
 * Description:
 */
public class CONST {
    private static final float ASPECT_RATIO_W = 16.0f;
    private static final float ASPECT_RATIO_H = 9.0f;
    public static final float ASPECT_RATIO = ASPECT_RATIO_H / ASPECT_RATIO_W;

    public static final float SCREEN_W = 1024;
    public static final float SCREEN_H = SCREEN_W * ASPECT_RATIO;

    public static final float WORLD_W = 16.0f;
    public static final float WORLD_H = WORLD_W * ASPECT_RATIO;

    public static final int GRID_CHUNK_N = 64;
    public static final float GRID_PITCH = 1.05f;
}
