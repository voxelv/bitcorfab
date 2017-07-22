package com.derelictech.bitcorfab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.derelictech.bitcorfab.ui.VoxButton;
import com.derelictech.bitcorfab.ui.VoxScalingText;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab
 * Author:  voxelv
 * Creation Date: 2017-07-13
 * Description:
 */
public class Screen1 extends ScreenAdapter {
    Stage stage;
    Stage uiStage;
    VoxButton button1;

    public Screen1() {
        stage = new Stage( new FitViewport(CONST.WORLD_W, CONST.WORLD_H));
        uiStage = new Stage( new ScreenViewport());

        Gdx.input.setInputProcessor(stage);

        button1 = new VoxButton("buttons/button_style1.png", "buttons/button_style1_down.png");
        button1.setPosition(32, 32);
        button1.setSize(8, 6);
        stage.addActor(button1);

        VoxScalingText hi = new VoxScalingText("Hello World");
        hi.setPosition(0, 8);
        uiStage.addActor(hi);

        // debugGraphicsCalls();
    }

    @Override
    public void render(float delta) {
        stage.act();
        uiStage.act();
        stage.draw();
        uiStage.draw();
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
