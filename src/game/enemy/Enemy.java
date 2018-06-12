package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.BulletPlayer;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class Enemy extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;


    public Enemy(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png",20,20);
        this.boxCollider = new BoxCollider(20,20);

    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x-10,this.position.y-10);
        Player player= GameObjectManager.instance.findPlayer();
        if (player != null){
            this.velocity.set(
                    player.position
                            .subtract(this.position)
                            .normalize()
                            .multiply(1.5f));
        }

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Player || gameObject instanceof BulletPlayer){
            this.isAlive = false;
        }

    }
}