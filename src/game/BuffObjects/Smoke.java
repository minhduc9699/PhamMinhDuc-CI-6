package game.BuffObjects;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;


public class Smoke extends GameObject {

    public Vector2D velocity;
    private FrameCounter frameCounter = new FrameCounter(1);

    public Smoke() {
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
        if (!this.frameCounter.run())
            return;
        ImageRenderer imageRenderer = (ImageRenderer) this.renderer;
        if (imageRenderer != null) {
            imageRenderer.width -= 2;
            imageRenderer.height -= 2;
            if (imageRenderer.width <= 0 || imageRenderer.height <= 0) {
                this.isAlive = false;
            }
        }
        this.frameCounter.reset();
    }
}