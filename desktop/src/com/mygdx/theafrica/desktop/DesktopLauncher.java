package com.mygdx.theafrica.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.theafrica.MAIN_GAME;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.fullscreen = true;
		config.height= LwjglApplicationConfiguration.getDesktopDisplayMode().width - 150;
		config.width= LwjglApplicationConfiguration.getDesktopDisplayMode().height - 100;
		new LwjglApplication(new MAIN_GAME(), config);
	}
}
