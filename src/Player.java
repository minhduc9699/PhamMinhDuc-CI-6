import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Player extends GameObjects{

    public PlayerMove playerMove;
    private PlayerShoot playerShoot;

    public Player() {

        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.playerShoot.run(this);
        this.playerShoot.bulletsPlayer.forEach(bulletPlayer -> bulletPlayer.run());
        ((PolygonRenderer)(this.renderer)).angle = this.playerMove.angle;
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        this.playerShoot.bulletsPlayer.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
}

