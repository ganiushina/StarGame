package com.mygdx.game.sprite;


import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.Base.ScaledTouchUpButton;
import com.mygdx.game.Screen.GameScreen;
import com.mygdx.game.math.Rect;

public class ButtonNewGame extends ScaledTouchUpButton {
    private GameScreen gameScreen;

    public ButtonNewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(0.05f);
        setBottom(-0.1f);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}
