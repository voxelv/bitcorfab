package com.derelictech.bitcorfab.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/**
 * Project: bitcorfab
 * Package: com.derelictech.bitcorfab.ui
 * Author:  voxelv
 * Creation Date: 2017-11-25
 * Description:
 */
public class ClippingArea extends Group {
    public ClippingArea(Actor child) {
        super();
        addActor(child);
        setTouchable(Touchable.childrenOnly);
    }

    @Override
    protected void sizeChanged() {
        super.sizeChanged();
        getChildren().get(0).setBounds(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.flush();
        if(clipBegin()) {
            super.draw(batch, parentAlpha);
            batch.flush();
            clipEnd();
        }
    }
}
