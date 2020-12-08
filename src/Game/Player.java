package Game;

import Engine.GameContainer;
import Engine.Renderer;
import Game.Bullets.PlayerBullet;

import java.awt.event.KeyEvent;

public class Player extends GameObject{

    private float speed = 150;
    private final float rateFire = 15;
    private float fireCD=0;

    public Player(int posX,int posY){
        this.tag="player";
        this.posX=posX;
        this.posY=posY;
        this.width=GameManager.TS;
        this.height=GameManager.TS;
    }

    @Override
    public void update(GameContainer gc,GameManager gm, float dt) {
        //Movement Start
        if(gc.getInput().isKey(KeyEvent.VK_W) && isIn(posX,posY-dt*speed,gc)){
            posY-=dt*speed;
        }
        if(gc.getInput().isKey(KeyEvent.VK_S)&& isIn(posX,posY+height+dt*speed,gc)){
            posY+=dt*speed;
        }
        if(gc.getInput().isKey(KeyEvent.VK_A)&& isIn(posX-dt*speed,posY,gc)){
            posX-=dt*speed;
        }
        if(gc.getInput().isKey(KeyEvent.VK_D)&& isIn(posX+width+dt*speed,posY,gc)){
            posX+=dt*speed;
        }
        //Movement Finish

        //Shoot Start
        if(fireCD>0)
            fireCD-=1;
        if(fireCD==0) {
            fireCD=rateFire;
            if (gc.getInput().isKey(KeyEvent.VK_UP))
                gm.addObject(new PlayerBullet(2, posX + width / 5, posY - height / 2));
            else
                if (gc.getInput().isKey(KeyEvent.VK_RIGHT))
                    gm.addObject(new PlayerBullet(3, posX + width, posY + height / 5));
                else
                    if (gc.getInput().isKey(KeyEvent.VK_DOWN))
                        gm.addObject(new PlayerBullet(4, posX + width / 5, posY + height));
                    else
                        if (gc.getInput().isKey(KeyEvent.VK_LEFT))
                            gm.addObject(new PlayerBullet(1, posX - width / 2, posY + height / 5));

        }

    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.fillRect((int)posX,(int)posY,width,height,0xff00ff00);
    }

}