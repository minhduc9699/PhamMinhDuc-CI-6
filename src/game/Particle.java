package game;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.BuffObjects.Smoke;
import game.player.Player;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;


public class Particle extends GameObject {
    public Vector2D velocity;
    public FrameCounter frameCounter;
    private Random random;
    private int numberParticle = 0;


    public Particle(){
        this.velocity = new Vector2D();
        this.random = new Random();
        this.frameCounter = new FrameCounter(5);

    }
    public void run(Player player){
            if(!player.isAlive && player.hitEnemy && numberParticle <3){
                for (int angle = 0; angle < 360; angle += 20) {
                    Smoke smoke = GameObjectManager.instance.recycle(Smoke.class);
                    smoke.renderer = new ImageRenderer("resources/images/circle.png", 25, random.nextInt(25), Color.YELLOW);
                    smoke.position.set(player.position.x + random.nextInt(3),player.position.y +random.nextInt(3) );
                    smoke.velocity= new Vector2D(random.nextInt(3)+1,random.nextInt(3)+1).rotate(angle);
//                    smoke.velocity = new Vector2D(0, 5).rotate(angle);
                }
                if(this.frameCounter.run()){
                    numberParticle++;
                    this.frameCounter.reset();
                }

            }


    }


}
