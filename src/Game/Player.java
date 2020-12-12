package Game;

import Engine.GameContainer;
import Engine.Renderer;
import Game.Bullets.PlayerBullet;

import java.awt.event.KeyEvent;

public class Player extends GameObject{

    private float speed = 150;
    private final float rateFire = 60;
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
        if(gc.getInput().isKey(KeyEvent.VK_W) && isIn(0,-dt*speed,gc)){
            posY-=dt*speed;
        }
        if(gc.getInput().isKey(KeyEvent.VK_S)&& isIn(0,dt*speed,gc)){
            posY+=dt*speed;
        }
        if(gc.getInput().isKey(KeyEvent.VK_A)&& isIn(-dt*speed,0,gc)){
            posX-=dt*speed;
        }
        if(gc.getInput().isKey(KeyEvent.VK_D)&& isIn(dt*speed,0,gc)){
            posX+=dt*speed;
        }
        //Movement Finish

        //Shoot Start
        if(fireCD>0)
            this.fireCD--;
        if(fireCD==0) {
            if (gc.getInput().isKey(KeyEvent.VK_UP)) {
                gm.addObject(new PlayerBullet(2, posX + width / 5, posY - height / 2));
                fireCD=rateFire;
            }
            else
                if (gc.getInput().isKey(KeyEvent.VK_RIGHT)){
                    gm.addObject(new PlayerBullet(3, posX + width, posY + height / 5));
                    fireCD=rateFire;
                }
                else
                    if (gc.getInput().isKey(KeyEvent.VK_DOWN)) {
                        gm.addObject(new PlayerBullet(4, posX + width / 5, posY + height));
                        fireCD = rateFire;
                    }
                    else
                        if (gc.getInput().isKey(KeyEvent.VK_LEFT)) {
                            gm.addObject(new PlayerBullet(1, posX - width / 2, posY + height / 5));
                            fireCD = rateFire;
                        }
        }
        //Shoot finish

    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.fillRect((int)posX,(int)posY,width,height,0xff00ff00);
    }

}
