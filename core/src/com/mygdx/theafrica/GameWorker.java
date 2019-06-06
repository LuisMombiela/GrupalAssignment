package com.mygdx.theafrica;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.theafrica.CardUtils.GameCard;
import javafx.concurrent.Worker;

public class GameWorker extends GameObject{

    public int pNumber;
    public Player p;
    public boolean working; //Defines the current state of the worker
    public Vector2 initialPos;//Position given by the

    public Vector2 targetPos;
    public GameCard gameCard; //The card that the worker receives as the place he needs to go, later obtained

    public GameWorker(int number)
    {
        super();
        pNumber = number;
    }

   /* public void updateWorkerState()
    {
        if(!working && *//*player chooses a unoccupied card*//*)
        {
          this.getToWork();
        }

        if(working && *//*cardturn value is == 0*//*)
        {
            this.getBackToBase();
        }
    }*/
    public void getInitialPos()
    {
      for(int i = 0; i<3; i++)
      {
        if(p.number == 1)
        {
            targetPos.x =  WorldController.instance.levelManager.getGrid().positions[0][0].x;
            targetPos.y = WorldController.instance.levelManager.getGrid().positions[0][0].y;
        }

        if(p.number == 2)
        {
           targetPos.x =  WorldController.instance.levelManager.getGrid().positions[3][0].x;
           targetPos.y = WorldController.instance.levelManager.getGrid().positions[0][3].y;
        }
      }

    }
    public void getBackToBase()
    {
        x = initialPos.x;
        y = initialPos.y;
        working = false;
    }

    public void getToWork(GameCard gc)
    {


        working = true;

    }
    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texRegionToDraw(pNumber),x,y,0,0,width,height,scale.x,scale.y,rotation);
    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {

    }

    @Override
    public void update(float delta) {

    }
    TextureRegion texRegionToDraw(int i)
    {
        return Assets.getInstance().player[i-1];
    }


}

