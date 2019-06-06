package com.mygdx.theafrica.CardUtils;

import com.mygdx.theafrica.Player;

public class PlayerBase {

    public int baseIndex;
    public Player myPlayer;

    public boolean hasGreenHouse;
    public boolean hasHospital;
    public boolean hasSchool;

    public PlayerBase(int index) {
        this.baseIndex = index;

        //lo que falta
    }

    public boolean canBuild(Hospital h)
    {
        if (myPlayer.currentWood >= h.requiredWood && myPlayer.currentIron >= h.requiredIron && myPlayer.currentBandages >= h.requiredBandages)
        {
            h.build();
        }


        //Funciones de añadir las mejoras
        return true; //CAMBIA ESTO

    }
}
