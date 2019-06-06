package com.mygdx.theafrica.CardUtils;

import com.mygdx.theafrica.Player;

public class Greenhouse extends Upgrades{
//Pillar la imagen de Greenhouse
    public Greenhouse(){
        requiredWood = 5;
        requiredWheat = 5;
        requiredSeeds = 10;
    }

    @Override
    public void build(Player p) {
        p.currentWood -= this.requiredWood;
        p.currentWheat -= this.requiredWheat;
        p.currentSeeds -= this.requiredSeeds;

    }
}
