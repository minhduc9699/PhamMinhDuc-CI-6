package game.player;

import base.GameObject;

import base.GameObjectManager;
import base.Vector2D;
import game.BuffObjects.TripleShoot;
import game.bullet.BulletEnemy;
import game.BuffObjects.*;
import game.enemy.Enemy;
import game.enemy.SpecialEnemy;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject implements PhysicBody {
    public BoxCollider boxCollider;

    public PlayerMove playerMove;

    private PlayerShoot playerShoot;

    private RunHitObject runHitObject;
    private CreateSmoke createSmoke;


    public boolean hitEnemy= false;


    public Player() {
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(20,16);
        this.runHitObject = new RunHitObject(
                Enemy.class,
                BulletEnemy.class,
                SpecialEnemy.class,
                EffectShield.class,
                TripleShoot.class);
        this.createSmoke =new CreateSmoke();



    }


    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.boxCollider.position.set(this.position.x-10,this.position.y-8);

        this.playerShoot.run(this);

        ((PolygonRenderer)(this.renderer)).angle = this.playerMove.angle;
        this.runHitObject.run(this);
        this.createSmoke.run(this);

    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Enemy || gameObject instanceof BulletEnemy || gameObject instanceof SpecialEnemy ) {
            this.isAlive = false;
            if (gameObject instanceof Enemy || gameObject instanceof SpecialEnemy) {
                this.hitEnemy = true;
            }
        }

        if(gameObject instanceof EffectShield){
            GameObjectManager.instance.recycle(Shield.class);

        }
        if(gameObject instanceof TripleShoot){
            this.playerShoot.shoot = this.playerShoot.tripleShoot;
            this.playerShoot.changeShoot = true;
        }
    }

}

