package com.mygdx.theafrica;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {

    String TAG_LIFECYCLE = "LIFECYCLE";
    public WorldController controller;
    public WorldRenderer renderer;
    public InputManager iProcessor;
    public Screen screen;
    public MyGame gameMain;
    public Level level;

    public GameScreen(MyGame gameMain, int numPlayers) {
        this.gameMain= gameMain;
    }

    public GameScreen(MyGame myGame) {
    }

    @Override
    public void show() {
        
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
