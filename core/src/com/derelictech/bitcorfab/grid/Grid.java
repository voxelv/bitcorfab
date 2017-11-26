package com.derelictech.bitcorfab.grid;

import com.badlogic.gdx.math.GridPoint2;

import java.util.HashMap;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping
 * Author:  voxelv
 * Creation Date: 2017-11-23
 * Description:
 */
public class Grid<T> {
    public int cols, rows;

    private GridPoint2 start;
    private GridPoint2 end;

    private HashMap<GridPoint2, T> gridItems;

    public Grid() {
        cols = 0;
        rows = 0;

        start = new GridPoint2(0, 0);
        end = new GridPoint2(0, 0);

        gridItems = new HashMap<GridPoint2, T>();
    }

    public T addToGrid(T t, GridPoint2 coord) {
        // Add to coordinate structure
        gridItems.put(coord, t);

        // Adjust grid sizes
        calcSizes();

        return t;
    }

    public T getFromGrid(GridPoint2 coord) {
        return gridItems.get(coord);
    }

    public T removeFromGrid(GridPoint2 coord) {
        // Get actor from coordinate structure
        T t = gridItems.remove(coord);

        // Calculate sizes
        calcSizes();

        return t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        GridPoint2 c = new GridPoint2();
        T t;
        for(int i = end.y; i >= 0; i--) {
            for(int j = start.x; j <= end.x; j++) {
                sb.append("[");
                t = gridItems.get(c.set(j, i));
                if(t != null) {
                    sb.append(t.toString());
                }
                else {
                    sb.append(" ");
                }
                sb.append("] ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    private void calcSizes() {

        if(gridItems.size() == 0) {
            cols = 0;
            rows = 0;
            start.set(0, 0);
            end.set(0, 0);
            gridItems.clear();
        }
        else {
            GridPoint2 min, max;
            min = new GridPoint2();
            max = new GridPoint2();
            boolean setup = true;
            for (GridPoint2 gp : gridItems.keySet()) {
                if(setup) {
                    min = gp.cpy();
                    max = gp.cpy();
                    setup = false;
                }
                if(gp.x < min.x) {
                    min.x = gp.x;
                }
                if(gp.y < min.y) {
                    min.y = gp.y;
                }
                if(gp.x > max.x) {
                    max.x = gp.x;
                }
                if(gp.y > max.y) {
                    max.y = gp.y;
                }
            }
            cols = max.x - min.x + 1;
            rows = max.y - min.y + 1;
            start = min.cpy();
            end = max.cpy();
        }
    }
}
