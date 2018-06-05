import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StarSpawner extends GameObjects{
    List<Star> stars;
    FrameCounter frameCounter = new FrameCounter(10);
    Random random;
    public StarSpawner() {
        this.stars = new ArrayList<>();
        this.random = new Random();
    }
    @Override
    public void run(){
        if(this.frameCounter.run()){
            Star star = new Star();
            star.position.set(1024, random.nextInt(600));
            star.velocity.set(-(random.nextInt(3)+1),0);
            this.stars.add(star);
            this.frameCounter.reset();
        }
        this.stars.forEach(star -> star.run());

    }
}