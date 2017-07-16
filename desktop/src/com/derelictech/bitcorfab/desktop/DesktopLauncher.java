package com.derelictech.bitcorfab.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.derelictech.bitcorfab.BitCorFab;
import com.derelictech.bitcorfab.CONST;

public class DesktopLauncher {
	public static void main (String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode((int)CONST.SCREEN_W, (int)CONST.SCREEN_H);
		new Lwjgl3Application(new BitCorFab(), config);
	}
}
