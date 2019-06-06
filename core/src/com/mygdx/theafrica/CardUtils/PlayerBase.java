package com.mygdx.theafrica.CardUtils;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.theafrica.Player;

public class PlayerBase {

    public int baseIndex;
    public Player myPlayer;
    public int currentWorkers = 3;
    public boolean hasGreenHouse = false;
    public boolean hasHospital = false;
    public boolean hasSchool = false;


    public Vector2 greenhousePos; //Pillar la greenhouse pos
    public Vector2 schoolPos; //Pillar la school pos
    public Vector2 hospitalPos; //Pillar la hospital pos

    public PlayerBase(int playerNumber)
    {
        this.baseIndex = playerNumber;
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

    //Caso en el que el jugador tiene suficientes recursos tanto para el hospital como para la escuela pero le falta madera y la recoge. Cual se construye?

}
