package Game.Enemies;

import Engine.GameContainer;
import Game.GameManager;

public class RingBossH extends Enemy {

    RingBossManager rm;

    public RingBossH(float posY, RingBossManager rm){
        this.posY=posY;
        this.posX=0;
        this.height=40;
        this.width=480;
        this.rm=rm;
    }

    @Override
    void move(GameContainer gc, float dt) {

    }

    @Override
    void shoot(GameContainer gc, GameManager gm) {

    }

    @Override
    void deathAnimation(GameManager gm) {

    }

    @Override
    public void damage(int x) {
        rm.damage(x);
    }
}
