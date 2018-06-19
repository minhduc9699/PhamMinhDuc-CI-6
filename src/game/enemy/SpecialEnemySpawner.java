package game.enemy;

import action.*;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class SpecialEnemySpawner  extends GameObject {
    private FrameCounter frameCounter ;
    Random random;


    public SpecialEnemySpawner(){
        this.random = new Random();
        this.frameCounter = new FrameCounter(1000);
        this.createAction();
    }

    public void createAction(){
        this.addAction(
                new SequenceAction(
                        new WaitAction(1200),
                        new LimitAction(
                                new SequenceAction(
                                        new ActionAdapter() {
                                            @Override
                                            public boolean run(GameObject owner) {
                                                SpecialEnemy enemy = GameObjectManager.instance.recycle(SpecialEnemy.class);
                                                enemy.position.set(random.nextInt(1024), random.nextInt(600));
                                                return true;
                                            }
                                        },new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        return GameObjectManager.instance.countObjectAlive(SpecialEnemy.class)==0;
                                    }
                                }


                                ),
                                5
                        )
                )
        );
    }

    @Override
    public  void run(){

            super.run();


    }
}