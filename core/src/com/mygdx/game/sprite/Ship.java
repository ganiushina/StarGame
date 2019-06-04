package com.mygdx.game.sprite;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import com.mygdx.game.Base.Sprite;
import com.mygdx.game.math.Rect;
import com.mygdx.game.pool.BulletPool;

public abstract class Ship extends Sprite {

    protected BulletPool bulletPool;
    protected TextureRegion bulletRegion;

 //   public Rectangle shipRectangle = new Rectangle();//прямоугольник для проверки столкновений

    protected Vector2 v;
    protected Vector2 v0;
    protected Vector2 bulletV;
    protected float bulletHeight;

    protected Rect worldBounds;

    protected float reloadInterval;
    protected float reloadTimer;

    protected int damage;
    protected int hp;

    protected Sound bulletSound;

    public Ship(TextureRegion region, int rows, int cols, int frames) {
        super(region, rows, cols, frames);
    }

    public Ship() {
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);
        reloadTimer += delta;
        if (reloadTimer >= reloadInterval && (pos.y + getHalfHeight() <= worldBounds.getTop()) && pos.y -getHalfHeight() >= worldBounds.getBottom()  ) {
            reloadTimer = 0f;
            shoot();
//            if (pos.y != -0.375)
//            System.out.println("pos.y + getHalfHeight() = " + (pos.y + getHalfHeight()) + " worldBounds.getTop() = " + worldBounds.getTop());
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
   //     shipRectangle.setPosition(pos.x, pos.y);
    }

    private void shoot() {
        bulletSound.play();
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, damage);
    }

}
