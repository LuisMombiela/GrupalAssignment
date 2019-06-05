package com.mygdx.theafrica;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
    private static Assets instance = null;

    public Texture bg;
    public TextureRegion tiledBg;

    public TextureAtlas icons;

    public TextureAtlas cards;
    public TextureRegion[] cardsReg;

    public TextureRegion[] player; //Decidir luego en la clase player si se dibuja la ficha de player 1 o de player 2
    public Texture hospital;
    public Texture greenhouse;
    public Texture school;
    public TextureRegion[] dice;



    private Assets() {

        //BACKGROUND---------------------------------------------------------------------------------------------------------------------
        bg = new Texture (Gdx.files.internal("Background.png"));
        bg.setWrap(Texture.TextureWrap.Repeat,Texture.TextureWrap.Repeat);
        float bgFactorWidth = bg.getWidth() * 1;        //this means that my Texture should cover 1 world unit width.

        float bgFactorHeight = bg.getHeight() * 1;   //this means that my Texture should cover 1 world unit height.

        float widthInWorldUnits = 20;                        //I am creating a world of 40 units width (my viewport width is around 10)

        float heightInWorldUnits = 20;                     //I am creating a world of 20 units height (my viewport height is fixed to 10)

        tiledBg = new TextureRegion(bg, Math.round(widthInWorldUnits*bgFactorWidth),Math.round(heightInWorldUnits*bgFactorHeight));

        //ICONS---------------------------------------------------------------------------------------------------------------------------
        icons = new TextureAtlas("Icons.atlas");
        player = new TextureRegion[2];

        for(int i = 0; i<2; i++)
        {
            player[i] = SpriteHelper.textureFromTextureAtlas("icon"+(i), icons);
        }
        for(int i = 2; i<7; i++)
        {
            dice[i] = SpriteHelper.textureFromTextureAtlas("icon"+(i), icons);
        }

        hospital = SpriteHelper.textureFromTextureAtlas("icon"+(7), icons).getTexture();
        greenhouse = SpriteHelper.textureFromTextureAtlas("icon"+(8), icons).getTexture();
        school = SpriteHelper.textureFromTextureAtlas("icon"+(9), icons).getTexture();

        cards = new TextureAtlas("Cards.atlas");
        int cardsNumber = cards.getRegions().size;
        cardsReg = new TextureRegion[cardsNumber];

        for(int i = 0; i<cardsNumber; i++)
        {
            cardsReg[i] = SpriteHelper.textureFromTextureAtlas("cards"+(i), icons);
        }

    }

    public static Assets getInstance() {
        if(instance == null) {
            instance = new Assets();
        }
        return instance;
    }

}
