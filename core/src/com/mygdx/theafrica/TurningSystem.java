package com.mygdx.theafrica;

public class TurningSystem {

    Player p1, p2;
    int turnsToGive;

    public TurningSystem(Player player1, Player player2)
    {
        p1=player1;
        p2=player2;
    }

    public void giveActions(Player p){
       p.actionNumber= (int) (Math.random()*6+0);
    }

    public void chooseInitialTurn(){
        int randomNum=(int) (Math.random()*2+0);
        if(randomNum==1)
        {
            p1.isTurn=true;
        }else
        {
            p2.isTurn=true;
        }
    }
    //Que jugador empeiza hacer
    public void update(float delta)
    {
        if(p1.isTurn==true)
        {
            if(p1.actionNumber<=0)
            {
                p1.isTurn=false;
                giveActions(p2);
                p2.isTurn=true;
            }
        }else if(p2.isTurn==false)
        {
            if(p2.actionNumber<=0)
            {
                p2.isTurn=false;
                giveActions(p1);
                p1.isTurn=true;
            }
        }
    }

}
