package com.mygdx.theafrica;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Grid extends GameObject{

    int size;
    int cardSize;
    int originalX;
    int originalY;

    public Vector2[][] positions;
    public boolean[][] isOcuppied;
    
    public Grid()
    {
        size = 4;

        positions = new Vector2[size][size];
        isOcuppied = new boolean[size][size];

        cardSize = 96;
        originalX = 400;
        originalY = 800;

        for(int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                positions[i][j] = new Vector2();
                positions[i][j].x = originalX + cardSize * j;
                positions[i][j].y = originalY - cardSize * i;
                isOcuppied[i][j] = false;
            }
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
