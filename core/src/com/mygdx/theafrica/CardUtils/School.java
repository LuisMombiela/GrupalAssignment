package com.mygdx.theafrica.CardUtils;

import com.mygdx.theafrica.Player;

public class School extends Upgrades {
//Pillar la imagen de school
    public School(){
        requiredWood = 5;
        requiredIron = 5;
        requiredBooks = 10;
    }

    @Override
    public void build(Player p) {

        p.currentWood -= this.requiredWood;
        p.currentIron -= this.requiredIron;
        p.currentBooks -= this.requiredBooks;
    }


}
