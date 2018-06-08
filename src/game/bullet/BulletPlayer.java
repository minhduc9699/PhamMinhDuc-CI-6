package game.bullet;


import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;

public class BulletPlayer extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;


    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 4, 4);
        this.boxCollider = new BoxCollider(6, 6);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 3, this.position.y - 3);
        GameObject collider = GameObjectManager.instance.checkCollision(this);
        if(collider !=null)
        {
            collider.isAlive =false;
            this.isAlive =false;
        }


    }
}