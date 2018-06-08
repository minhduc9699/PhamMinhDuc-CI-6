package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import physic.BoxCollider;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject {
    public BoxCollider boxCollider;

    public PlayerMove playerMove;

    private PlayerShoot playerShoot;

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
    }


    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.boxCollider.position.set(this.position.x,this.position.y);
        GameObject collider = GameObjectManager.instance.checkCollision(this);
        if(collider !=null)
        {
            collider.isAlive =false;
            this.isAlive =false;
        }
        this.playerShoot.run(this);

        ((PolygonRenderer)(this.renderer)).angle = this.playerMove.angle;
    }



}

