package com.mygdx.theafrica;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Background extends GameObject {

    public Background(Level level, float posX, float posY, float width, float height)
    {
        super(level);
        x=posX;
        y=posY;
        this.width=width;
        this.height=height;
    }

    public void update(float delta)
    {
        TextureRegion tr = Assets.getInstance().tiledBg;
        float speedX = 0;

        float speedY = -200;

        int amountX = (int)(speedX*delta);

        int amountY = (int)(speedY*delta);

        tr.setRegionX(tr.getRegionX()+amountX);

        //after modifying the X coordinate, the width of the TextureRegion has shrunk (it has the same value as before the change) so we need to manually update it.

        tr.setRegionWidth(tr.getRegionWidth()+amountX);

        tr.setRegionY(tr.getRegionY()+amountY);

        tr.setRegionHeight(tr.getRegionHeight()+amountY);
    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {

    }

    public void draw(SpriteBatch batch)
    {

        batch.draw(Assets.getInstance().tiledBg,x,y,width,height);
    }


}
