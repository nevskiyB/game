package com.mygdx.battle.physics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Disposable;

public class Physics implements Disposable {
    public static World world = new World(new Vector2(0, -100f), true);

    @Override
    public void dispose() {
        world.dispose();
    }
}
