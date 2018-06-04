import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerShoot {
    public List<BulletPlayer> bulletsPlayer;
    private int countBullet = 0;

    public PlayerShoot(){
        this.bulletsPlayer = new ArrayList<>();
    }

    public void run(Player player){
        if(countBullet ==20){
        BulletPlayer bulletPlayer = new BulletPlayer();
        bulletPlayer.position.set(player.position);
        bulletPlayer.velocity.set(player.velocity.add(player.velocity.normalize().multiply(10)));

        this.bulletsPlayer.add(bulletPlayer);
        countBullet =0;
        }
        else{
            countBullet +=1;
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
