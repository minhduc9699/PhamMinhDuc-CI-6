import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;
    Background background;
    StarSpawner starSpawner;
    EnemySpawner enemySpawner;
    EnemyAttack EnemyAttack;
    Player player;
    private Random random = new Random();

    public GameCanvas()  {
        this.setSize(1024, 600);
        this.setupCharacter();
        this.setupBackbuffered();
        this.setVisible(true);

    }
    private void setupBackbuffered(){
        this.backBuffered = new BufferedImage(1024,600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter(){
        this.background = new Background();
        this.setupEnemyAttack();
        this.setupPlayer();
        this.starSpawner = new StarSpawner();
        this.enemySpawner = new EnemySpawner();
    }

    private  void setupEnemyAttack(){
        this.EnemyAttack = new EnemyAttack();
        this.EnemyAttack.position.set(random.nextInt(1024),random.nextInt(600));
        this.EnemyAttack.velocity.set(4,0);
    }

    private  void setupPlayer(){
        this.player = new Player();
        this.player.position.set(500,300);
        this.player.playerMove.velocity.set(4,0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);

    }

    public void renderAll(){
        this.background.render(graphics);
        this.starSpawner.stars.forEach(star -> star.render(graphics));
        this.enemySpawner.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(graphics);
        this.EnemyAttack.render(graphics);

        this.repaint();
    }

    public void runAll(){

        this.starSpawner.run();

        this.enemySpawner.enemies.forEach(enemy -> {
            Vector2D velocity = player.position.subtract(enemy.position).normalize()
                    .multiply(2);
            enemy.velocity.set(velocity);
        });

        this.enemySpawner.run();

        Vector2D velocity = player.position.subtract(EnemyAttack.position).normalize()
                .multiply(2);

        this.EnemyAttack.velocity.set(velocity);
        this.EnemyAttack.run();
        this.player.run();

    }
}