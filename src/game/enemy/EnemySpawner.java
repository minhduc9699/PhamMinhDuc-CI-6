package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class EnemySpawner extends GameObject {

    FrameCounter frameCounter ;
    Random random;


    public EnemySpawner(){

        this.random = new Random();
        this.frameCounter = new FrameCounter(300);
    }
    @Override
    public  void run(){
        if(this.frameCounter.run()){
            super.run();
            Enemy enemy = new Enemy();
            enemy.position.set(this.random.nextInt(1024),this.random.nextInt(600));
            GameObjectManager.instance.add(enemy);
            this.frameCounter.reset();
        }
    }
}
