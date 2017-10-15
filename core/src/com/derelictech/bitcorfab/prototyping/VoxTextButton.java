package com.derelictech.bitcorfab.prototyping;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping
 * Author:  voxelv
 * Creation Date: 2017-07-22
 * Description:
 */
public class VoxTextButton extends VoxButton {
    String text;
    Color textColor;
    BitmapFont font;

    public VoxTextButton(String buttonUpFilename, String buttonDownFilename, String display_text) {
        super(buttonUpFilename, buttonDownFilename);
        text = display_text;

        textColor = Color.WHITE;
    }

    public void setTextColor(Color color)
    {
        textColor = color;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

    }

}
