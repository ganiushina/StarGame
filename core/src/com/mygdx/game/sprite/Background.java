package com.mygdx.game.sprite;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Base.Sprite;
import com.mygdx.game.math.Rect;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect wordBounds) {
        setHeightProportion(1f);
        pos.set(wordBounds.pos);
    }
}
