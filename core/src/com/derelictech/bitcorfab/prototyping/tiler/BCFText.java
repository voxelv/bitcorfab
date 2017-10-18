package com.derelictech.bitcorfab.prototyping.tiler;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.prototyping.tiler
 * Author:  voxelv
 * Creation Date: 2017-10-17
 * Description:
 */
public class BCFText extends Actor {
    String text;
    BCFTiler tiler;

    public BCFText(String text, BCFTiler tiler) {
        super();
        this.text = text;
        this.tiler = tiler;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        tiler.draw(batch, this.text, getX(), getY(), getScaleX(), getScaleY(), getRotation());
    }
}
