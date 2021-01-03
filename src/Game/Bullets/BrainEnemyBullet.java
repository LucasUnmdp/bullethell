package Game.Bullets;

import Engine.GameContainer;

public class BrainEnemyBullet extends EnemyBullet{

    boolean flag=true;

    public BrainEnemyBullet(float posX, float posY, float posfX, float posfY) {
        super(posX, posY, posfX, posfY);
    }

    @Override
    void move(GameContainer gc, float dt) {
        if(flag && posY<gc.getHeight()-height && posX>width && posX<gc.getWidht()-width) {
            super.move(gc,dt);
        }
        else {
            flag=false;
            this.speed=50;
        }
        if(!flag)
            posY-=dt*speed;
    }

    @Override
    protected void bulletLife(GameContainer gc) {
        if(posY<-height)
            this.dead=true;
    }
}
