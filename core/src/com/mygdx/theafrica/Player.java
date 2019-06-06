package com.mygdx.theafrica;


import com.badlogic.gdx.Gdx;
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
    public int currentSeeds;

    public int currentWorkers;

    public int actionNumber;

    public InputManager inputs;

    public boolean isTurn;

    public Player(int num, float posX, float posY) {
        inputs  = WorldController.instance.inputMgr;

        x=posX;
        y=posY;
        rotation = 0;

        width= 7;
        height=7;

        scale = new Vector2(1,1);

        isTurn = false;
        number = num; //1 or 2
        layerTag = Layer.LayerNames.CARD;
        rectangle = new Rectangle();
        base = new PlayerBase(number, posX, posY);
        WorldController.instance.levelManager.Instantiate(base);
        spawnWorkers();

    }

    @Override
    public void draw(SpriteBatch batch) {


    }

    @Override
    public void update(float delta) {

        if(isTurn)
        {
            Actions();
        }

    }

    public void Actions()
    {
        if(inputs.keySelectCard)
        {
            Gdx.app.debug("PLAYER", "WORKER PUT");
            SoundManager.reproduceSounds(1);
            actionNumber -= 1;
        }

        if(inputs.keyAccelerateWorker)
        {
            Gdx.app.debug("PLAYER", "WORKER ACCELERATED");
            SoundManager.reproduceSounds(2);
            actionNumber -= 2;
        }

        if(inputs.keyEndTurn)
        {
            Gdx.app.debug("PLAYER", "TURN ENDED");
            SoundManager.reproduceSounds(3);
            actionNumber = 0;
        }
    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {

    }

    void spawnWorkers()
    {
        WorldController.instance.levelManager.Instantiate(new GameWorker(number));//REPLACE THESE POSITION LATER WITH EACH CARD'S BOX FOR PLAYERS IN THE BASE CARDS
        WorldController.instance.levelManager.Instantiate(new GameWorker(number));
        WorldController.instance.levelManager.Instantiate(new GameWorker(number));
    }

}
