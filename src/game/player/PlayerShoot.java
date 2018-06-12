package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import game.bullet.BulletPlayer;
import input.KeyboardInput;

public class PlayerShoot {
    private FrameCounter frameCounter, specialFrameCounter;


    public PlayerShoot(){
        this.frameCounter = new FrameCounter(30);
    }

    public void run(Player player){

        if (player.specialShoot ){
            if(this.specialFrameCounter == null)
                this.specialFrameCounter = new FrameCounter(1000);
        }
        else{
            this.specialFrameCounter = null;
        }

        if(this.specialFrameCounter!=null){
            if(this.specialFrameCounter.run()){
                player.specialShoot=false;
            }
        }


        if(this.frameCounter.run()){
            if(KeyboardInput.instance.spacePressed){
                BulletPlayer bulletPlayer = GameObjectManager.instance.recycle(BulletPlayer.class);
                bulletPlayer.position.set(player.position);
                bulletPlayer.velocity.set(player.playerMove.velocity.add(player.playerMove.velocity.normalize().multiply(6)));

                if(this.specialFrameCounter!=null){
                    for(int angle = 90; angle <360; angle +=180){
                        BulletPlayer specialBullet = GameObjectManager.instance.recycle(BulletPlayer.class);
                        specialBullet.position.set(player.position);
                        specialBullet.velocity.set(player.playerMove.velocity
                                .add(player.playerMove.velocity
                                        .normalize()
                                        .rotate(angle)
                                        .multiply(6)));
                    }

                }


                this.frameCounter.reset();


            }

        }

    }
}