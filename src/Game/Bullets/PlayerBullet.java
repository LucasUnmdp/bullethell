package Game.Bullets;

import Engine.GameContainer;
import Engine.Renderer;
import Game.GameManager;
import Game.GameObject;

public class PlayerBullet extends GameObject {

    private float speed=200;
    private int direction;
    float posX,posY;

    public PlayerBullet (int direction,float posX, float posY){
        this.direction=direction;
        this.posX=posX;
        this.posY=posY;
    }

    @Override
    public void update(GameContainer gc, GameManager gm, float dt) {

        //Movement start
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
        //Movement finish

        //Bullet life start
        if(!isIn(posX,posY,gc)){
            this.dead=true;
        }
        //Bullet life finish

    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.fillRect((int)posX,(int)posY,10,10,0xffff0000);
    }
}
