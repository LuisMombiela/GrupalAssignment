package com.mygdx.theafrica.CardUtils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.theafrica.Assets;
import com.mygdx.theafrica.GameObject;
import com.mygdx.theafrica.Layer;

public class GameCard extends GameObject {

    public Vector2 index; //Lo adquiere del index de la casilla de la grid
    public boolean hasWorker;
    public int usageTurns; //Numero de turnos que le queda a una carta que esta siendo usada
    public Vector2 playerPosition; //Saves the position it shows either player 1 or 2 controls that casilla with the imagen of the jugador
    public Vector2 turnPosition;//Saves the position of the image where the image of the turns that casilla has left
    public CardType ctype;

    public GameCard(CardType type, float posX, float posY, int indexRow, int indexColumn)
    {
        x = posX;
        y = posY;
        ctype = type;
        layerTag = Layer.LayerNames.CARD;
        width = 96;
        height = 96;
        scale = new Vector2(2.5f,2.5f);

        updateCardPositions();

        if(ctype == CardType.BANDAGE || ctype ==  CardType.BOOK || ctype == CardType.SEED)
        {
            usageTurns = 7;
        }
        else if (ctype == CardType.WHEAT || ctype == CardType.WOOD || ctype == CardType.IRON)
        {
            usageTurns = 4;
        }

        //playerPosition = new Vector2(x+15, y+15);
        index = new Vector2(indexRow, indexColumn);

    }


    public void updateCardPositions()
    {
        playerPosition = new Vector2(x+75*scale.x, y+3*scale.y);
        turnPosition = new Vector2(x+75*scale.x, y+75*scale.y);
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
