package Game.Bullets;

import Engine.GameContainer;
import Game.GameManager;
import Game.GameObject;

import java.util.ArrayList;

public class PlayerBullet extends Bullet{

    public PlayerBullet(int direction, float posX, float posY) {
        super(direction, posX, posY);
    }

    @Override
    void move(float dt) {
        float offX=0,offY=0;
        switch (direction){
            case 1:
                offX=-dt*speed;
                break;
            case 2:
                offY=-dt*speed;
                break;
            case 3:
                offX=dt*speed;
                break;
            case 4:
                offY=dt*speed;
        }
        this.posX+=offX;
        this.posY+=offY;
    }

    @Override
    void collision(GameManager gm) {
        ArrayList<GameObject> list=gm.getEnemies();
        for(GameObject e : list){
            if(this.checkCollision(e)) {
                e.setDead(true);
                this.dead=true;
            }
        }
    }
}
