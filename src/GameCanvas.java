import base.GameObjectManager;
import game.Particle;
import game.background.Background;
import game.BuffObjects.BuffObjectSpawner;
import game.enemy.EnemySpawner;
import game.enemy.SpecialEnemySpawner;
import game.player.Player;
import game.star.StarSpawner;
import input.KeyboardInput;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class GameCanvas extends JPanel {


    BufferedImage backBuffered;
    Graphics graphics;

    Player player;
    Particle particle = new Particle();

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
        GameObjectManager.instance.add(new Background());

        this.setupPlayer();
        GameObjectManager.instance.add(new StarSpawner());
        GameObjectManager.instance.add(new EnemySpawner());
        GameObjectManager.instance.add(new SpecialEnemySpawner());
//
        GameObjectManager.instance.add(new BuffObjectSpawner());
    }



    private  void setupPlayer(){
        this.player = GameObjectManager.instance.recycle(Player.class);
        this.player.position.set(500,300);
        this.player.playerMove.velocity.set(4,0);

    }



    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);

    }

    public void renderAll(){

        GameObjectManager.instance.renderAll(this.graphics);

        this.repaint();
    }


    public void runAll(){
        GameObjectManager.instance.runAll();
        this.particle.run(this.player);
        KeyboardInput.instance.reset();

    }





}
