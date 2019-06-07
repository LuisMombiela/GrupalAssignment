package com.mygdx.theafrica;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TurnManager extends GameObject {

    Player p1, p2;
    int turnsToGive;
    float padding = 150;

    Player activePlayer;
    public static TurnManager instance;

    public TurnManager()
    {
        if(TurnManager.instance ==null)
        {
            instance = this;
        }
        else if(TurnManager.instance != this)
        {
            WorldController.instance = null;
        }

        p1 = null;
        p2 = null;
        activePlayer = null;
        layerTag = Layer.LayerNames.PLAYER;
    }

    public void giveActions(Player p){
       p.actionNumber= (int) ((Math.random()*100*6)/100);

    }

    public void chooseInitialTurn(){
        int randomNum=(int) ((Math.random()*100*2)/100);
        if(randomNum==1)
        {
            p1.actionNumber= (int) ((Math.random()*100*6)/100);
            p1.isTurn = true;
            p2.isTurn = false;
            WorldController.instance.levelManager.getMark().setMarkerOnPlayer(1);
            activePlayer = p1;


        }

        else
        {
            p2.actionNumber= (int) ((Math.random()*100*6)/100);
            p2.isTurn = true;
            p1.isTurn = false;
            WorldController.instance.levelManager.getMark().setMarkerOnPlayer(2);
            activePlayer = p2;

        }
    }


    @Override
    public void update(float delta)
    {

        if(p1 == null && p2 == null) {
            p1 = WorldController.instance.levelManager.getPlayer(1);
            p2 = WorldController.instance.levelManager.getPlayer(2);
            chooseInitialTurn();
        }

        if(p1.isTurn==true)
        {
            if(p1.actionNumber<=0 || p1.turnPassed)
            {

                p1.turnPassed = false;
                p1.isTurn = false;
                giveActions(p2);
                p2.isTurn = true;
                WorldController.instance.levelManager.getMark().setMarkerOnPlayer(2);
                activePlayer = p2;
            }
        }

        else if(p2.isTurn==true)
        {
            if(p2.actionNumber<=0 || p2.turnPassed)
            {
                p2.turnPassed = false;
                p2.isTurn=false;
                giveActions(p1);
                p1.isTurn=true;
                WorldController.instance.levelManager.getMark().setMarkerOnPlayer(1);
                activePlayer = p1;
            }
        }
    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {

    }

    @Override
    public void draw(SpriteBatch batch) {
        if(p1!=null && p2 != null)
        {
            if(p1.isTurn)
                batch.draw(Assets.getInstance().turnsTR[0], -WorldController.instance.levelManager.getBg().width/2 + padding ,400,0,0,102,50,2.5f,2.5f,0);

            if(p2.isTurn)
                batch.draw(Assets.getInstance().turnsTR[1], WorldController.instance.levelManager.getBg().width/2 - padding -102*2.5f,400,0,0,102,50,2.5f,2.5f,0);
                                                                                                                            //The "TURN" banner width multiplied by its scale
        }
    }
}

