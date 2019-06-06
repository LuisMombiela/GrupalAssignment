package com.mygdx.theafrica;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.theafrica.CardUtils.PlayerBase;


public class Player extends GameObject {
    public int number;
    public PlayerBase base;

    public int currentWood;
    public int currentWheat;
    public int currentIron;
    public int currentBandages;
    public int currentBooks;
    public int currentpawns;

    public boolean isTurn;
    public Player(float posX, float posY, int num) {
        // position = new Vector2(posX, posY);
        x=posX;
        y=posY;
        rotation = 0;

        width= 7;
        height=7;

        scale = new Vector2(1,1);


        number = num; //1 or 2
        layerTag = Layer.LayerNames.CARD;
        rectangle = new Rectangle();
        base = new PlayerBase(number);

        spawnWorkers();

    }

    @Override
    public void draw(SpriteBatch batch) {


    }

    @Override
    public void update(float delta) {



    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {

    }

    void spawnWorkers()
    {
        WorldController.instance.levelManager.Instantiate(new Player(0,0, 1));//REPLACE THESE POSITION LATER WITH EACH CARD'S BOX FOR PLAYERS IN THE BASE CARDS
        WorldController.instance.levelManager.Instantiate(new Player(0,0, 1));
        WorldController.instance.levelManager.Instantiate(new Player(0,0, 1));
    }

}
