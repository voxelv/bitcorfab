package com.derelictech.bitcorfab.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.derelictech.bitcorfab.CONST;

import java.util.HashMap;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.ui
 * Author:  voxelv
 * Creation Date: 2017-07-22
 * Description:
 */
public class VoxScalingText extends Actor {
    String text;

    int idealPx;
    int currentPx;

    float xscl;
    float yscl;

    HashMap<Integer, Float> layoutWidths;
    HashMap<Integer, Float> layoutHeights;

    public VoxScalingText(String displayText, int preferedFontSize) {
        layoutWidths = new HashMap<Integer, Float>(VoxAssets.voxelv_freemono_font_sizes.length);
        layoutHeights = new HashMap<Integer, Float>(VoxAssets.voxelv_freemono_font_sizes.length);
        // Start with the first size in the list of available sizes
        idealPx = VoxAssets.voxelv_freemono_font_sizes[0];

        // Loop to find the nearest one
        for(int size : VoxAssets.voxelv_freemono_font_sizes) {
            // If the difference between the sizes is smaller than any previous, set the nearest to that size
            if(Math.abs(preferedFontSize - size) < Math.abs(preferedFontSize - idealPx)) {
                idealPx = size;
            }
        }
        currentPx = idealPx;

        text = displayText;

        setupLayouts();
    }

    private void setupLayouts() {
        BitmapFont font;
        GlyphLayout layout = new GlyphLayout();

        layoutWidths.clear();
        layoutHeights.clear();
        for(Integer i : VoxAssets.voxelv_freemono_font_sizes) {
            font = VoxAssets.getVoxelvFreemonoFont(i);
            layout.setText(VoxAssets.getVoxelvFreemonoFont(i), text);
            layoutWidths.put(i, layout.width);
            layoutHeights.put(i, font.getCapHeight() - font.getDescent());
        }
    }

    private void setupFont() {
        xscl = Gdx.graphics.getWidth() / CONST.SCREEN_W;
        yscl = Gdx.graphics.getHeight() / CONST.SCREEN_H;

        int maxWPx = VoxAssets.voxelv_freemono_font_sizes[0];
        for(Integer i : VoxAssets.voxelv_freemono_font_sizes) {
            if(layoutWidths.get(i) > (getWidth() * xscl)) {
                break;
            }
            maxWPx = i;
        }

        int maxHPx = VoxAssets.voxelv_freemono_font_sizes[0];
        for(Integer i : VoxAssets.voxelv_freemono_font_sizes) {
            if(layoutHeights.get(i) > (getHeight() * yscl)) {
                break;
            }
            maxHPx = i;
        }

        currentPx = (maxWPx < maxHPx) ? maxWPx : maxHPx;
    }

    public void setText(String text) {
        this.text = text;
        setupLayouts();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        setupFont();
        BitmapFont font = VoxAssets.getVoxelvFreemonoFont(currentPx);
        font.getData().setScale(1.0f / xscl, 1.0f / yscl);
        font.draw(batch, text, getX(), getY() + getHeight());
        font.getData().setScale(1.0f);
    }
}
