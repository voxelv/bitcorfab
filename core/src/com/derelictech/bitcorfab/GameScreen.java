package com.derelictech.bitcorfab;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Json;
import com.derelictech.bitcorfab.prototyping.tiler.BCFText;
import com.derelictech.bitcorfab.prototyping.tiler.BCFTiler;
import com.derelictech.bitcorfab.prototyping.tiler.BCFTilerJsonData;
import com.derelictech.bitcorfab.prototyping.tiler.BCFTileSetJsonData;

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

//        root.addActor(grid);

//        Json json = new Json();
//        json.setElementType(BCFTilerJsonData.class, "sets", BCFTileSetJsonData.class);
//        BCFTilerJsonData tiler = json.fromJson(BCFTilerJsonData.class, Gdx.files.internal("font/tilefont5x5/bcf_font_grid5x5.json"));
//
//        BCFTileSetJsonData tileset = (BCFTileSetJsonData)tiler.sets.get("lc");
//
//        int startX = tileset.startX;
//        int startY = tileset.startY;
//        int width = tileset.width;
//        int height = tileset.height;
//        int xPad = tileset.xPad;
//        int yPad = tileset.yPad;
//        int numChars = tileset.cols;
//
//        float drawAtX = 0.0f;
//        float drawAtY = 0.0f;
//        float scale = 0.33f;
//
//        TextureRegion upper = new TextureRegion(
//                new Texture(Gdx.files.internal("font/tilefont5x5/bcf_font_grid5x5.png")),
//                startX,
//                startY,
//                (width + xPad) * numChars,
//                height + yPad
//        );
//
//        TextureRegion[][] regions = upper.split((width + xPad), (height + yPad));
//
//        int idx = 0;
//        for(TextureRegion tr : regions[0]) {
//            Image i = new Image(tr);
//            i.setPosition(drawAtX + (idx * width * scale), drawAtY);
//            i.setSize((float)width * scale, (float)height * scale);
////            root.addActor(i);
//            idx++;
//        }

        BCFTiler tilefont5x5 = new BCFTiler("font/tilefont5x5/bcf_font_grid5x5.json");

//        int idx2 = 0;
//        for(TextureRegion tr : tilefont5x5.regionsFromString("ABCdef")) {
//            Image i = new Image(tr);
//            i.setPosition(drawAtX + (idx2 * width * scale), drawAtY);
//            i.setSize((float)width * scale, (float)height * scale);
////            root.addActor(i);
//            idx2++;
//        }

        BCFText mytext = new BCFText("Hello World! 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", tilefont5x5);
        mytext.setScale(0.25f);
        root.addActor(mytext);
    }

}
