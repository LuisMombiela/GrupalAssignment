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

    public LevelManager levelManager = new LevelManager();
    public Background background;
    public InputManager inputMgr;
    public TextButton bUp, bDown, bLeft, bRight;
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

        inputMgr = new InputManager();
        Gdx.input.setInputProcessor(inputMgr);

        ch = new CameraHelper();

        hud = new HUD();

        bUp = new TextButton("UP",1650,10,100,100){
            @Override
            public void click() {
                inputMgr.keyUp = true;
            }
        };

        bDown = new TextButton("DWN",1650,-210,100,100){
            @Override
            public void click() {
                Gdx.app.debug("INPUT","Touched Down");
                levelManager.getMark().isTouchedDown = true;
            }
        };

        bLeft = new TextButton("LF",1550,-100,100,100){
            @Override
            public void click() {
                inputMgr.keyLeft = true;
            }
        };


        bRight = new TextButton("RG",1750,-100,100,100){
            @Override
            public void click() {
                inputMgr.keyRight = true;
            }
        };


        hud.add(bUp);
        hud.add(bDown);
        hud.add(bLeft);
        hud.add(bRight);

        ArcadeHandler arcade = new ArcadeHandler(this.levelManager);
        Controllers.addListener(arcade);
        init();


    }

    public void init()
    {
        Grid grid = new Grid();
        levelManager.Instantiate(grid);
        levelManager.Instantiate(new Mark(grid));
        levelManager.Instantiate(new TurnManager());
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
