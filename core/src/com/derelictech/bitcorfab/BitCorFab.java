package com.derelictech.bitcorfab;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class BitCorFab extends Game {

    @Override
    public void create () {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        setScreen(new GameScreen(this));
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0.25f, 0.25f, 0.25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
    }
}
