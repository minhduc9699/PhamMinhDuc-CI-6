import java.awt.*;

public class BulletPlayer extends GameObjects {

    public Vector2D velocity;

    public BulletPlayer(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png",4,4);
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