package com.mygdx.theafrica;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class WorldRenderer {

    public SpriteBatch batch;
    public WorldController controller;
    public String TAG_TIME = "TIMES";
    public float elapsedTime;
    public ShapeRenderer shapeRender;

    public WorldRenderer(WorldController wc){
        this.controller = wc;
        init();
    }

    public void init(){
        batch = new SpriteBatch();
        shapeRender = new ShapeRenderer();
        controller.helper.camera.position.set(0,0,0);
        controller.helper.camera.update();
    }

    public void render(){

        batch.setProjectionMatrix(controller.helper.camera.combined);
        elapsedTime += Gdx.graphics.getDeltaTime();
        long t0 = System.nanoTime();

        controller.levelManager.render(batch, elapsedTime);

        shapeRender.setProjectionMatrix(controller.helper.camera.combined);
        shapeRender.begin(ShapeRenderer.ShapeType.Line);

        //controller.levelManager.drawDebug(shapeRender);

        shapeRender.end();

        long elapsed = System.nanoTime() - t0;

        float elapsedMs = elapsed / 1000000;

        //Gdx.app.debug(TAG_TIME, elapsedMs + "ms - " + batch.maxSpritesInBatch + " - " + batch.renderCalls);


    }

    public void resize(int width, int height){
        controller.helper.resize(width,height);
    }
}