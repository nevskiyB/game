package com.mygdx.battle.weapon.spitter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Filter;
import com.mygdx.battle.entity.GameObj;
import com.mygdx.battle.physics.CategoryBits;
import com.mygdx.battle.physics.Physics;
import com.mygdx.battle.render.RenderMng;

public class SpitterProjectile extends GameObj {

    public SpitterProjectile(Vector2 startPos) {
        super(new Sprite(new Texture("projectile_spitter.png")), startPos);
        mainBody.setType(BodyDef.BodyType.DynamicBody);
        mainBody.setFixedRotation(false);
        mainFixture.setFriction(0.08f);
        mainFixture.setRestitution(0.7f);
        Filter fixtureFilter = new Filter();
        fixtureFilter.categoryBits = CategoryBits.projectile;
        fixtureFilter.maskBits = CategoryBits.projectile | CategoryBits.scene;
        mainFixture.setFilterData(fixtureFilter);
    }

    public void launch(Vector2 velocity) {
        RenderMng.objects.add(this);
        mainBody.setLinearVelocity(velocity);
    }

    @Override
    public void dispose() {
        RenderMng.objects.remove(this);
        sprite.getTexture().dispose();
        Physics.world.destroyBody(mainBody);
    }
}
