package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screen.ScreenMenu;

public class MyGdxGame extends Game {
	SpriteBatch batch;
	Texture img;
	Texture backtexture;

	@Override
	public void create () {
		setScreen(new ScreenMenu());
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
//		backtexture  = new Texture("kosmos.jpg");
	}

//	@Override
//	public void render () {
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(backtexture , 0, 0);
//		batch.draw(img, 0, 0);
//		batch.end();
//	}
//
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//		backtexture.dispose();
//	}
}
