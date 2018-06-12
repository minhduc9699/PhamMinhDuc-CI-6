package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class SpecialEnemySpawner  extends GameObject {
    FrameCounter frameCounter ;
    Random random;


    public SpecialEnemySpawner(){

        this.random = new Random();
        this.frameCounter = new FrameCounter(800);
    }
    @Override
    public  void run(){
        if(this.frameCounter.run()){
            super.run();
            SpecialEnemy enemy = GameObjectManager.instance.recycle(SpecialEnemy.class);
            enemy.position.set(this.random.nextInt(1024),this.random.nextInt(600));
            this.frameCounter.reset();
        }
    }
}