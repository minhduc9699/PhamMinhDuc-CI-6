import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnemyShoot {
    public List<BulletEnemy> bulletEnemies;
    private int countBullet = 0;
    private double angleBullet =0;

    public EnemyShoot(){
        this.bulletEnemies = new ArrayList<>();
    }

    public void run(EnemyAttack enemy){

        if(countBullet ==100){
            for(int i=0; i<12 ; i++){
                BulletEnemy bulletEnemy = new BulletEnemy();
                this.angleBullet +=30;
                bulletEnemy.velocity= new Vector2D(5,0).rotate(this.angleBullet);
                bulletEnemy.position.set(enemy.position);
                this.bulletEnemies.add(bulletEnemy);
            }

            countBullet =0;
            this.angleBullet =0;

        }
        else{
            countBullet +=1;
        }

        Iterator<BulletEnemy> it = bulletEnemies.iterator();
        while (it.hasNext()) {
            BulletEnemy bullet = it.next();
            if(bullet.position.x <0 || bullet.position.x >1024 || bullet.position.y<0 ||bullet.position.y >1024) {
                it.remove();
            }
        }



    }

}
