package Game.Enemies;

import Engine.GameContainer;
import Game.GameManager;

public class RingBossV extends Enemy{

    private RingBossManager rm;

    public RingBossV(float posX, RingBossManager rm){
        this.posX=posX;
        this.posY=0;
        this.height=360;
        this.width=40;
        this.rm=rm;
    }

    @Override
    void move(GameContainer gc, float dt) {

    }

    @Override
    void shoot(GameContainer gc, GameManager gm) {

    }

    @Override
    public void damage(int x) {
        rm.damage(x);
    }
}
