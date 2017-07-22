package com.derelictech.bitcorfab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;

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
    VoxButton button1;

    public Screen1() {
        stage = new Stage( new FitViewport(CONST.WORLD_W, CONST.WORLD_H));

        Gdx.input.setInputProcessor(stage);

//        // Image no stretch (maintain aspect ration of original image)
//        img = new Image(new Texture("test_img.png"));
//        Vector2 imageSize = Scaling.fit.apply(CONST.WORLD_W, CONST.WORLD_W, CONST.WORLD_W, CONST.WORLD_H);
//        img.setSize(imageSize.x, imageSize.y);
//        img.setPosition(
//                (CONST.WORLD_W - imageSize.x) / 2.0f,
//                (CONST.WORLD_H - imageSize.y) / 2.0f
//        );
//        stage.addActor(img);

        button1 = new VoxButton("buttons/button_style1.png", "buttons/button_style1_down.png");
        button1.setPosition(32, 32);
        button1.setSize(8, 6);
        stage.addActor(button1);


        // debugGraphicsCalls();
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        //debugGraphicsCalls();
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
