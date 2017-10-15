package com.derelictech.bitcorfab;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab
 * Author:  voxelv
 * Creation Date: 2017-10-12
 * Description:
 */
class BCFScreenAdapter extends ScreenAdapter {
    static Game game;

    protected Stage stage;
    protected Table root;

    BCFScreenAdapter(Game g) {
        game = g;
    }

    @Override
    public void show() {
        /* Setup stage */
        stage = new Stage(new FitViewport(CONST.WORLD_W, CONST.WORLD_H));

        /* Setup root table */
        root = new Table();
        stage.addActor(root);
        root.setFillParent(true);

        /* Reset the input processor each time this screen is shown */
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void hide() {
        stage.dispose();
    }
}
