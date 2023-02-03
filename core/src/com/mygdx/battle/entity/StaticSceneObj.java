package com.mygdx.battle.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Filter;

public class StaticSceneObj extends GameObj {
    public StaticSceneObj(Sprite sprite, Vector2 startPos) {
        super(sprite, startPos);
        //Filter fixtureFilter = new Filter();
        //fixtureFilter.categoryBits = 0x0002;
        //fixtureFilter.maskBits = 0x0004;
        //mainFixture.setFilterData(fixtureFilter);
    }
}
