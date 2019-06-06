package com.mygdx.theafrica.CardUtils;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.theafrica.Player;

public class PlayerBase {

    public int baseIndex;
    public Player myPlayer;

    public boolean hasGreenHouse;
    public boolean hasHospital;
    public boolean hasSchool;
    public Vector2 greenhousePos; //Pillar la greenhouse pos
    public Vector2 schoolPos;     //Pillar la school pos
    public Vector2 hospitalPos;   //Pillar la hospital pos

    public PlayerBase(int playerNumber)
    {
        this.baseIndex = playerNumber;
        //Necesito pillar la referencia del player
    }

    public void canBuild(Hospital h)
    {
        if(myPlayer.currentWood >= h.requiredWood && myPlayer.currentIron >= h.requiredIron && myPlayer.currentBandages >= h.requiredBandages)
            h.build();
        hasHospital = true;
        System.out.println("Player tal hospital has been built");
    }
    public void canBuild(School s)
    {
        if(myPlayer.currentWood >= s.requiredWood && myPlayer.currentIron >= s.requiredIron && myPlayer.currentBooks >= s.requiredBooks)
            s.build();
        hasSchool = true;
        System.out.println("Player tal School has been built");
    }
    public void canBuild(Greenhouse gh)
    {
        if(myPlayer.currentWood >= gh.requiredWood && myPlayer.currentIron >= gh.requiredIron && myPlayer.currentBandages >= gh.requiredBandages)
            gh.build();
        hasGreenHouse = true;
        System.out.println("Player tal Greenhouse has been built");
    }



}
