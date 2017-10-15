package com.derelictech.bitcorfab;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab
 * Author:  voxelv
 * Creation Date: 2017-10-12
 * Description: an NxN grid defined by {@link CONST}.GRID_CHUNK_N
 */
public class BCFGrid<T> extends Group{

    protected Map<GridPoint2, T> items;

    public BCFGrid() {
        super();
        int max_size = CONST.GRID_CHUNK_N * CONST.GRID_CHUNK_N;
        items = new HashMap<GridPoint2, T>(max_size);
    }

    public static int idxFromPoint(GridPoint2 point) {
        return idxFromPoint(point, CONST.GRID_CHUNK_N);
    }

    public static int idxFromPoint(GridPoint2 point, int num_cols) {
        if(num_cols > CONST.GRID_CHUNK_N) {
            return -1;
        }
        return((point.y * num_cols) + point.x);
    }

    public static GridPoint2 pointFromIdx(int idx) {
        return pointFromIdx(idx, CONST.GRID_CHUNK_N);
    }

    public static GridPoint2 pointFromIdx(int idx, int num_cols) {
        return new GridPoint2(
                idx % num_cols,
                idx / num_cols
        );
    }

    private void addProcedure(GridPoint2 point, T obj) {
        T item = get(point);
        if(item == null) {
            items.put(point, obj);
            if (obj instanceof Actor && !getChildren().contains((Actor)obj, true)) {
                Actor a = (Actor)obj;
                addActor(a);
                a.setSize(1.0f, 1.0f);
                a.setPosition(point.x * CONST.GRID_PITCH, point.y * CONST.GRID_PITCH);
            }
        }
    }

    private T delProcedure(GridPoint2 point) {
        T item = items.remove(point);
        if(item != null) {
            if(item instanceof Disposable) {
                ((Disposable)item).dispose();
            }
            if(item instanceof Actor) {
                Actor a = (Actor)item;
                removeActor(a);
                a.setPosition(0.0f, 0.0f);
            }
        }
        return item;
    }

    public T set(int x, int y, T obj) {
        return set(new GridPoint2(x, y), obj);
    }

    public T set(GridPoint2 point, T obj) {
        if(obj != null) {
            addProcedure(point, obj);
        }
        return obj;
    }

    public T get(GridPoint2 point) {
        return items.get(idxFromPoint(point));
    }

    public T del(GridPoint2 point) {
        return delProcedure(point);
    }
}
