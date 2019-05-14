package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import com.mygdx.game.MainGame;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

import java.util.Arrays;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.util.glu.GLU.*;
import static org.lwjgl.BufferUtils.*;

public class DesktopLauncher {

	public static void main (String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		Graphics.DisplayMode desktop =
				LwjglApplicationConfiguration.getDesktopDisplayMode();
		//config.setFromDisplayMode(desktop);
		config.fullscreen = false;
		config.width = desktop.width-10;
		config.height = desktop.height-200;
		config.x = 0;
		config.y = 0;
		new LwjglApplication(new MainGame(), config);
	}
}
