package game.BuffObjects;

import action.ActionAdapter;
import action.LimitAction;
import action.SequenceAction;
import action.WaitAction;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class BuffObjectSpawner extends GameObject {
    private FrameCounter frameCounterShield, frameCounterShoot;
    private Random random;

    public BuffObjectSpawner(){
        this.frameCounterShield = new FrameCounter(600);
        this.frameCounterShoot = new FrameCounter(800);
        this.random = new Random();
        this.createAction();
    }

    public void createAction(){
        this.addAction(
                new SequenceAction(
                        new WaitAction(600),
                        new LimitAction(
                                new SequenceAction(
                                        new ActionAdapter() {
                                            @Override
                                            public boolean run(GameObject owner) {
                                                int chooseEffect = random.nextInt(3);
                                                System.out.println(chooseEffect);
                                                if(chooseEffect <2){
                                                    EffectShield effectShield = GameObjectManager.instance.recycle(EffectShield.class);
                                                    effectShield.position.set(random.nextInt(800)+ 50, random.nextInt(400)+50);
                                                }
                                                else{
                                                    TripleShoot effectTripleShoot = GameObjectManager.instance.recycle(TripleShoot.class);
                                                    effectTripleShoot.position.set(random.nextInt(800)+50,random.nextInt(400)+50);
                                                }
                                                return true;
                                            }
                                        },
                                        new WaitAction(500)
                                )
                                ,4
                        )
                )
        );
    }

    public void run(){
        super.run();


    }

}
