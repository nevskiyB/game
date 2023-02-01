package com.mygdx.battle.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class KeyboardController implements InputProcessor {

    private Controllable movableEntity;

    public KeyboardController(Controllable movableEntity) {
        this.movableEntity = movableEntity;
    }

    public void check() {
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            movableEntity.moveRight();
        if (Gdx.input.isKeyPressed(Input.Keys.A))
            movableEntity.moveLeft();
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
            movableEntity.up();
    }

    @Override
    public boolean keyDown(int keycode) {
//        if(keycode == Input.Keys.UP)
//            controllableEntity.getBody().applyForceToCenter(0f,1000f,true);
//        if(keycode == Input.Keys.DOWN)
//            controllableEntity.getBody().applyForceToCenter(0f, -1000f, true);

//         On brackets ( [ ] ) apply torque, either clock or counterclockwise
//                if(keycode == Input.Keys.RIGHT_BRACKET)
//                    torque += 0.10f;
//                if(keycode == Input.Keys.LEFT_BRACKET)
//                    torque -= 0.10f;
//
//         Remove the torque using backslash /
//                if(keycode == Input.Keys.BACKSLASH)
//                    torque = 0.0f;
//
//         If user hits spacebar, reset everything back to normal
//        if(keycode == Input.Keys.SPACE) {
//            controllableEntity.getBody().setLinearVelocity(0f, 0f);
//            controllableEntity.getBody().setAngularVelocity(0f);
//            //torque = 0f;
//            controllableEntity.getSprite().setPosition(0f,0f);
//            controllableEntity.getBody().setTransform(0f,0f,0f);
//        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    // On touch we apply force from the direction of the users touch.
    // This could result in the object "spinning"
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //entity.getBody().applyForce(1f,1f,screenX,screenY,true);
        //body.applyTorque(0.4f,true);
        //return true;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

}
