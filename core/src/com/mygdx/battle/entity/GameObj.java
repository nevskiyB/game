package com.mygdx.battle.entity;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.battle.Battle;
import com.mygdx.battle.physics.Physics;
import com.mygdx.battle.render.RenderMng;

public class GameObj implements Disposable { //Статичное жёсткое тело
    protected SpriteBatch batch;
    protected Sprite sprite;
    protected Body mainBody;
    protected Fixture mainFixture;
    public GameObj(Sprite sprite, Vector2 startPos) {
        batch = RenderMng.batch;

        this.sprite = sprite;
        sprite.setCenter(sprite.getWidth()/2, sprite.getHeight()/2);
        float width = sprite.getWidth();
        float height = sprite.getHeight();

        BodyDef mainBodyDef = new BodyDef();
        mainBodyDef.position.set(startPos);
        PolygonShape poly = new PolygonShape();
        poly.setAsBox(width/2, height/2, new Vector2(width/2, height/2), 0f);
        mainBody = Physics.world.createBody(mainBodyDef);
        mainBody.setType(BodyDef.BodyType.StaticBody);
        mainFixture = mainBody.createFixture(poly, 100f);
        mainFixture.setFriction(1f);

        poly.dispose();
    }

    public void render() {
        batch.draw(sprite, mainBody.getPosition().x, mainBody.getPosition().y);
    }

    @Override
    public void dispose() {
        sprite.getTexture().dispose();
    }
}
