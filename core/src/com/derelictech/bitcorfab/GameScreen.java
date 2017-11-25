package com.derelictech.bitcorfab;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.GridPoint2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.derelictech.bitcorfab.prototyping.grid.ActorGrid;
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

        ActorGrid grid = new ActorGrid(10.0f, 10.0f);
        grid.setPosition(1, 1);
        Image grid_item_base = new Image(new Texture(Gdx.files.internal("items/grid_item_base.png")));
        Image grid_item_a = new Image(new Texture(Gdx.files.internal("items/grid_item_a.png")));
        Image grid_item_b = new Image(new Texture(Gdx.files.internal("items/grid_item_b.png")));
        Image grid_item_phi = new Image(new Texture(Gdx.files.internal("items/grid_item_phi.png")));
        Image grid_item_xi = new Image(new Texture(Gdx.files.internal("items/grid_item_xi.png")));

        grid.addToGrid(grid_item_base, new GridPoint2(0, 0));
        grid.addToGrid(grid_item_a, new GridPoint2(1, 1));
        grid.addToGrid(grid_item_b, new GridPoint2(2, 2));
        grid.addToGrid(grid_item_phi, new GridPoint2(3, 3));
        grid.addToGrid(grid_item_xi, new GridPoint2(4, 4));

        Gdx.app.debug("GRID", grid.grid.toString());

        tileFont5x5 = new BCFTiler("font/tilefont5x5/bcf_font_grid5x5.json");
        root.top().left();

        BCFText mytext = new BCFText("0123456789\nABCDEFGHIJKLMNOPQRSTUVWXYZ\nabcdefghijklmnopqrstuvwxyz",
                tileFont5x5,
                0.5f);
        root.add(mytext).left().fill();
        root.row();

        BCFText symbolsTest = new BCFText("!@#$%^&*()`-=[]\\;',./~_+{}|:\"<>?",
                tileFont5x5,
                0.5f)
                .setScrollSpeed(0.2f);
        root.add(symbolsTest).left().fill();
        root.row();

        BCFText bitcorfab = new BCFText("BIT COR FAB",
                tileFont5x5,
                0.5f);
        root.add(bitcorfab).left().fill();
        root.row();

        root.add(grid).left();

        stage.setDebugAll(true);

        stage.addListener(new InputListener(){
            @Override
            public boolean keyUp(InputEvent event, int keycode) {
                Gdx.app.debug("STAGE", "key: " + keycode);

                OrthographicCamera camera = ((OrthographicCamera)stage.getCamera());
                switch(keycode) {
                    case Input.Keys.EQUALS:
                        camera.zoom -= 0.1f;
                        Gdx.app.debug("DO", "zoom+ " + ((OrthographicCamera)stage.getCamera()).zoom);
                        break;
                    case Input.Keys.MINUS:
                        camera.zoom += 0.1f;
                        Gdx.app.debug("DO", "zoom- " + ((OrthographicCamera)stage.getCamera()).zoom);
                        break;
                    case Input.Keys.LEFT:
                        camera.position.x -= 1.0f;
                        Gdx.app.debug("DO", "LEFT " + camera.position.x);
                        break;
                    case Input.Keys.RIGHT:
                        camera.position.x += 1.0f;
                        Gdx.app.debug("DO", "RIGHT " + camera.position.x);
                        break;
                    case Input.Keys.UP:
                        camera.position.y += 1.0f;
                        Gdx.app.debug("DO", "UP " + camera.position.y);
                        break;
                    case Input.Keys.DOWN:
                        camera.position.y -= 1.0f;
                        Gdx.app.debug("DO", "DOWN " + camera.position.y);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public void hide() {
        super.hide();
        tileFont5x5.dispose();
    }
}
