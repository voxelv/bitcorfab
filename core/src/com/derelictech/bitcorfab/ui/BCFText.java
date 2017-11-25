package com.derelictech.bitcorfab.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.derelictech.bitcorfab.CONST;
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

    private Vector2 textSize;
    private float textScale;
    private boolean scrolling;
    private float scrollSpeed;
    private float scrollOffset;

    public BCFText(String text, BCFTiler tiler, float size) {
        super();

        this.text = text;
        this.tiler = tiler;

        textSize = this.tiler.getDimensions(this.text);
        textScale = size;

        scrolling = true;
        scrollSpeed = CONST.TEXT_SCROLL_SPEED;
        scrollOffset = 0.0f;

        setHeight(textSize.y * textScale);
    }

    public BCFText setText(String text) {
        this.text = text;
        this.textSize = tiler.getDimensions(this.text);
        return this;
    }

    public BCFText setScrolling(boolean scrolling) {
        this.scrolling = scrolling;
        return this;
    }

    public BCFText setScrollSpeed(float scrollSpeed) {
        this.scrollSpeed = scrollSpeed;
        return this;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(scrolling && (textSize.x * textScale) > getWidth()) {
            scrollOffset += scrollSpeed;
            if(scrollOffset > (textSize.x * textScale)) {
                scrollOffset = -getWidth();
            }
        }
        else {
            scrollOffset = 0.0f;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.flush();
        if(clipBegin(getX(), getY(), getWidth(), getHeight())) {
            tiler.draw(batch, this.text, getX() - scrollOffset, getY(), textScale, getRotation());
            batch.flush();
            clipEnd();
        }
    }
}
