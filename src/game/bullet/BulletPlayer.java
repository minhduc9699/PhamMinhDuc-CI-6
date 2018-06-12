package game.bullet;


import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import game.enemy.SpecialEnemy;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
//import physic.RunHitObject;
import renderer.ImageRenderer;

import java.awt.*;

public class BulletPlayer extends GameObject implements PhysicBody {

    public Vector2D velocity;
    public BoxCollider boxCollider;
//    private RunHitObject runHitObject;



    public BulletPlayer() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 4, 4);
        this.boxCollider = new BoxCollider(6, 6);
//        this.runHitObject = new RunHitObject(Enemy.class, BulletEnemy.class,SpecialEnemy.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 3, this.position.y - 3);
//        this.runHitObject.run(this);
        GameObjectManager.instance.killObject(this);


    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Enemy || gameObject instanceof BulletEnemy || gameObject instanceof SpecialEnemy){
            this.isAlive = false;
        }

    }
}