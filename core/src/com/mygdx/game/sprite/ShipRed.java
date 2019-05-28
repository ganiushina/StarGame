package com.mygdx.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.math.Rect;
import com.mygdx.game.math.Rnd;

public class ShipRed extends Sprite {


    private Vector2 v;
    private Rect worldBounds;
    private float height;

    private static final float LEN = 0.005f;


    private Vector2 touch;
    private Vector2 buf;

    public ShipRed(TextureRegion region) {
        super(region);
        setHeightProportion(0.2f);
        v = new Vector2();
        touch = new Vector2();
        buf = new Vector2();
    }

//    public ShipBlack(TextureAtlas atlas) {
//        super(atlas.findRegion("main_ship"));
//       // float vX = Rnd.nextFloat(-0.005f, 0.005f);
//     //   float vY = Rnd.nextFloat(-0.5f, -0.1f);
//        v = new Vector2();
//     //  // height = Rnd.nextFloat(0.009f, 0.012f);
//        setHeightProportion(1f);
//    }

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
        //    pos.set(wordBounds.pos);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        // return super.touchDown(touch, pointer);
        this.touch = touch;
        v.set(touch.cpy().sub(pos)).setLength(LEN);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return super.touchUp(touch, pointer);
    }
}
