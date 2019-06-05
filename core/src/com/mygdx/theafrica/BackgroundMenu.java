package com.mygdx.theafrica;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundMenu extends GameObject{

    public BackgroundMenu(float posX, float posY, float width, float height){
        super();
        x=posX;
        y=posY;
        this.width=width;
        this.height=height;
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {
        batch.draw(Assets.getInstance().bgMenuTR,x,y,width*10,height*10);
    }

    @Override
    public void update(float delta) {

    }
}
