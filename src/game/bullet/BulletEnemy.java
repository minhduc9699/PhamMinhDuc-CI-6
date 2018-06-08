package game.bullet;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;

import java.awt.*;

public class BulletEnemy extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;


    public BulletEnemy(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png",6,6);
        this.boxCollider = new BoxCollider(6,6);
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 3, this.position.y - 3);
    }

}
