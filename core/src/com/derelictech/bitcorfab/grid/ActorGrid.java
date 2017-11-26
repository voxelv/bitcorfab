package com.derelictech.bitcorfab.grid;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;

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

        setTouchable(Touchable.enabled);

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                Gdx.app.debug("GRID", GridUtil.posToCoord(cellSize, new Vector2(x, y)).toString());
            }
        });
    }

    public Actor addToGrid(Actor actor, GridPoint2 gp) {
        // Add to grid
        Actor retActor = grid.addToGrid(actor, gp);

        actor.setTouchable(Touchable.disabled);

        // Set actor position
        Vector2 pos = GridUtil.coordToPos(cellSize, gp);
        actor.setPosition(pos.x, pos.y);

        // Set actor size
        actor.setSize(cellSize.x, cellSize.y);

        // Add to children
        addActor(actor);

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
