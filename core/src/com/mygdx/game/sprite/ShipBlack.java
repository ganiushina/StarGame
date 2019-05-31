package com.mygdx.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.math.Rect;


public class ShipBlack extends Sprite {

    private Vector2 v;
    private Rect worldBounds;
    private float height;

    private static final float LEN = 0.005f;


    private Vector2 touch;
    private Vector2 buf;

    private Vector2 touchNew;
    float speed;

    public ShipBlack(TextureRegion region) {
        super(region);
        setHeightProportion(0.2f);
        v = new Vector2();
        touch = new Vector2();
        buf = new Vector2();

    }

    @Override
    public void update(float delta) {
        super.update(delta);
        buf.set(touch);
        if (buf.sub(pos).len() <= LEN) {
            pos.set(touch);
        } else {
            pos.add(v);
        }
    }


    @Override
    public void resize(Rect wordBounds) {
        setLeft(wordBounds.getLeft() + 0.03f);
        setBottom(wordBounds.getBottom() + 0.03f);

    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        this.touch = touch;
       // touch.y = pos.y;
        v.set(touch.cpy().sub(pos)).setLength(LEN);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return super.touchUp(touch, pointer);
    }
}
