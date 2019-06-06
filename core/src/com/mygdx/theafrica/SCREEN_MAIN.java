package com.mygdx.theafrica;

import com.badlogic.gdx.*;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.GL20;


public class SCREEN_MAIN implements Screen {

	String TAG_LIFECYCLE = "LIFECYCLE";
	public WorldController controller;
	public WorldRenderer renderer;
	public InputManager iProcessor;
	public Screen screen;
	public MAIN_GAME gameMain;
	public LevelManager levelManager;
	public int numPlayers;


	public SCREEN_MAIN(MAIN_GAME gameMain) {
		this.gameMain= gameMain;
	}

	@Override
	public void show() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Gdx.app.debug(TAG_LIFECYCLE, "Created");
		CameraHelper helper = new CameraHelper();
		levelManager = new LevelManager(helper);
		controller = new WorldController(levelManager);
		iProcessor = new InputManager();
		Gdx.input.setInputProcessor(iProcessor);
		renderer = new WorldRenderer(controller);

		Controllers c;
	}

	@Override
	public void render(float delta) {
		controller.update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.render();
		//iProcessor.Update();

	}

	@Override
	public void resize(int width, int height) {
		renderer.resize(width,height);
		Gdx.app.debug(TAG_LIFECYCLE, "Resized to: "+ height + "x" + width);
		levelManager.hudCamera.viewportWidth = width;
		levelManager.hudCamera.viewportHeight = height;
		//0,0 in the lower left corner
		levelManager.hudCamera.position.x = width/2;
		levelManager.hudCamera.position.y = height/4;
		levelManager.hudCamera.update();


	}

	@Override
	public void pause() {
		Gdx.app.debug(TAG_LIFECYCLE, "Paused");
	}

	@Override
	public void resume() {
		Gdx.app.debug(TAG_LIFECYCLE, "Resumed");
	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		Gdx.app.debug(TAG_LIFECYCLE, "Disposed");
	}
}
