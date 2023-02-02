package com.mygdx.battle.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mygdx.battle.entity.GameObj;

import java.util.LinkedList;

import static com.mygdx.battle.physics.Physics.world;

public class RenderMng {
    public static final SpriteBatch batch = new SpriteBatch();
    public static final LinkedList<GameObj> objects = new LinkedList<>();
    public static void renderObjects() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(GameObj obj : objects) {
            obj.render();
        }
        batch.end();
    }
}
