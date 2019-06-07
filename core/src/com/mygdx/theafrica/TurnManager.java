package com.mygdx.theafrica;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class TurnManager extends GameObject {

    Player p1, p2;
    int turnsToGive;

    public TurnManager()
    {
        p1 = null;
        p2 = null;

        layerTag = Layer.LayerNames.DEFAULT;
    }

    public void giveActions(Player p){
       p.actionNumber= (int) (Math.random()*6+0);
    }

    public void chooseInitialTurn(){
        int randomNum=(int) (Math.random()*2+0);
        if(randomNum==1)
        {
            p1.actionNumber= (int) (Math.random()*6+0);
            p1.isTurn = true;
            p2.isTurn = false;

        }

        else
        {
            p2.actionNumber= (int) (Math.random()*6+0);
            p2.isTurn = true;
            p1.isTurn = false;

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
                batch.draw(Assets.getInstance().turnsTR[0],-900,400,0,0,102,50,2.5f,2.5f,0);

            if(p2.isTurn)
                batch.draw(Assets.getInstance().turnsTR[1],600,400,0,0,102,50,2.5f,2.5f,0);

        }
    }
}

