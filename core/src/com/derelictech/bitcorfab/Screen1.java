package com.derelictech.bitcorfab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
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
        uiStage = new Stage( new StretchViewport(CONST.SCREEN_W, CONST.SCREEN_H));

        Gdx.input.setInputProcessor(new InputMultiplexer(uiStage, stage));

        Image bg_rect2 = new Image(new Texture("bg_rect.png"));
        bg_rect2.setSize(CONST.WORLD_W, CONST.WORLD_H);
        stage.addActor(bg_rect2);

        button1 = new VoxButton("buttons/button_style1.png","buttons/button_style1_down.png");
        button1.setPosition(20, 20);
        button1.setSize(8, 6);
        stage.addActor(button1);

        Image bg_rect = new Image(new Texture("bg_rect.png"));
        uiStage.addActor(bg_rect);

        float w = 700;
        float h = 200;

        VoxScalingText hi1 = new VoxScalingText("ÄyABCDEFGHI");
        hi1.setWidth(w);
        hi1.setHeight(h);
        Table hi1table = new Table();
        hi1table.debug();
        hi1table.addActor(hi1);

        VoxScalingText hi2 = new VoxScalingText("JKLMNOPQRST");
        hi2.setWidth(w);
        hi2.setHeight(h);
        Table hi2table = new Table();
        hi2table.debug();
        hi2table.addActor(hi2);
        hi2table.setPosition(0, h);

        VoxScalingText hi3 = new VoxScalingText("UVWXYZ");
        hi3.setWidth(w);
        hi3.setHeight(h);
        Table hi3table = new Table();
        hi3table.debug();
        hi3table.addActor(hi3);
        hi3table.setPosition(0, h * 2.0f);

        Table uiStageTable = new Table();
        uiStageTable.setFillParent(true);

        uiStageTable.addActor(hi1table);
        uiStageTable.row();
        uiStageTable.addActor(hi2table);
        uiStageTable.row();
        uiStageTable.addActor(hi3table);
        uiStageTable.row();
        uiStage.addActor(uiStageTable);

        uiStage.setDebugAll(true);
        hi1table.setDebug(true);
        hi2table.setDebug(true);
        hi3table.setDebug(true);
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
//        uiStage.getCamera().position.set(width / 2.0f, height / 2.0f, 1.0f);

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
