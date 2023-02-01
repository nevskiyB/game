package com.mygdx.battle.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.battle.physics.PhysicalBody;

public class Entity implements Disposable {
    private Sprite sprite;
    public PhysicalBody physicalBody;

    public Entity(BodyDef.BodyType type, Sprite sprite, Vector2 position) {
        this.sprite = sprite;
        sprite.setCenter(sprite.getWidth()/2, sprite.getHeight()/2);
        physicalBody = new PhysicalBody(type, position, sprite.getWidth(), sprite.getHeight());
    }

    public void render(SpriteBatch batch) {
        batch.draw(sprite, physicalBody.getX(), physicalBody.getY());
    }

    public Body getBody() {
        return physicalBody.body;
    }

    @Override
    public void dispose() {
        sprite.getTexture().dispose();
        //physicalBody.dispose();
    }
}