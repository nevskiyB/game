package com.mygdx.battle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.mygdx.battle.controller.KeyboardController;
import com.mygdx.battle.entity.Entity;
import com.mygdx.battle.entity.Character;

import static com.mygdx.battle.physics.Physics.world;

public class Battle extends ApplicationAdapter {
	SpriteBatch batch;
	Character player;
	Entity platform;
	KeyboardController controller;
	OrthographicCamera camera;

	@Override
	public void create() {
		player = new Character(new Sprite(new Texture("pp_with_spitter.png")),
				new Vector2(50,60),
				new Vector2(-50,100));
		platform = new Entity(BodyDef.BodyType.StaticBody, new Sprite(new Texture("ground.png")), new Vector2(-100,0));
		controller = new KeyboardController(player);

		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.
				getHeight());
		camera.update();

		batch = new SpriteBatch();

		camera.zoom = 0.3f;
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.step(0.014f, 6, 2);//world.step(Gdx.graphics.getDeltaTime() + 0.008f, 6, 2);
		batch.begin();

		batch.setProjectionMatrix(camera.combined);
		camera.update();
		camera.position.set(player.getBody().getPosition().x, player.getBody().getPosition().y,0);

		controller.check();
		player.render(batch);
		platform.render(batch);
		//renderer.render(world, camera.combined);

		batch.end();
	}

	@Override
	public void dispose() {
		player.dispose();
		platform.dispose();
	}
}
