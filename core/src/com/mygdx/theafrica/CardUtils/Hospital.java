package com.mygdx.theafrica.CardUtils;

import com.mygdx.theafrica.Player;

public class Hospital extends Upgrades {
    //Pillar la imagen de hospital
    public Hospital(){
        requiredWood = 5;
        requiredIron = 5;
        requiredBandages = 10;
    }

    @Override
    public void build(Player p) {
        //Con la posición que hemos cogido del player.playerbase.hospitalpos ponemos la imagen encima
        p.currentWood -= this.requiredWood;
        p.currentIron -= this.requiredIron;
        p.currentBandages -= this.requiredBandages;
    }
}
