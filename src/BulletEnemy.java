import java.awt.*;

public class BulletEnemy extends GameObjects {

    public Vector2D velocity;

    public BulletEnemy(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png",6,6);
    }

    @Override
    public void run(){
        super.run();
        this.position.addUp(this.velocity);
    }

    @Override
    public void render(Graphics graphics){
        super.render(graphics);
    }
}