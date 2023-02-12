package com.mygdx.battle.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.battle.render.RenderMng;

public class KeyboardController extends InputAdapter {

    private Controllable controllableEntity;
    public Vector2 mousePos = new Vector2();

    public KeyboardController(Controllable movableEntity) {
        this.controllableEntity = movableEntity;
    }

    public void check() {
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            controllableEntity.moveRight();
        if (Gdx.input.isKeyPressed(Input.Keys.A))
            controllableEntity.moveLeft();
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            controllableEntity.up();
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT))
            controllableEntity.attack();
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mousePos.set(screenX, screenY);
        controllableEntity.rotateTo(screenX, screenY);
        return false;
    }

}
