package com.derelictech.bitcorfab.prototyping;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.derelictech.bitcorfab.ui.VoxButton;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping
 * Author:  voxelv
 * Creation Date: 2017-07-22
 * Description:
 */
public class VoxTextButton extends VoxButton {
    BitmapFont font;


    public VoxTextButton(String buttonUpFilename, String buttonDownFilename, String display_text) {
        super(buttonUpFilename, buttonDownFilename);
    }

}
