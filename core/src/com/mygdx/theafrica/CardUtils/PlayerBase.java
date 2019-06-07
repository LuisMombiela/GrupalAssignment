package com.mygdx.theafrica.CardUtils;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.theafrica.*;

public class PlayerBase extends GameObject {

    public int baseIndex;
    public Player localPlayer;
    public boolean hasGreenHouse = false;
    public boolean hasHospital = false;
    public boolean hasSchool = false;
    Hospital h = new Hospital();
    School s =  new School();
    Greenhouse gh = new Greenhouse();

    public Vector2 greenhousePos; //Pillar la greenhouse pos
    public Vector2 schoolPos; //Pillar la school pos
    public Vector2 hospitalPos; //Pillar la hospital pos
    public Vector2[] playerPositions;

    public PlayerBase(int playerNumber, float posX, float posY, Player player)
    {
        super();
        baseIndex = playerNumber;
        x = posX;
        y = posY;

        layerTag = Layer.LayerNames.CARD;
        width = 96;
        height = 96;
        scale = new Vector2(2.5f,2.5f);

        updateCardPositions();
        localPlayer = player;

    }
    public void updateCardPositions()
    {
        hospitalPos = new Vector2(x + 20*scale.x, y-31*scale.y);
        schoolPos = new Vector2(x + 41*scale.x, y-53*scale.y);
        greenhousePos = new Vector2(x + 62*scale.x, y-31*scale.y);

        playerPositions = new Vector2[]{new Vector2(x + 20*scale.x, y-7*scale.y), new Vector2(x + 41*scale.x, y-7*scale.y), new Vector2(x + 62*scale.x, y-7*scale.y)};
    }

    public void canBuildH()
    {

        if(localPlayer.currentWheat >= h.requiredWheat && localPlayer.currentIron >= h.requiredIron && localPlayer.currentBandages >= h.requiredBandages && !hasHospital)
        {
            h.build(localPlayer);
            SoundManager.reproduceSounds(5);
            hasHospital = true;
            System.out.println("Player " + baseIndex + " hospital has been built");
        }
    }
    public void canBuildS()
    {
        if(localPlayer.currentSeeds >= s.requiredSeeds && localPlayer.currentIron >= s.requiredIron && localPlayer.currentBooks >= s.requiredBooks && !hasSchool)
        {s.build(localPlayer); SoundManager.reproduceSounds(5);
        hasSchool = true;
        System.out.println("Player"+baseIndex+" School has been built");
        }
    }
    public void canBuildG()
    {
        if(localPlayer.currentWood >= gh.requiredWood && localPlayer.currentWheat >= gh.requiredWheat && localPlayer.currentSeeds >= gh.requiredSeeds && !hasGreenHouse)
        { gh.build(localPlayer);SoundManager.reproduceSounds(5);
        hasGreenHouse = true;
        System.out.println("Player "+baseIndex+" Greenhouse has been built");
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texRegionToDraw(5+baseIndex),x,y,0,0,width,height,scale.x,scale.y,rotation);

        if(hasGreenHouse)
        {
            batch.draw(Assets.getInstance().greenhouse,greenhousePos.x,greenhousePos.y, 0, 0,15,15, scale.x,scale.y,rotation);
        }
        if(hasHospital)
        {
            batch.draw(Assets.getInstance().hospital,greenhousePos.x,greenhousePos.y, 0, 0,15,15, scale.x,scale.y,rotation);
        }
        if(hasSchool)
        {
            batch.draw(Assets.getInstance().school,greenhousePos.x,greenhousePos.y, 0, 0,15,15, scale.x,scale.y,rotation);
        }
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

        canBuildG();canBuildH();canBuildS();



    }

    //Caso en el que el jugador tiene suficientes recursos tanto para el hospital como para la escuela pero le falta madera y la recoge. Cual se construye?

}
