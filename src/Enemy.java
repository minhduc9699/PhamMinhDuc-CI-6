import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObjects {
    public Vector2D velocity;


    public Enemy(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png",20,20);
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
