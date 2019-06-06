package com.mygdx.theafrica;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.theafrica.CardUtils.GameCard;
import javafx.concurrent.Worker;

public class GameWorker extends GameObject{

    public int pNumber;
    public boolean working; //Defines the current state of the worker
    public Vector2 initialPos;//Position given by the
    public Vector2 currentPos;
    public GameCard gameCard; //The card that the worker recieves as the place he needs to go, later obtained
    public int turnsLeft2Work; //The turns this worker needs to be workign in the

    public GameWorker(int number)
    {
        super();
        pNumber = number;
    }

   /* public Vector2 getSelectedCard()
    {
        gameCard = selectedCard
        return selectedCard
    }
    gameCard = selectedCard
    public GameWorker(int number)
    {
        pNumber = number;
    }
*/
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
    }
    public void getInitialPos()
    {
        this.currentPos =
        Pillar la posición de los huecos de la playerBase
    }
    public void getBackToBase()
    {
        currentPos = initialPos;
        working = false;
    }

    public void getToWork(GameCard gc)
    {
       //Pillar la posición de la carta con respecto a la grid
        // this.currentPos = gc.position;

    }*/
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

