package game.player;

import base.FrameCounter;
import input.KeyboardInput;

public class PlayerShoot {
    private FrameCounter frameCounter, frameCounter1;
    public Shoot shoot;
    public SingleShoot singleShoot;
    public TripleShoot tripleShoot;
    public boolean changeShoot = false;


    public PlayerShoot() {
        this.frameCounter = new FrameCounter(20);
        this.frameCounter1 = new FrameCounter(1500);
        this.tripleShoot = new TripleShoot();
        this.singleShoot = new SingleShoot();
        this.shoot = this.singleShoot;
    }

    public void run(Player player) {
        if(changeShoot){
            if(this.frameCounter1.run()){
                this.shoot = this.singleShoot;
                this.frameCounter1.reset();
            }

        }

        if (this.frameCounter.run()) {
            if (KeyboardInput.instance.spacePressed) {
                this.shoot.shoot(player);
                this.frameCounter.reset();
            }
        }


    }
}