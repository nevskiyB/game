package com.mygdx.battle.weapon.spitter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.MassData;
import com.mygdx.battle.entity.GameObj;
import com.mygdx.battle.physics.Physics;
import com.mygdx.battle.render.RenderMng;

public class SpitterProjectile extends GameObj {
    private Vector2 velocity;
    private Vector2 center;

    public SpitterProjectile(Vector2 center, float velocity) {
        super(new Sprite(new Texture("projectile_spitter.png")), center);
        mainBody.setType(BodyDef.BodyType.DynamicBody);
        mainBody.setFixedRotation(false);
        mainFixture.setFriction(0.08f);
        mainFixture.setRestitution(0.7f);
        this.velocity = new Vector2(velocity, velocity);
        this.center = center;
    }

    public void launch(float angle) {
        RenderMng.objects.add(this);
        mainBody.setLinearVelocity(velocity.rotateAroundDeg(center, angle));
    }

    @Override
    public void dispose() {
        RenderMng.objects.remove(this);
        sprite.getTexture().dispose();
        Physics.world.destroyBody(mainBody);
    }
}
