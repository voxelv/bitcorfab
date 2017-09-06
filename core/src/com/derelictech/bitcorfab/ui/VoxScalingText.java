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

    int currentPx;
    float currentFontXScale;
    float currentFontYScale;

    HashMap<Integer, Float> layoutWidths;
    HashMap<Integer, Float> layoutHeights;

    public VoxScalingText(String displayText) {
        layoutWidths = new HashMap<Integer, Float>(VoxAssets.voxelv_freemono_font_sizes.length);
        layoutHeights = new HashMap<Integer, Float>(VoxAssets.voxelv_freemono_font_sizes.length);
        // Start with the first size in the list of available sizes
        currentPx = VoxAssets.voxelv_freemono_font_sizes[0];

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
        float xscl = Gdx.graphics.getWidth() / CONST.SCREEN_W;
        float yscl = Gdx.graphics.getHeight() / CONST.SCREEN_H;

        int maxWPx = VoxAssets.voxelv_freemono_font_sizes[0];
        for(Integer i : VoxAssets.voxelv_freemono_font_sizes) {
            maxWPx = i;
            if(layoutWidths.get(i) > (getWidth() * xscl)) {
                break;
            }
        }

        int maxHPx = VoxAssets.voxelv_freemono_font_sizes[0];
        for(Integer i : VoxAssets.voxelv_freemono_font_sizes) {
            maxHPx = i;
            if(layoutHeights.get(i) > (getHeight() * yscl)) {
                break;
            }
        }

        currentPx = (maxWPx < maxHPx) ? maxWPx : maxHPx;
        float fontXScale = getWidth()/layoutWidths.get(currentPx);
        float fontYScale = getHeight()/layoutHeights.get(currentPx);

        currentFontXScale = fontXScale < (1.0f / xscl) ? fontXScale : (1.0f / xscl);
        currentFontYScale = fontYScale < (1.0f / yscl) ? fontYScale : (1.0f / yscl);
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
        font.getData().setScale(currentFontXScale, currentFontYScale);
        font.draw(batch, text, getX(), getY() + getHeight());
    }
}
