package com.mygdx.battle.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.mygdx.battle.controller.Controllable;
import com.mygdx.battle.physics.Physics;
import com.mygdx.battle.weapon.spitter.SpitterProjectile;

public class Character extends GameObj implements Controllable {
    private OrthographicCamera camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
    private Vector2 velocity;
    //Box2DDebugRenderer renderer = new Box2DDebugRenderer();
    public Character(Sprite sprite, Vector2 velocity, Vector2 startPos) {
        super(sprite, startPos);
        this.velocity = velocity;
        camera.update();
        camera.zoom = 0.3f;
        mainBody.setType(BodyDef.BodyType.DynamicBody);
        mainBody.setFixedRotation(true);

//        Filter fixtureFilter = new Filter();
//        fixtureFilter.categoryBits = 0x0001;
//        fixtureFilter.maskBits = 0x0002;
//        mainFixture.setFilterData(fixtureFilter);
    }

    @Override
    public void render() {
        camera.update();
        camera.position.set(mainBody.getPosition().x, mainBody.getPosition().y,0);
        batch.setProjectionMatrix(camera.combined);
        batch.draw(sprite, mainBody.getPosition().x, mainBody.getPosition().y);
        //renderer.render(Physics.world, camera.combined);
    }

    @Override
    public void moveRight() {
        if(isGrounded()) {
            mainBody.setLinearVelocity(velocity.x, mainBody.getLinearVelocity().y);
        }
    }

    @Override
    public void moveLeft() {
        if(isGrounded()) {
            mainBody.setLinearVelocity(-velocity.x, mainBody.getLinearVelocity().y);//на земле
        }
    }

    @Override
    public void up() {
        if(isGrounded()) {
            mainBody.setLinearVelocity(mainBody.getLinearVelocity().x, velocity.y);
        }
    }

    @Override
    public void attack() {
        new SpitterProjectile(new Vector2(mainBody.getPosition().x, mainBody.getPosition().y + 38), 50f);
    }

    private boolean isGrounded() {
        Array<Contact> contacts = Physics.world.getContactList();

        for(Contact contact : contacts) {
            if(contact.getFixtureA() == this.mainFixture || contact.getFixtureB() == this.mainFixture) {
                return true;
            }
        }

        return false;
    }
}
