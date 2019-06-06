package com.mygdx.theafrica;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.theafrica.HUD.HUD;
import com.mygdx.theafrica.HUD.TextButton;

import java.util.ArrayList;

public class WorldController extends InputAdapter {

    public Sprite spr;
    //   public Sprite[] sprites;
    public String TAG_KEYS = "KEYS";
    public int selectedSprite;
    public ArrayList<GameObject> objects;
    public CameraHelper ch;
    HUD hud;
    public LevelManager levelManager;
    public Background background;
    public InputManager inputMgr;
    public static WorldController instance;


    public WorldController(){
        if(WorldController.instance ==null)
        {
            instance = this;
        }
        else if(WorldController.instance != this)
        {
            WorldController.instance = null;
        }
        levelManager = new LevelManager();
        inputMgr = new InputManager();
        Gdx.input.setInputProcessor(inputMgr);

        ch = new CameraHelper();

        hud = new HUD();
        TextButton b1 = new TextButton("Hacer algo",10,10,240,50){
            @Override
            public void click() {
                //Aqui iria lo que quisieses meter como nueva accion
            }
        };

        hud.add(b1);

        ArcadeHandler arcade = new ArcadeHandler(this.levelManager);
        Controllers.addListener(arcade);
        init();

    }

    public void init()
    {

    }

    public void update(float delta){

        levelManager.update(delta);

        //ch.followGO(levelManager.player, levelManager.bg);
        ch.moveCamera(delta);

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
