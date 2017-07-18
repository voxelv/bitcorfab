package com.derelictech.bitcorfab.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.derelictech.bitcorfab.BitCorFab;
import com.derelictech.bitcorfab.CONST;

public class DesktopLauncher {
	public static void main (String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode((int)CONST.SCREEN_W, (int)CONST.SCREEN_H);
        config.setTitle("bitcorfab");
        config.setWindowIcon("bitcorfab_icon_16px.png", "bitcorfab_icon_64px.png", "bitcorfab_icon_256px.png");
        config.setHdpiMode(Lwjgl3ApplicationConfiguration.HdpiMode.Logical);
		new Lwjgl3Application(new BitCorFab(), config);
	}
}
