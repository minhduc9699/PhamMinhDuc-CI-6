package game.enemy;


import base.GameObject;
import base.Vector2D;

import game.bullet.BulletPlayer;
import game.BuffObjects.Shield;
import game.player.Player;
import physic.BoxCollider;

import renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;

public class SpecialEnemy extends Enemy {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private Random random;
    private game.enemy.EnemyShoot enemyShoot;


    //constructor
    public SpecialEnemy(){
        this.random = new Random();
        this.velocity = new Vector2D(1,0);
        this.renderer = new ImageRenderer("resources/images/circle.png",20,20,Color.ORANGE);
        this.boxCollider = new BoxCollider(20,20);
        this.enemyShoot = new game.enemy.EnemyShoot();
    }

    @Override
    public void run(){
//        super.run();
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
        this.boxCollider.position.set(this.position.x-10,this.position.y-10);
        this.backToScreen();
    }

    private void backToScreen() {
        if (this.position.x > 1024) {
            this.position.set(0, this.random.nextInt(600));
        }
        if (this.position.x < 0) {
            this.position.set(1024, this.random.nextInt(600));
        }
        if (this.position.y > 600) {
            this.position.set(this.random.nextInt(1024), 0);
        }
        if (this.position.y < 0) {
            this.position.set(this.random.nextInt(1024), 600);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Player || gameObject instanceof BulletPlayer || gameObject instanceof Shield){
            this.isAlive = false;
        }

    }
}