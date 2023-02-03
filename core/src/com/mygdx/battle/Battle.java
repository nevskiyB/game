package com.mygdx.battle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.battle.controller.KeyboardController;
import com.mygdx.battle.entity.Character;
import com.mygdx.battle.entity.StaticSceneObj;
import com.mygdx.battle.render.RenderMng;

import static com.mygdx.battle.physics.Physics.world;

public class Battle extends ApplicationAdapter {
	private Character player;
	private StaticSceneObj platform1;
	private StaticSceneObj platform2;
	private StaticSceneObj fireLocker;
	private KeyboardController controller;

	@Override
	public void create() {
		player = new Character(new Sprite(new Texture("pp_with_spitter.png")),
				new Vector2(50,60),
				new Vector2(0,0));
		platform1 = new StaticSceneObj(new Sprite(new Texture("ground.png")), new Vector2(0,-76));
		platform2 = new StaticSceneObj(new Sprite(new Texture("ground.png")), new Vector2(-205,-76));
		fireLocker = new StaticSceneObj(new Sprite(new Texture("fire_locker.png")), new Vector2(-150,-1));
		controller = new KeyboardController(player);
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render() {
		RenderMng.renderObjects();
		controller.check();
		world.step(0.014f, 6, 2);
	}

	@Override
	public void dispose() {
		player.dispose();
		platform1.dispose();
		platform2.dispose();
		fireLocker.dispose();
	}
}
