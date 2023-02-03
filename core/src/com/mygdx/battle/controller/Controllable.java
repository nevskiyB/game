package com.mygdx.battle.controller;

import com.badlogic.gdx.math.Vector2;

public interface Controllable {
    void moveRight();
    void moveLeft();
    void up();
    void rotateTo(int x, int y);
    void attack();
}
