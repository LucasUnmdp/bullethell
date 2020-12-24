package Game;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.Image;
import Engine.gfx.ImageTile;
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
    private int tileX=0,tileY=0;

    private boolean inmunity=false;
    private ImageTile image;

    public Player(int posX,int posY){
        this.tag="player";
        hp=3;
        this.posX=posX;
        this.posY=posY;
        this.width=16;
        this.height=31;
        this.image = new ImageTile("/player/default.png",32,32);
    }

    @Override
    public void update(GameContainer gc,GameManager gm, float dt) {
        //Movement Start
        if(gc.getInput().isKey(KeyEvent.VK_W) && isIn(0,-dt*speed,gc)){
            tileX=3;
            posY-=dt*speed;
        }
        if(gc.getInput().isKey(KeyEvent.VK_S)&& isIn(0,dt*speed,gc)){
            tileX=0;
            posY+=dt*speed;
        }
        if(gc.getInput().isKey(KeyEvent.VK_A)&& isIn(-dt*speed,0,gc)){
            tileX=2;
            posX-=dt*speed;
        }
        if(gc.getInput().isKey(KeyEvent.VK_D)&& isIn(dt*speed,0,gc)){
            tileX=1;
            posX+=dt*speed;
        }
        //Movement Finish

        //Shoot Start
        if(fireCD>0) {
            this.fireCD--;
        }
        if (gc.getInput().isKey(KeyEvent.VK_UP)) {
            if(fireCD==0) {
                gm.addObject(new PlayerBullet(2, posX +3, posY -height/2));
                fireCD=rateFire;
                tileY=1;
            }
            tileX=3;
            }
            else
                if (gc.getInput().isKey(KeyEvent.VK_RIGHT)){
                    if(fireCD==0) {
                        gm.addObject(new PlayerBullet(3, posX + width, posY + height / 2));
                        fireCD=rateFire;
                        tileY=1;
                    }
                    tileX=1;
                }
                else
                    if (gc.getInput().isKey(KeyEvent.VK_DOWN)) {
                        if(fireCD==0) {
                            gm.addObject(new PlayerBullet(4, posX + width / 5, posY + height/2));
                            fireCD = rateFire;
                            tileY=1;
                        }
                        tileX=0;
                    }
                    else
                        if (gc.getInput().isKey(KeyEvent.VK_LEFT)) {
                            if(fireCD==0) {
                                gm.addObject(new PlayerBullet(1, posX - width / 2, posY + height / 2));
                                fireCD = rateFire;
                                tileY=1;
                            }
                            tileX=2;

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
        r.drawImageTile(this.image,(int)this.posX,(int)this.posY,tileX,tileY);
        if(tileY==1 && fireCD==rateFire-5){
            tileY--;
        }
    }

    public int getHP(){
        return this.hp;
    }

}
