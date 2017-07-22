package com.derelictech.bitcorfab.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.ui
 * Author:  voxelv
 * Creation Date: 2017-07-22
 * Description:
 */
public class VoxScalingText extends Actor {
    BitmapFont font;
    String text;
    float lineHeight;

    public VoxScalingText(String displayText) {
        font = VoxAssets.voxelv_freemono_96;
        text = displayText;
        setupFont();
    }

    private void setupFont() {
        lineHeight = font.getLineHeight();
        setHeight(lineHeight);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setupFont();
        font.draw(batch, text, getX(), getY() + getHeight());
    }
}
