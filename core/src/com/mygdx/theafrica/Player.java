package com.mygdx.theafrica;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Player extends GameObject {


    public int number;


    public Player(float posX, float posY, int num) {
        position = new Vector2(posX, posY);
        rotation = 0;

        width= 7;
        height=7;

        scale = new Vector2(1,1);


        number = num; //1 or 2
        layerTag = Layer.LayerNames.PLAYER;
        rectangle = new Rectangle();



    }

    @Override
    public void draw(SpriteBatch batch) {

        batch.draw(texRegionToDraw(number),position.x,position.y,0,0,width,height,scale.x,scale.y,rotation);

    }

    @Override
    public void update(float delta) {



    }
    
    TextureRegion texRegionToDraw(int i)
    {
        return Assets.getInstance().player[i-1];
    }


}
