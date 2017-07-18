package com.derelictech.bitcorfab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.HdpiUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab
 * Author:  voxelv
 * Creation Date: 2017-07-13
 * Description:
 */
public class Screen1 extends ScreenAdapter {
    Image img;
    Stage stage;

    public Screen1() {
        stage = new Stage( new FitViewport(CONST.VIEWPORT_W, CONST.VIEWPORT_H));

        Gdx.input.setInputProcessor(stage);

        img = new Image(new Texture("test_img.png"));
        img.setPosition(0, 0);
        img.setSize(10.0f, 10.0f);
        Table table = new Table();
        table.addActor(img);
        table.setFillParent(true);
        stage.addActor(table);
        stage.setDebugAll(true);
        System.out.println(stage.getViewport().getScreenX() + ", " + stage.getViewport().getScreenY());

//        if(Gdx.graphics.getGL30() != null)
//            System.out.println("OPENGL30");
//        if(Gdx.graphics.getGL20() != null)
//            System.out.println("OPENGL20");

//        System.out.println(Gdx.graphics.getType().toString());
//        System.out.println(Gdx.graphics.getDisplayMode().toString());
//        System.out.println("Backbuffer width: " + Gdx.graphics.getBackBufferWidth());
//        System.out.println("getWidth: " + Gdx.graphics.getWidth());
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
//        stage.getViewport().getCamera().position.set(CONST.WORLD_W / 2.0f, CONST.WORLD_W / 2.0f, 0.0f);
//        stage.getViewport().getCamera().update();
    }
}
