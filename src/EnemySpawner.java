import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemySpawner extends GameObjects{
    List<Enemy> enemies;
    FrameCounter frameCounter = new FrameCounter(100);
    Random random;

    public EnemySpawner(){
        this.enemies = new ArrayList<>();
        this.random = new Random();
    }
    @Override
    public void run(){
        if(this.frameCounter.run()){
            super.run();
            Enemy enemy = new Enemy();
            enemy.position.set(this.random.nextInt(1024),this.random.nextInt(600));
            this.enemies.add(enemy);
            this.frameCounter.reset();
        }
        this.enemies.forEach(enemy -> enemy.run());
    }
}