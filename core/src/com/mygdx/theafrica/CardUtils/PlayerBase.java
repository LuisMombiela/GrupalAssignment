package com.mygdx.theafrica.CardUtils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.theafrica.Assets;
import com.mygdx.theafrica.GameObject;
import com.mygdx.theafrica.Layer;
import com.mygdx.theafrica.Player;

public class PlayerBase extends GameObject {

    public int baseIndex;
    public Player myPlayer;
    public int currentWorkers = 3;
    public boolean hasGreenHouse = false;
    public boolean hasHospital = false;
    public boolean hasSchool = false;


    public Vector2 greenhousePos; //Pillar la greenhouse pos
    public Vector2 schoolPos; //Pillar la school pos
    public Vector2 hospitalPos; //Pillar la hospital pos

    public PlayerBase(int playerNumber, float posX, float posY)
    {
        super();
        this.baseIndex = playerNumber;
        x = posX;
        y = posY;

        layerTag = Layer.LayerNames.CARD;
        width = 96;
        height = 96;
        scale = new Vector2(2.5f,2.5f);
        //Necesito pillar la referencia del player porque--> Player 1.playerBase.canbuildHospital()
    }

    public void canBuild(Hospital h)
    {
        if(myPlayer.currentWood >= h.requiredWood && myPlayer.currentIron >= h.requiredIron && myPlayer.currentBandages >= h.requiredBandages && !hasHospital)
            h.build(myPlayer);
        hasHospital = true;
        System.out.println("Player x hospital has been built");
    }
    public void canBuild(School s)
    {
        if(myPlayer.currentWood >= s.requiredWood && myPlayer.currentIron >= s.requiredIron && myPlayer.currentBooks >= s.requiredBooks && !hasSchool)
            s.build(myPlayer);
        hasSchool = true;
        System.out.println("Player x School has been built");
    }
    public void canBuild(Greenhouse gh)
    {
        if(myPlayer.currentWood >= gh.requiredWood && myPlayer.currentWheat >= gh.requiredWheat && myPlayer.currentSeeds >= gh.requiredSeeds && !hasGreenHouse)
            gh.build(myPlayer);
        hasGreenHouse = true;
        System.out.println("Player x Greenhouse has been built");
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texRegionToDraw(5+baseIndex),x,y,0,0,width,height,scale.x,scale.y,rotation);
        System.out.println("it's fuckin drawin");
    }
    TextureRegion texRegionToDraw(int i)
    {
        return Assets.getInstance().cardsReg[i];
    }

    @Override
    public void draw(SpriteBatch batch, float staTime) {

    }

    @Override
    public void update(float delta) {

    }

    //Caso en el que el jugador tiene suficientes recursos tanto para el hospital como para la escuela pero le falta madera y la recoge. Cual se construye?

}
