package com.mygdx.battle.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Filter;
import com.mygdx.battle.physics.CategoryBits;

public class StaticSceneObj extends GameObj {
    public StaticSceneObj(Sprite sprite, Vector2 startPos) {
        super(sprite, startPos);
        Filter fixtureFilter = new Filter();
        fixtureFilter.categoryBits = CategoryBits.scene;
        fixtureFilter.maskBits = CategoryBits.chars | CategoryBits.scene | CategoryBits.projectile;
        mainFixture.setFilterData(fixtureFilter);
    }
}
