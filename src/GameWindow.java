import input.KeyboardInput;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    long lastTime =0;

    public GameWindow () {
        this.setSize(1024, 600); // set size window
        this.setupGameCanvas();
        this.event();
        this.setVisible(true);// cho phep cua so window hien thi
    }


    private void setupGameCanvas(){
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void event(){
        this.keyboardEvent();
        this.windowEvent();
    }

    private void keyboardEvent(){
        this.addKeyListener(KeyboardInput.instance);

//        this.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//            }
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if(e.getKeyCode()== KeyEvent.VK_LEFT){
//                    gameCanvas.player.playerMove.angle -= 10;
//
//                }
//                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
//                    gameCanvas.player.playerMove.angle += 10;
//                }
//                base.Vector2D rotate = (new base.Vector2D(4,0)).rotate(gameCanvas.player.playerMove.angle);
//                gameCanvas.player.playerMove.velocity.set(rotate);
//
//                if(e.getKeyCode()==KeyEvent.VK_UP){
//                    gameCanvas.player.playerMove.velocity.multiply(2);
//
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                if(e.getKeyCode()==KeyEvent.VK_UP){
//                    base.Vector2D rotate = (new base.Vector2D(4,0)).rotate(gameCanvas.player.playerMove.angle);
//                    gameCanvas.player.playerMove.velocity.set(rotate);
//
//                }
//
//            }
//        });

    }
    private void windowEvent(){
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }


    public void gameLoop(){
        while(true){
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000){
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }

        }
    }
}
