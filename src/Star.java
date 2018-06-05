import java.awt.*;
import java.awt.image.BufferedImage;

public class Star extends GameObjects{

    public Vector2D velocity;

    public Star() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png",5,5);
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