package com.mygdx.theafrica;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BackgroundMenu extends GameObject{

    public BackgroundMenu(float posX, float posY, float _width, float _height){
        super();
        x=posX;
        y=posY;
        this.width=_width;
        this.height=_height;

        Assets.getInstance().bgMenuTR = new TextureRegion(Assets.getInstance().bgMenu);//,(int)(bgFactorWidth*_width),(int)(bgFactorHeight* _height));

    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {
        batch.draw(Assets.getInstance().bgMenuTR,x,y,width,height);
    }

    @Override
    public void update(float delta) {

    }
}
