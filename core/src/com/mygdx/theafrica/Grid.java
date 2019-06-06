package com.mygdx.theafrica;

import com.badlogic.gdx.math.Vector2;

public class Grid {

    int size = 4;
    int cardSize;
    int originalX;
    int originalY;

    public Vector2[][] positions;
    public boolean[][] isOcuppied;

    public Grid()
    {
        positions = new Vector2[size][size];
        cardSize = 96;
        originalX = 400;
        originalY = 800;

        for(int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                positions[i][j].x = originalX + cardSize * j;
                positions[i][j].y = originalY - cardSize * i;
                isOcuppied[i][j] = false;
            }
        }
    }

}
