package com.derelictech.bitcorfab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
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

    public Screen1() {
        super();
        batch = new SpriteBatch();
        img = new Texture("measure.png");

        if(Gdx.graphics.getGL30() != null)
            System.out.println("OPENGL30");
        if(Gdx.graphics.getGL20() != null)
            System.out.println("OPENGL20");

        System.out.println(Gdx.graphics.getType().toString());
        System.out.println(Gdx.graphics.getDisplayMode().toString());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

}
