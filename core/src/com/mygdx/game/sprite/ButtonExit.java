package com.mygdx.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.mygdx.game.Base.ScaledTouchUpButton;
import com.mygdx.game.math.Rect;
public class ButtonExit extends ScaledTouchUpButton {

    public ButtonExit(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
        setHeightProportion(0.18f);
    }

    @Override
    public void resize(Rect wordBounds) {
        setLeft(wordBounds.getLeft() + 0.03f);
        setBottom(wordBounds.getBottom() + 0.03f);
    }

    @Override
    public void action() {
        Gdx.app.exit();
    }
}
