package com.derelictech.bitcorfab.prototyping.grid;

import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping.grid
 * Author:  voxelv
 * Creation Date: 2017-11-24
 * Description:
 */
public class ActorGrid extends Group {
    public Grid<Actor> grid;
    private Vector2 cellSize;

    public ActorGrid(float cell_w, float cell_h) {
        grid = new Grid<Actor>();
        cellSize = new Vector2(cell_w, cell_h);
    }

    public Actor addToGrid(Actor actor, GridPoint2 gp) {
        // Add to grid
        Actor retActor = grid.addToGrid(actor, gp);

        // Set actor position
        Vector2 pos = GridUtil.coordToPos(cellSize, gp);
        actor.setPosition(pos.x, pos.y);

        // Set actor size
        actor.setSize(cellSize.x, cellSize.y);

        // Add to children
        addActor(actor);

        // Resize
        setSize((grid.cols) * cellSize.x, (grid.rows) * cellSize.y);

        return retActor;
    }

    public Actor getFromGrid(GridPoint2 gp) {
        return grid.getFromGrid(gp);
    }

    public Actor removeFromGrid(GridPoint2 gp) {
        Actor a = grid.removeFromGrid(gp);

        // Remove from children
        removeActor(a);

        return a;
    }
}
