package com.derelictech.bitcorfab.grid;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping
 * Author:  voxelv
 * Creation Date: 2017-11-23
 * Description:
 */
public class GridUtil {

    public static Vector2 coordToPos(Vector2 cell_size, GridPoint2 coord) {
        return new Vector2(
                coord.x * cell_size.x,
                coord.y * cell_size.y
        );
    }

    public static GridPoint2 posToCoord(Vector2 cell_size, Vector2 pos) {
        return new GridPoint2(
                MathUtils.floor(pos.x / cell_size.x),
                MathUtils.floor(pos.y / cell_size.y)
        );
    }

    public static int coordToIndex(Grid grid, GridPoint2 coord) {
        return (coord.y * grid.cols) + coord.x;
    }

    public static GridPoint2 indexToCoord(Grid grid, int index) {
        GridPoint2 gp = new GridPoint2(0, 0);
        gp.y = MathUtils.floor(index / grid.cols);
        gp.x = MathUtils.floor(index % grid.cols);
        return gp;
    }
}
