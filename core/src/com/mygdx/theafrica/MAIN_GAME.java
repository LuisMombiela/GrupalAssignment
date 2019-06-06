package com.mygdx.theafrica;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;

public class MAIN_GAME extends Game {

    SCREEN_MENU mainScreen;
    SCREEN_MAIN gameScreen;

    @Override
    public void create() {
        mainScreen = new SCREEN_MENU(this);
        gameScreen = new SCREEN_MAIN(this);

        if(Gdx.app.getType() == Application.ApplicationType.Android)
            System.out.println("Estoy en android");
        else if (Gdx.app.getType() == Application.ApplicationType.Desktop){

            if(Controllers.getControllers().size > 0){

            }
        }

        setScreen(mainScreen);
    }
}
