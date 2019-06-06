package com.mygdx.theafrica;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;
import com.mygdx.theafrica.HUD.HUD;
import com.mygdx.theafrica.HUD.TextButton;

public class SCREEN_MENU implements Screen {

    MAIN_GAME game;
    BitmapFont font;
    SpriteBatch batch;
    OrthographicCamera camera;
    public InputMenu iProcessor;
    public TextButton b1;
    public TextButton b2;
    public BackgroundMenu bg;

    //HUD THINGS
    public OrthographicCamera hudCamera;
    HUD hud;

    public SCREEN_MENU(final MAIN_GAME game) {
        SoundManager.reproduceMusic();
        bg = GOFactory.generateBRMenu(-Gdx.graphics.getWidth()/2,-Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        SoundManager.reproduceMusic();
        this.game = game;
        font = new BitmapFont();
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        //HUD THINGS
        hudCamera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        hud = new HUD();
        b1 = new TextButton("START ",Gdx.graphics.getWidth()/2.8f,Gdx.graphics.getHeight()/4,320,70)
        {
            @Override
            public void click() {
                game.setScreen(game.gameScreen);
            }
        };


        hud.add(b1);

        //
    }

    @Override
    public void show() {
        iProcessor = new InputMenu(this);
        Gdx.input.setInputProcessor(iProcessor);
    }

    @Override
    public void render(float delta) {


        //render
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        bg.draw(batch, delta);


        //font.draw(batch,"Click Anywhere to start",-camera.viewportWidth/2,0,camera.viewportWidth, Align.center,true);
        font.draw(batch,"WELCOME, CLICK START TO START",-camera.viewportWidth/2.1F,camera.viewportHeight/8,camera.viewportWidth, Align.center,true);

        batch.end();



        batch.setProjectionMatrix(hudCamera.combined);
        batch.begin();
        hud.render(batch);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        camera.viewportHeight = height;
        camera.viewportWidth = width;
        camera.update();

        hudCamera.viewportWidth = width;
        hudCamera.viewportHeight = height;
        //0,0 in the lower left corner
        hudCamera.position.x = width/2;
        hudCamera.position.y = height/2;
        hudCamera.update();
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
        batch.dispose();
        font.dispose();
    }
}

