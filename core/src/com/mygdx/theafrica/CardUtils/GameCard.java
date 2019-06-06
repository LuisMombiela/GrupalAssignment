package com.mygdx.theafrica.CardUtils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.theafrica.Assets;
import com.mygdx.theafrica.GameObject;
import com.mygdx.theafrica.Layer;

public class GameCard extends GameObject {

    public int index; //Lo adquiere del index de la casilla de la grid
    public boolean hasPlayer;
    public int usageTurns; //Numero de turnos que le queda a una carta que esta siendo usada
    public Vector2 playerPosition; //Saves the position it shows either player 1 or 2 controls that casilla with the imagen of the jugador
    public Vector2 turnPosition;//Saves the position of the image where the image of the turns that casilla has left
    public CardType ctype;

    public GameCard(CardType type, float posX, float posY)
    {
        x = posX;
        y = posY;
        ctype = type;
        layerTag = Layer.LayerNames.CARD;
        width = 96;
        height = 96;
        scale = new Vector2(2.5f,2.5f);

    }


    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texRegionToDraw(ctype.getValue()),x,y,0,0,width,height,scale.x,scale.y,rotation);
    }
    TextureRegion texRegionToDraw(int i)
    {
        return Assets.getInstance().cardsReg[i];
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {

    }
}
