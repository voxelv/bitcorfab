package com.derelictech.bitcorfab;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.derelictech.bitcorfab.ui.BCFText;
import com.derelictech.bitcorfab.ui.data.BCFTiler;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab
 * Author:  voxelv
 * Creation Date: 2017-07-13
 * Description:
 */
public class GameScreen extends BCFScreenAdapter {

    BCFTiler tileFont5x5;

    public GameScreen(Game g) {
        super(g);
    }

    @Override
    public void show() {
        super.show();

        Image bg = new Image(new Texture("bg_rect.png"));
        bg.setSize(CONST.WORLD_W, CONST.WORLD_H);

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

        tileFont5x5 = new BCFTiler("font/tilefont5x5/bcf_font_grid5x5.json");
        root.top().left();

        BCFText mytext = new BCFText("0123456789\nABCDEFGHIJKLMNOPQRSTUVWXYZ\nabcdefghijklmnopqrstuvwxyz", tileFont5x5);
        mytext.setScale(0.3f);
        root.add(mytext).left();
        root.row();

        BCFText symbolsTest = new BCFText("!@#$%^&*()`-=[]\\;',./~_+{}|:\"<>?", tileFont5x5);
        symbolsTest.setScale(0.5f);
        root.add(symbolsTest).left();
        root.row();

        BCFText bitcorfab = new BCFText("BITCORFAB", tileFont5x5);
        bitcorfab.setScale(1.25f);
        root.add(bitcorfab).left();
        root.row();

    }

    @Override
    public void hide() {
        super.hide();
        tileFont5x5.dispose();
    }
}
