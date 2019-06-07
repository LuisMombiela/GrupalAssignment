package com.mygdx.theafrica;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Mark extends GameObject {

    public int index; //Lo adquiere del index de la casilla de la grid
    public boolean hasPlayer;
    public int usageTurns; //Numero de turnos que le queda a una carta que esta siendo usada
    public Vector2 playerPosition;
    public Vector2 turnPosition;
    public int column;
    public int row;
    InputManager inputs;
    Grid grid;
    int padding = 15;

    public Mark(Grid gr)
    {
        inputs=WorldController.instance.inputMgr;
        column=1;
        row=0;
        grid = gr;
        x = gr.positions[0][1].x;
        y = gr.positions[0][1].y;

        layerTag = Layer.LayerNames.DEFAULT ;
        width = 106;
        height = 106;
        scale = new Vector2(2.5f,2.5f);

    }


    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Assets.getInstance().markerReg[0],x,y,0,0,width,height,scale.x,scale.y,rotation);
    }


    @Override
    public void update(float delta) {
        moveMark();
        x = grid.positions[row][column].x-padding;
        y = grid.positions[row][column].y-padding;
    }


    public void moveMark()
    {
        if(inputs.keyUp)
        {
            if(row-1<1 && column == 0)
            {
                return;
            }
            else if((row-1)<0)
            {
                System.out.println("Que te vaaaas chaval!");
            }else
            {
                row-=1;
                SoundManager.reproduceSounds(6);
            }
        }
        else if(inputs.keyDown)
        {
            if(row+1>=3 && column == 3)
            {
                return;
            }
            else if((row+1)>=4)
            {
                System.out.println("Que te vaaaas chaval!");
            }else
            {
                row+=1;
                SoundManager.reproduceSounds(6);
            }
        }
        else if(inputs.keyLeft)
        {
            if((column-1)<1 && row == 0)
            {
                return;
            }
            else if((column-1)<0)
            {
                System.out.println("Que te vaaaas chaval!");
            }else
            {
                column-=1;
                SoundManager.reproduceSounds(6);
            }
        }
        else if(inputs.keyRight)
        {
            if((column+1)>=3 && row == 3)
            {
                return;
            }
            if((column+1)>=4)
            {
                System.out.println("Que te vaaaas chaval!");
            }else
            {
                column+=1;
                SoundManager.reproduceSounds(6);
            }
        }

    }
    @Override
    public void draw(SpriteBatch batch, float staTime) {

    }
}
