package com.mygdx.theafrica;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class WorldController extends InputAdapter {

    public Sprite spr;
    //   public Sprite[] sprites;
    public String TAG_KEYS = "KEYS";
    public int selectedSprite;
    public ArrayList<GameObject> objects;
    public CameraHelper helper;
    public LevelManager levelManager;
    public Background background;


    public WorldController(LevelManager levelManager){
        Gdx.input.setInputProcessor(this);
        //objects = new ArrayList<GameObject>();
        this.levelManager = levelManager;
        this.helper=this.levelManager.helper;

        ArcadeHandler arcade = new ArcadeHandler(this.levelManager);
        Controllers.addListener(arcade);
        init();

    }

    public void init()
    {

    }

    public void update(float delta){

        levelManager.update(delta);

        //helper.followGO(levelManager.player, levelManager.bg);
        helper.moveCamera(delta);

    }

    @Override
    public boolean keyDown (int keycode){
        //Gdx.app.debug(TAG_KEYS, keycode+" has been pressed");
        if(keycode==Input.Keys.I)
        {
            Gdx.app.debug("SPRITE", spr.getBoundingRectangle()+"");
        }
        return false;
    }
}
