package game.BuffObjects;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class BuffObjectsSpawner extends GameObject {
    private FrameCounter frameCounterShield, frameCounterShoot;
    private Random random;

    public BuffObjectsSpawner(){
        this.frameCounterShield = new FrameCounter(600);
        this.frameCounterShoot = new FrameCounter(800);
        this.random = new Random();
    }

    public void run(){
        if(this.frameCounterShield.run()){
            Shield Shield = GameObjectManager.instance.recycle(Shield.class);
            Shield.position.set(this.random.nextInt(800)+ 50, this.random.nextInt(400)+50);
            this.frameCounterShield.reset();
        }
        if(this.frameCounterShoot.run()){
            TripleShoot TripleShoot = GameObjectManager.instance.recycle(TripleShoot.class);
            TripleShoot.position.set(this.random.nextInt(800)+50, this.random.nextInt(400)+50);
            this.frameCounterShoot.reset();
        }

    }

}