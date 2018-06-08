package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import game.bullet.BulletPlayer;
import input.KeyboardInput;

public class PlayerShoot {



    public PlayerShoot(){


    }

    public void run(Player player){
        if(KeyboardInput.instance.spacePressed){
        BulletPlayer bulletPlayer = new BulletPlayer();
        bulletPlayer.position.set(player.position);
        bulletPlayer.velocity.set(player.playerMove.velocity.add(player.playerMove.velocity.normalize().multiply(6)));

        GameObjectManager.instance.add(bulletPlayer);

        }


    }
}
