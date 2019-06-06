package com.mygdx.theafrica;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background extends GameObject {

    public Background(LevelManager levelManager, float posX, float posY, float width, float height)
    {
        super(levelManager);
        TextureRegion tr = Assets.getInstance().tiledBg;
        x=posX;
        y=posY;
        this.width=width;
        this.height=height;
    }

    public void update(float delta)
    {




    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {

    }

    public void draw(SpriteBatch batch)
    {

        batch.draw(Assets.getInstance().tiledBg,x,y,width,height);
    }


}
