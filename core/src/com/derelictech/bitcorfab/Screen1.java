package com.derelictech.bitcorfab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
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
        stage = new Stage( new FitViewport(CONST.WORLD_W, CONST.WORLD_H, new OrthographicCamera()));
        uiStage = new Stage( new ScreenViewport(new OrthographicCamera()));

        Gdx.input.setInputProcessor(new InputMultiplexer(uiStage, stage));

        button1 = new VoxButton("buttons/button_style1.png","buttons/button_style1_down.png");
        button1.setPosition(20, 20);
        button1.setSize(8, 6);
        stage.addActor(button1);

        Image bg_rect = new Image(new Texture("bg_rect.png"));
        uiStage.addActor(bg_rect);

        VoxScalingText hi = new VoxScalingText("Hello World", 16);
        hi.setBounds(30, 30, 200, 50);
        Table uiStageTable = new Table();
        uiStageTable.setFillParent(true);

        uiStageTable.bottom().left();
        uiStageTable.addActor(hi);
        uiStage.addActor(uiStageTable);

        uiStage.setDebugAll(true);
//        debugGraphicsCalls();
    }

    @Override
    public void render(float delta) {
        stage.getViewport().apply();
        stage.act();
        stage.draw();

        uiStage.getViewport().apply();
        uiStage.act();
        uiStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
        uiStage.getViewport().update(width, height);
        uiStage.getCamera().position.set(width / 2.0f, height / 2.0f, 1.0f);
//        debugGraphicsCalls();
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
