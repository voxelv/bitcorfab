package com.derelictech.bitcorfab;

import java.util.ArrayList;
import java.util.List;

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

    public static final float SCREEN_W = 1024.0f;
    public static final float SCREEN_H = SCREEN_W * ASPECT_RATIO;

    public static final float WORLD_W = 128.0f;
    public static final float WORLD_H = WORLD_W * ASPECT_RATIO;

    public static final int GRID_CHUNK_N = 64;
    public static final float GRID_PITCH = 8.05f;

    public static final List<Character> uppercase = new ArrayList<Character>();
    public static final List<Character> lowercase = new ArrayList<Character>();
    public static final List<Character> digits = new ArrayList<Character>();
    static {
        char[] uppercaseChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] lowercaseChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] digitChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(char uppercaseChar : uppercaseChars) {
            uppercase.add(uppercaseChar);
        }
        for(char lowercaseChar : lowercaseChars) {
            lowercase.add(lowercaseChar);
        }
        for(char digitChar : digitChars) {
            digits.add(digitChar);
        }
    }
}
