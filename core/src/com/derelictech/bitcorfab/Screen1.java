package com.derelictech.bitcorfab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.HdpiUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab
 * Author:  voxelv
 * Creation Date: 2017-07-13
 * Description:
 */
public class Screen1 extends ScreenAdapter {
    Image img;
    Image img2;
    Stage stage;

    public Screen1() {
        stage = new Stage( new StretchViewport(CONST.WORLD_W, CONST.WORLD_H));

        Gdx.input.setInputProcessor(stage);

        // Image no stretch (maintain aspect ration of original image)
        img = new Image(new Texture("test_img.png"));
        Vector2 imageSize = Scaling.fit.apply(CONST.WORLD_W, CONST.WORLD_W, CONST.WORLD_W, CONST.WORLD_H);
        img.setSize(imageSize.x, imageSize.y);
        img.setPosition((CONST.WORLD_W - imageSize.x) / 2, (CONST.WORLD_H - imageSize.y) / 2f);
        stage.addActor(img);

        // Image stretch
        img2 = new Image(new Texture("test_img.png"));
        img2.setSize(CONST.WORLD_W, CONST.WORLD_H);
        img2.setPosition(0f, 0f);
        stage.addActor(img2);
        stage.setDebugAll(true);

        debugGraphicsCalls();
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        debugGraphicsCalls();
    }

    private void debugGraphicsCalls() {
        if(Gdx.graphics.getGL30() != null)
            System.out.println("OPENGL30");
        if(Gdx.graphics.getGL20() != null)
            System.out.println("OPENGL20");

        System.out.println("getType: " + Gdx.graphics.getType().toString());
        System.out.println("getDisplayMode: " + Gdx.graphics.getDisplayMode().toString());
        System.out.println("Backbuffer width: " + Gdx.graphics.getBackBufferWidth());
        System.out.println("getWidth: " + Gdx.graphics.getWidth());
        System.out.println("Viewport origin: " + stage.getViewport().getScreenX() + ", " + stage.getViewport().getScreenY());
    }
}
