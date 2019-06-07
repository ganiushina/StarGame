package com.mygdx.game.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.Base.ScaledTouchUpButton;
import com.mygdx.game.Screen.GameScreen;

public class ButtonNewGame extends ScaledTouchUpButton {
    private Game game;

    public ButtonNewGame(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("button_new_game"));
        this.game = game;
        setHeightProportion(0.07f);
        setBottom(0.2f);
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen(game));
    }
}
