package com.mygdx.theafrica;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TargetCard extends GameObject {



    public TargetCard(){

    }

    @Override
    public void update(float delta) {

    }

    public void UpdatePosition()
    {

    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.getInstance().marker, x-4, y-4);
    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {

    }
}
