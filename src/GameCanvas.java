import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;
    Background background;
    List<Star> stars;
    List<Enemy>  enemies;
    EnemyAttack enemyAttack;
    Player player;
    private Random random = new Random();
    private FrameCounter frameCounter = new FrameCounter(10);
    private int countEnemy =0;



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
        this.setupStar();
        this.setupEnemy();
    }


    private  void setupEnemyAttack(){
        this.enemyAttack = new EnemyAttack();
        this.enemyAttack.position.set(random.nextInt(1024),random.nextInt(600));
        this.enemyAttack.velocity.set(4,0);
    }


    private  void setupPlayer(){
        this.player = new Player();
        this.player.position.set(500,300);
        this.player.velocity.set(4,0);
    }


    private void setupStar(){
        this.stars = new ArrayList<>();
    }
    private void setupEnemy(){
        this.enemies = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);

    }

    public void renderAll(){
        this.background.render(graphics);

        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));

        this.player.render(graphics);
        this.enemyAttack.render(graphics);

        this.repaint();
    }

    public void runAll(){
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.createEnemy();
        this.enemies.forEach(enemy -> {
            Vector2D velocity = player.position.subtract(enemy.position).normalize()
                    .multiply(2);
            enemy.velocity.set(velocity);
        });
        Vector2D velocity = player.position.subtract(enemyAttack.position).normalize()
                .multiply(2);
        this.enemyAttack.velocity.set(velocity);
        this.enemyAttack.run();
        this.enemies.forEach(enemy -> enemy.run());
        this.player.run();

    }

    private  void createStar(){
        if(this.frameCounter.run()){
            Star star = new Star();
            star.position.set(1024,this.random.nextInt(600));
            star.velocity.set(-(this.random.nextInt(3)+1),0);

            this.stars.add(star);
            this.frameCounter.reset();
        }
    }
    private void createEnemy(){
        if(this.countEnemy==80){

            Enemy enemy = new Enemy();
            enemy.position.set(this.random.nextInt(1024),this.random.nextInt(600));
            this.enemies.add(enemy);
            this.countEnemy =0;
        }
        else{
            this.countEnemy +=1;
        }
    }
}
