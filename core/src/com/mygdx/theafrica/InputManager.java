package com.mygdx.theafrica;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class InputManager implements InputProcessor {

    public boolean keyRight = false;
    public boolean keyLeft = false;
    public boolean keyUp = false;
    public boolean keyDown = false;
    public boolean keySelect = false;
    public boolean keyDeny = false;



    public void resetBools()
    {
        keyRight = false;
        keyLeft = false;
        keyUp = false;
        keyDown = false;
        keySelect = false;
        keyDeny = false;
    }

    public boolean keyDown (int keycode) {

        switch(keycode)
        {
            case Input.Keys.D: keyRight = true;
                break;
            case Input.Keys.A: keyLeft = true;
                break;
            case Input.Keys.W: keyUp = true;
                break;
            case Input.Keys.S: keyDown  = true;
                break;
            case Input.Keys.SPACE: keySelect = true;
                break;
            case Input.Keys.ESCAPE: keyDeny = true;
                break;
        }



        return true;
    }

    public boolean keyUp (int keycode) {

        switch(keycode)
        {
            case Input.Keys.D: keyRight = false;
                break;
            case Input.Keys.A: keyLeft = false;
                break;
            case Input.Keys.W: keyUp = false;
                break;
            case Input.Keys.S: keyDown  = false;
                break;
            case Input.Keys.SPACE: keySelect = false;
                break;
            case Input.Keys.ESCAPE: keyDeny = false;
                break;
        }

        return true;
    }

    public boolean keyTyped (char character) {
        return false;
    }

    public boolean touchDown (int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    public boolean mouseMoved (int x, int y) {
        return false;
    }

    public boolean scrolled (int amount) {
        return false;
    }
}
