package game.star;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class StarSpawner extends GameObject {

    FrameCounter frameCounter = new FrameCounter(30);
    Random random;
    public StarSpawner() {
        this.random = new Random();
    }
    @Override
    public void run(){
        if(this.frameCounter.run()){
            Star star = new Star();
            star.position.set(1024, random.nextInt(600));
            star.velocity.set(-(random.nextInt(3)+1),0);
            GameObjectManager.instance.add(star);
            this.frameCounter.reset();
        }

    }
}
