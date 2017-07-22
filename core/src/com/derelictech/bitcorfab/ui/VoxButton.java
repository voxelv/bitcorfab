package com.derelictech.bitcorfab.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab
 * Author:  voxelv
 * Creation Date: 2017-07-21
 * Description: a button that can be clicked
 */
public class VoxButton extends Actor {
    TextureRegion buttonUp;
    TextureRegion buttonDown;
    boolean pressed = false;

    public VoxButton(String buttonUpFilename, String buttonDownFilename) {
        buttonUp = new TextureRegion(new Texture(Gdx.files.internal(buttonUpFilename)));
        buttonDown = new TextureRegion(new Texture(Gdx.files.internal(buttonDownFilename)));

        setSize(6, 4);

        addListener(new ClickListener(Input.Buttons.LEFT){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                boolean returnValue = super.touchDown(event, x, y, pointer, button);
                pressed = true;
                return returnValue;
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                pressed = false;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                pressed = false;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color tmp_color = batch.getColor();
        batch.setColor(Color.RED);

        batch.draw(pressed ? buttonDown : buttonUp, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
                   getScaleX(), getScaleY(), getRotation());

        batch.setColor(tmp_color);
    }
}
