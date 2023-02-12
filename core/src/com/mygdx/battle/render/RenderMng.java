package com.mygdx.battle.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mygdx.battle.entity.GameObj;

import java.util.LinkedList;

import static com.mygdx.battle.physics.Physics.world;

public class RenderMng {
    public static final SpriteBatch batch = new SpriteBatch();
    public static final LinkedList<GameObj> objects = new LinkedList<>();
    public static final BitmapFont FontRed1 = new BitmapFont();
    public static String msg = "Hello World";

    static {
        FontRed1.setColor(Color.RED);
    }
    public static void renderObjects() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        FontRed1.draw(batch, msg, 0, 100);
        for(GameObj obj : objects) {
            obj.render();
        }
        batch.end();
    }
}
