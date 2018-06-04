import java.awt.*;

public class GameObjects {
    public Vector2D position;
    public Renderer renderer;

    public GameObjects () {
        this.position = new Vector2D();
    };

    public void run() {
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
