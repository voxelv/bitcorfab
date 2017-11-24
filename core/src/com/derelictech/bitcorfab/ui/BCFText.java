package com.derelictech.bitcorfab.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.derelictech.bitcorfab.ui.data.BCFTiler;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.ui
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
        Vector2 size = tiler.getDimensions(this.text);
        this.setSize(size.x * getScaleX(), size.y * getScaleY());
    }

    public void setText(String text) {
        this.text = text;
        Vector2 size = this.tiler.getDimensions(text);
        this.setSize(size.x * getScaleX(), size.y * getScaleY());
    }

    @Override
    public void setScale(float scaleXY) {
        super.setScale(scaleXY);
        Vector2 size = this.tiler.getDimensions(this.text);
        this.setSize(size.x * getScaleX(), size.y * getScaleY());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        tiler.draw(batch, this.text, getX(), getY(), getScaleX(), getScaleY(), getRotation());
    }
}
