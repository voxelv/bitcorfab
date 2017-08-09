package com.derelictech.bitcorfab.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.derelictech.bitcorfab.CONST;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.ui
 * Author:  voxelv
 * Creation Date: 2017-07-22
 * Description:
 */
public class VoxScalingText extends Actor {
    GlyphLayout layout;
    BitmapFont font;
    String text;
    float lineHeight;
    float prev_w = CONST.SCREEN_W;
    float prev_h = CONST.SCREEN_H;

    public VoxScalingText(String displayText, int preferedFontSize) {
        // Start with the first size in the list of available sizes
        int nearest_size = VoxAssets.voxelv_freemono_font_sizes[0];

        // Loop to find the nearest one
        for(int size : VoxAssets.voxelv_freemono_font_sizes) {
            // If the difference between the sizes is smaller than any previous, set the nearest to that size
            if(Math.abs(preferedFontSize - size) < Math.abs(preferedFontSize - nearest_size)) {
                nearest_size = size;
            }
        }

        // Get the font closest to the preferedSize
        font = VoxAssets.getVoxelvFreemonoFont(nearest_size);
        text = displayText;

        layout = new GlyphLayout();
        layout.setText(font, text); // TODO: Use layout to figure out how big it will draw and do something about the size or something
    }

    private void setupFont() {
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setupFont();
        font.draw(batch, text, getX(), getY() + getHeight());
    }

    private float distSqr(float x1, float y1, float x2, float y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
