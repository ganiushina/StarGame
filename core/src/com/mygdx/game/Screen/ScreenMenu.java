package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.BaseScreen;
import com.mygdx.game.math.Rect;
import com.mygdx.game.sprite.Background;
import com.mygdx.game.sprite.BadLogic;

public class ScreenMenu extends BaseScreen {


    private Texture backtexture;
    private Texture badLogicTexture;
    private Background background;
    private BadLogic badLogic;


//    private Vector2 touch;
//    private Vector2 touchNew;
//    private Vector2 v;
//    private Vector2 pos;
//    float speed;

    private float topBorder;
    private float rightBorder;
    private float bootomBorder;
    private float leftBorder;


    @Override
    public void show() {
        super.show();
        backtexture = new Texture("kosmos.jpg");
        background = new Background(new TextureRegion(backtexture));
        badLogicTexture = new Texture("badlogic.jpg");
        badLogic = new BadLogic(new TextureRegion(badLogicTexture));


//        touch = new Vector2();
//        touchNew = new Vector2();
//        v = new Vector2();
//        pos = new Vector2();
//        speed = 0.7f;
    }

    @Override
    public void render(float delta) {
     //   System.out.println("render ScreenMenu " );
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        badLogic.draw(batch);
        batch.end();
        if (touch.x != 0 || touch.y != 0) {
         //   badLogic.pos.add(v);
        //    if (Math.round(badLogic.pos.x) != Math.round(touchNew.x) && Math.round(badLogic.pos.y) != Math.round(touchNew.y))
            {
                badLogic.pos.add(v);

            }
        }

        System.out.println("render touchX = " + touch.x + " touchY = " + touch.y + " v.x  = " + v.x + " v.y = " + v.y + " badLogic.pos.x = " + badLogic.pos.x + " badLogic.pos.y = " + badLogic.pos.y);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        badLogic.resize(worldBounds);
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
        badLogicTexture.dispose();
        backtexture.dispose();
        super.dispose();
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
//        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
//        touchNew.set(touch);
//        touch.sub(pos);
//        touch.nor();
//        v.set(touch).scl(speed);
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

