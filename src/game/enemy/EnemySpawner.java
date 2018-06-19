package game.enemy;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class EnemySpawner extends GameObject {

    Random random;

    public EnemySpawner(){
        this.random = new Random();
        this.createAction();
    }

    public void createAction(){
        this.addAction(
                new LimitAction(
                        new SequenceAction(
                                new WaitAction(350),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                                        enemy.position.set(random.nextInt(1024),random.nextInt(600));
                                        return true;
                                    }
                                }
                        )
                        ,70)
        );

    }


    @Override
    public  void run(){

            super.run();

    }
}
