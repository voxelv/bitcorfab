package com.derelictech.bitcorfab.prototyping;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.derelictech.bitcorfab.CONST;

import java.util.HashMap;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping
 * Author:  voxelv
 * Creation Date: 2017-07-22
 * Description:
 */
public class VoxScalingText extends Actor {
    String text;

    int lines;
    int currentPx;
    float currentFontXScale;
    float currentFontYScale;

    // Widths and Heights for each font size.
    HashMap<Integer, Float> layoutWidths;
    HashMap<Integer, Float> layoutHeights;

    public VoxScalingText(String displayText) {
        layoutWidths = new HashMap<Integer, Float>(VoxAssets.voxelv_freemono_font_sizes.length);
        layoutHeights = new HashMap<Integer, Float>(VoxAssets.voxelv_freemono_font_sizes.length);
        // Start with the first size in the list of available sizes
        currentPx = VoxAssets.voxelv_freemono_font_sizes[0];

        text = displayText;

        calculateLines();
        setupLayouts();
        setupFont();
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

        // Determine the latest screen size ratio
        currentFontXScale = CONST.SCREEN_W / Gdx.graphics.getWidth();
        currentFontYScale = CONST.SCREEN_H / Gdx.graphics.getHeight();

        // Determine the maximum font size that can fit horizontally
        int maxWPx = VoxAssets.voxelv_freemono_font_sizes[0];
        for(Integer i : VoxAssets.voxelv_freemono_font_sizes) {
            if(layoutWidths.get(i) > (getWidth() / currentFontXScale)) {
                break;
            }
            maxWPx = i;
        }

        // Determine the maximum font size that can fit vertically
        int maxHPx = VoxAssets.voxelv_freemono_font_sizes[0];
        for(Integer i : VoxAssets.voxelv_freemono_font_sizes) {
            if((layoutHeights.get(i) * lines) > ((getHeight() - VoxAssets.getVoxelvFreemonoFont(i).getAscent()) / currentFontYScale)) {
                break;
            }
            maxHPx = i;
        }

        // Use the smaller of the two maximums
        currentPx = (maxWPx < maxHPx) ? maxWPx : maxHPx;
    }

    public void setText(String text) {
        // Set the text and redetermine the layout sizes
        this.text = text;
        calculateLines();
        setupLayouts();
    }

    private void calculateLines() {
        lines = 1;
        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '\n') {
                lines++;
            }
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // Recalculate max font size
        setupFont();

        // Get the font that will fit
        BitmapFont font = VoxAssets.getVoxelvFreemonoFont(currentPx);

        // Determine where to draw (CENTERED, TOP)
        float drawX = getX() + (getWidth() / 2.0f) - (layoutWidths.get(currentPx) * currentFontXScale / 2.0f);
        float drawY = getY() + (getHeight());// - ((layoutHeights.get(currentPx) * lines) / 2.0f);

        // Scale appropriately and draw
        font.getData().setScale(currentFontXScale, currentFontYScale);
        font.draw(batch, text, drawX, drawY);
    }

    public String getTestString() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ\nabcdefghijklmnopqrstuvwxyz\n`1234567890-=~!@#$%^&*()_+\n[]\\;',./{}|:\"<>?ΦΞgypt";
    }
}
