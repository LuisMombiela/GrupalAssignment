package com.mygdx.theafrica;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.theafrica.CardUtils.CardType;
import com.mygdx.theafrica.CardUtils.GameCard;

import javax.smartcardio.Card;

public class Grid extends GameObject{

    int size;
    int cardSize;
    int originalX;
    int originalY;

    public Vector2[][] positions;
    public boolean[][] hasCard;

    public Grid()
    {
        size = 4;

        positions = new Vector2[size][size];
        hasCard = new boolean[size][size];

        layerTag = Layer.LayerNames.BACKGROUND;
        cardSize = (int)(96 * 2.5f);
        originalX = (int)(-Constants.VIEWPORT_WIDTH/4)+100;
        originalY = (int)Constants.VIEWPORT_HEIGHT/4;

        for(int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                positions[i][j] = new Vector2();
                positions[i][j].x = originalX + cardSize * j;
                positions[i][j].y = originalY - cardSize * i;
                WorldController.instance.levelManager.Instantiate(new GameCard(GetCardType(), positions[i][j].x, positions[i][j].y));
                hasCard[i][j] = true;

                Gdx.app.debug("GRID","Position: " + positions[i][j].x + ", "+ positions[i][j].y);
            }
        }

    }

    CardType GetCardType()
    {
        int randomCard = (int)Math.random() * 5;
        switch(randomCard){
            case 0:
                return CardType.WHEAT;

            case 1:
                return CardType.WOOD;

            case 2:
                return CardType.IRON;

            case 3:
                return CardType.BOOK;

            case 4:
                return CardType.BANDAGE;

            case 5:
                return CardType.SEED;

            default:
                return CardType.WHEAT;
        }

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {

    }
}
