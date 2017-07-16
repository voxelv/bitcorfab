package com.derelictech.bitcorfab.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.derelictech.bitcorfab.BitCorFab;
import com.derelictech.bitcorfab.CONST;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = (int)CONST.SCREEN_W;
		config.height = (int)CONST.SCREEN_H;
		new LwjglApplication(new BitCorFab(), config);
	}
}
