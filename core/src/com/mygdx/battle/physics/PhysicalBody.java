package com.mygdx.battle.physics;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class PhysicalBody {
    public Body body;
    public BodyDef bodyDef;
    public Fixture fixture;

    public PhysicalBody(BodyDef.BodyType type, Vector2 startPos, float width, float height) {
        bodyDef = new BodyDef();
        bodyDef.type = type;
        bodyDef.fixedRotation = true;
        bodyDef.position.set(startPos);

        body = Physics.world.createBody(bodyDef);

        PolygonShape poly = new PolygonShape();
        poly.setAsBox(width/2, height/2, new Vector2(width/2, height/2), 0f);

        fixture = body.createFixture(poly, 100f);
        fixture.setFriction(1f);

        poly.dispose();
    }

    public float getX() {
        return body.getPosition().x;
    }

    public float getY() {
        return body.getPosition().y;
    }
}
