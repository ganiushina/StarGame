package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.BaseScreen;

public class ScreenMenu extends BaseScreen {

    private SpriteBatch batch;
    private Texture img;
    private Texture backtexture;

    private Vector2 touch;
    private Vector2 touchNew;
    private Vector2 v;
    private Vector2 pos;
    float speed;

    private float topBorder;
    private float rightBorder;
    private float bootomBorder;
    private float leftBorder;


    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        backtexture  = new Texture("kosmos.jpg");
        touch = new Vector2();
        touchNew = new Vector2();
        v = new Vector2();
        pos = new Vector2();
        speed = 0.7f;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(backtexture , 0, 0);
        batch.draw(img, pos.x, pos.y);
        batch.end();
        if (touch.x != 0 || touch.y != 0) {
            if (Math.round(pos.x) != Math.round(touchNew.x) && Math.round(pos.y) != Math.round(touchNew.y)){
                pos.add(v);
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        img.dispose();
        backtexture.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        touchKey(keycode);
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean keyTyped(char character) {
        return super.keyTyped(character);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        super.touchDown(screenX, screenY, pointer, button);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        touchNew.set(touch);
        touch.sub(pos);
        touch.nor();
        v.set(touch).scl(speed);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return super.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean scrolled(int amount) {
        return super.scrolled(amount);
    }

    private void touchKey(int keycode){

        // не успела доделать
//
//        switch (keycode) {
//            case 19: {
//                touch.set(pos.x - img.getWidth() , Gdx.graphics.getWidth() - img.getWidth());
//                touchNew.set(touch);
//                touch.sub(pos);
//                touch.nor();
//                v.set(touch).scl(speed);
//            }
//            case 21: {
//                touch.set(Gdx.graphics.getHeight() -img.getHeight(), pos.y);
//            }
//            case 20: {
//                touch.set(pos.x, Gdx.graphics.getWidth());
//            }
//            case 22: {
//                touch.set(pos.x, Gdx.graphics.getWidth());
//            }
//        }

     //   System.out.println(" touch.x = " + touch.x + " touch.y = " + touch.y + " Gdx.graphics.getWidth() = " + Gdx.graphics.getWidth() + " Gdx.graphics.getWidth() - img.getWidth() = " + (Gdx.graphics.getWidth() - img.getWidth()));
//
    }

}

