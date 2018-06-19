package game.BuffObjects;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import renderer.ImageRenderer;

import java.awt.*;

public class CreateSmoke extends GameObject {
    private FrameCounter frameCounter ;


    public CreateSmoke(){
        this.frameCounter = new FrameCounter(10);
    }

    public void run(Player player) {
        if (this.frameCounter.run()) {
            Smoke smoke = GameObjectManager.instance.recycle(Smoke.class);
            smoke.renderer = new ImageRenderer("resources/images/circle.png", 10, 10, Color.LIGHT_GRAY);
            smoke.position.set(player.position);

            Vector2D rotate = player.playerMove.velocity.add(
                    (new Vector2D(1.5f, 0)).rotate(player.playerMove.angle)
            );
            smoke.velocity.set(rotate);
            this.frameCounter.reset();
        }
    }
}

