package com.mygdx.theafrica;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.Controllers;

public class MyGame extends Game {

    MenuScreen mainScreen;
    TheAfricaMain gameScreen;

    @Override
    public void create() {
        mainScreen = new MenuScreen(this);
        gameScreen = new TheAfricaMain(this);

        if(Gdx.app.getType() == Application.ApplicationType.Android)
            System.out.println("Estoy en android");
        else if (Gdx.app.getType() == Application.ApplicationType.Desktop){

            if(Controllers.getControllers().size > 0){

            }
        }

        setScreen(mainScreen);
    }
}
