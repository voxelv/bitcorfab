package com.derelictech.bitcorfab;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Scaling;
import com.derelictech.bitcorfab.prototyping.tiler.BCFTiler;
import com.derelictech.bitcorfab.prototyping.tiler.BCFTileSet;

import java.util.ArrayList;

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
//        stage.addActor(bg);

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

/**        root.addActor(grid);*/

//        ArrayList<BCFTiler.BCFTilerConfig.BCFTileSet> sets = new ArrayList<BCFTiler.BCFTilerConfig.BCFTileSet>();
//
//        BCFTiler.BCFTilerConfig.BCFCharacterSet uppercase = new BCFTiler.BCFTilerConfig.BCFCharacterSet(
//                "upper",
//                new GridPoint2(1, 1),
//                1,
//                5,
//                9,
//                CONST.uppercase
//        );
//        sets.add(uppercase);
//
//        BCFTiler.BCFTilerConfig tilerConfig= new BCFTiler.BCFTilerConfig(sets);
//        BCFTiler tiler = new BCFTiler("font/tilefont5x5/bcf_font_grid5x5.png", tilerConfig);
//
//        Image img = new Image(tiler.getRegion("upper", 0));
//        img.setSize(5f, 9f);
//        img.setPosition(0, 0);

        Json json = new Json();
        json.setElementType(BCFTiler.class, "sets", BCFTileSet.class);
        BCFTiler tiler = json.fromJson(BCFTiler.class, Gdx.files.internal("font/tilefont5x5/bcf_font_grid5x5.json"));

        int startX = 1;
        int startY = 25;
        int width = 5;
        int height = 5;
        int xPad = 1;
        int yPad = 1;
        float drawAtX = 0.0f;
        float drawAtY = 0.0f;
        float scale = 0.9f;
        int numChars = 26;

        TextureRegion upper = new TextureRegion(
                new Texture(Gdx.files.internal("font/tilefont5x5/bcf_font_grid5x5.png")),
                startX,
                startY,
                (width + xPad) * numChars,
                height + yPad
        );

        TextureRegion[][] regions = upper.split((width + xPad), (height + yPad));

        int idx = 0;
        for(TextureRegion tr : regions[0]) {
            Image i = new Image(tr);
            i.setPosition(drawAtX + (idx * width * scale), drawAtY);
            i.setSize((float)width * scale, (float)height * scale);
            root.addActor(i);
            idx++;
        }
    }

}
