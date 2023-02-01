package com.mygdx.battle.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.battle.Battle;
import com.mygdx.battle.controller.Controllable;
import com.mygdx.battle.physics.Physics;
import org.apache.log4j.Logger;

public class Character extends Entity implements Controllable {
    private Vector2 velocity;
    private boolean isGrounded;

    public Character(Sprite sprite, Vector2 velocity, Vector2 position) {
        super(BodyDef.BodyType.DynamicBody, sprite, position);
        this.velocity = velocity;
        Physics.world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                isGrounded = true;
            }

            @Override
            public void endContact(Contact contact) {
                isGrounded = false;
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
            }
        });
    }

    @Override
    public void moveRight() {
        if(isGrounded) {
            physicalBody.body.setLinearVelocity(velocity.x, physicalBody.body.getLinearVelocity().y);
        }
    }

    @Override
    public void moveLeft() {
        if(isGrounded) {
            physicalBody.body.setLinearVelocity(-velocity.x, physicalBody.body.getLinearVelocity().y);//на земле
        }
    }

    @Override
    public void up() {
        if(isGrounded) {
            physicalBody.body.setLinearVelocity(physicalBody.body.getLinearVelocity().x, velocity.y);
        }
    }
}
