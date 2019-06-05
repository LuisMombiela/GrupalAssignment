package com.mygdx.theafrica;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {

    //FOR MUSIC THEME
    public static Music principalTheme = Gdx.audio.newMusic(Gdx.files.internal("Africa.mp3"));

    //FOR SIMPLE SOUNDS
    //public static Sound Shoot = Gdx.audio.newSound(Gdx.files.internal(""));



    public static void reproduceSounds(int soundID){
        switch (soundID){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                break;

        }
    }


    public static void reproduceMusic(){
       principalTheme.play();
       principalTheme.setLooping(true);
    }
}
