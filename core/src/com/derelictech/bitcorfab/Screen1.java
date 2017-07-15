package com.derelictech.bitcorfab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab
 * Author:  voxelv
 * Creation Date: 2017-07-13
 * Description:
 */
public class Screen1 extends ScreenAdapter {
    SpriteBatch batch;
    Texture img;
    Camera camera;

    public Screen1() {
        camera = new OrthographicCamera(64, 64);
        batch = new SpriteBatch();
        img = new Texture("test_img.png");

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
    public void show() {
        Gdx.graphics.setWindowedMode(640, 480);
    }

    @Override
    public void render(float delta) {
        batch.setProjectionMatrix(camera.projection);
        batch.begin();
        batch.draw(img, -32, -32);
        batch.end();
    }

}
