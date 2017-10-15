package com.derelictech.bitcorfab;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab
 * Author:  voxelv
 * Creation Date: 2017-07-13
 * Description:
 */
public class GameScreen extends BCFScreenAdapter {

    public GameScreen(Game g) {
        super(g);
    }

    @Override
    public void show() {
        super.show();

        Image bg = new Image(new Texture("bg_rect.png"));
        bg.setSize(CONST.WORLD_W, CONST.WORLD_H);
        stage.addActor(bg);

        BCFGrid<Image> grid = new BCFGrid<Image>();
        grid.setPosition(1, 1);
        Image grid_item_base = new Image(new Texture(Gdx.files.internal("items/grid_item_base.png")));
        Image grid_item_a = new Image(new Texture(Gdx.files.internal("items/grid_item_a.png")));
        Image grid_item_b = new Image(new Texture(Gdx.files.internal("items/grid_item_b.png")));
        Image grid_item_phi = new Image(new Texture(Gdx.files.internal("items/grid_item_phi.png")));
        Image grid_item_xi = new Image(new Texture(Gdx.files.internal("items/grid_item_xi.png")));

        grid.set(0, 0, grid_item_base);
        grid.set(1, 1, grid_item_a);
        grid.set(2, 2, grid_item_b);
        grid.set(3, 3, grid_item_phi);
        grid.set(4, 4, grid_item_xi);
        grid.set(3, 4, grid_item_xi);

        root.addActor(grid);
    }

}
