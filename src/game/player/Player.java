package game.player;

import base.GameObject;
import base.Vector2D;
import game.bullet.BulletEnemy;
import game.BuffObjects.Shield;
import game.BuffObjects.TripleShoot;
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

    private  int life;

   public boolean specialShoot;

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
                Shield.class,
                TripleShoot.class);
        this.life =1;
        this.specialShoot = false;
    }


    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.boxCollider.position.set(this.position.x,this.position.y);

        this.playerShoot.run(this);

        ((PolygonRenderer)(this.renderer)).angle = this.playerMove.angle;
        this.runHitObject.run(this);
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Enemy || gameObject instanceof BulletEnemy || gameObject instanceof SpecialEnemy ){
            if(this.life==1){
                this.isAlive = false;
            }
            else{
                this.life -=1;
            }
        }
        if(gameObject instanceof Shield){
            this.life = 4;
        }
        if(gameObject instanceof TripleShoot){
            this.specialShoot = true;
        }
    }

    @Override
    public void render(Graphics graphics){
        super.render(graphics);
        if(this.life >1){
            graphics.setColor(Color.GREEN);
            graphics.drawOval((int)this.position.x-25, (int)this.position.y-25, 50,50);
        }


    }
}