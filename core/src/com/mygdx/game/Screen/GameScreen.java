package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import com.mygdx.game.Base.BaseScreen;

import com.mygdx.game.sprite.Background;
import com.mygdx.game.sprite.ShipBlack;
import com.mygdx.game.sprite.ShipRed;
import com.mygdx.game.sprite.Star;


import com.mygdx.game.math.Rect;


public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 64;

    private Texture bg;
    private Background background;
    private TextureAtlas atlas;
    private Star[] starArray;

    private TextureAtlas.AtlasRegion atlasRegion;

    TextureRegion regionBlack;
    TextureRegion regionRed;

    int width;

    private ShipRed shipRed;
    private ShipBlack shipBlack;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/kosmos.png");
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
        starArray = new Star[STAR_COUNT];
        for (int i = 0; i < STAR_COUNT; i++) {
            starArray[i] = new Star(atlas);
        }

        atlasRegion = new TextureAtlas.AtlasRegion(atlas.findRegion("main_ship"));
        regionBlack = new TextureRegion(atlasRegion, 0, 0, atlasRegion.originalWidth/2, atlasRegion.originalHeight);
        regionRed = new TextureRegion(atlasRegion, atlasRegion.originalWidth/2, 0, atlasRegion.originalWidth, atlasRegion.originalHeight);

        shipBlack = new ShipBlack(regionBlack);
    //    shipRed = new ShipRed(regionRed);

    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta) {
        for (Star star : starArray) {
            star.update(delta);
        }
        shipBlack.update(delta);
     //   shipRed.update(delta);

    }

    private void draw() {
        Gdx.gl.glClearColor(0.4f, 0.3f, 0.9f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for (Star star : starArray) {
            star.draw(batch);
        }
     //   shipRed.draw(batch);
        shipBlack.draw(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (Star star : starArray) {
            star.resize(worldBounds);
        }

        shipBlack.resize(worldBounds);
    //    shipRed.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        atlas.dispose();
        super.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        shipBlack.touchDown(touch ,pointer);
     //   shipRed.touchDown(touch ,pointer);
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return super.touchUp(touch, pointer);
    }
}
