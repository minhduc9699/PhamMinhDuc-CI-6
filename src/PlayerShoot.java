import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerShoot {
    public List<BulletPlayer> bulletsPlayer;
    private int countBullet = 0;
    private FrameCounter frameCounter = new FrameCounter(10);

    public PlayerShoot(){
        this.bulletsPlayer = new ArrayList<>();
    }

    public void run(Player player){
        if(frameCounter.run()){
        BulletPlayer bulletPlayer = new BulletPlayer();
        bulletPlayer.position.set(player.position);
        bulletPlayer.velocity.set(player.playerMove.velocity.add(player.playerMove.velocity.normalize().multiply(6)));

        this.bulletsPlayer.add(bulletPlayer);
        frameCounter.reset();
        }

        Iterator<BulletPlayer> it = bulletsPlayer.iterator();
        while (it.hasNext()) {
            BulletPlayer bullet = it.next();
            if(bullet.position.x <0 || bullet.position.x >1024 || bullet.position.y<0 ||bullet.position.y >1024) {
                it.remove();
            }
        }
    }
}