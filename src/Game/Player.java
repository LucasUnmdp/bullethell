package Game;

import Engine.GameContainer;
import Engine.Renderer;
import Game.Bullets.Bullet;
import Game.Bullets.PlayerBullet;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends GameObject{
    private final int rateFire = 20;
    private final int inmunityTime= 20;

    private float speed = 150;
    private int fireCD=0;
    private int inmunityCD=0;
    private int hp;

    private boolean inmunity=false;

    public Player(int posX,int posY){
        this.tag="player";
        hp=3;
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

        //enemy collision start
        if(!inmunity) {
            ArrayList<GameObject> enemies = gm.getEnemies();
            for (GameObject e : enemies) {
                if (this.checkCollision(e)) {
                    this.hp--;
                    if(hp==0)
                        this.dead=true;
                    this.inmunityCD=inmunityTime;
                    this.inmunity=true;
                    e.setDead(true);
                    break;
                }
            }
        }else{
            if(--inmunityCD==0)
                this.inmunity=false;
        }
        //enemy collision end

    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.fillRect((int)posX,(int)posY,width,height,0xff00ff00);
    }

    public int getHP(){
        return this.hp;
    }

}
