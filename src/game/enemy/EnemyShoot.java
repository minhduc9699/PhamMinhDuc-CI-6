package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.BulletEnemy;

public class EnemyShoot {

    private FrameCounter frameCounter ;

    public EnemyShoot(){
        this.frameCounter = new FrameCounter(200);
    }

    public void run(Enemy enemy){

        if(this.frameCounter.run()){
            for(int angle=0; angle<360; angle+=30){
                BulletEnemy bulletEnemy = GameObjectManager.instance.recycle(BulletEnemy.class);
                bulletEnemy.velocity= new Vector2D(5,0).rotate(angle);
                bulletEnemy.position.set(enemy.position);
            }
            this.frameCounter.reset();
        }

    }

}
