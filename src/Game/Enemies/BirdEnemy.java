package Game.Enemies;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.Image;
import Engine.gfx.ImageTile;
import Engine.gfx.Light;
import Game.Bullets.EnemyBullet;
import Game.GameManager;

public class BirdEnemy extends Enemy{
    private float offX;
    private int shootCD=60,shoots=3,actualShoot=shootCD,shootLeft=shoots,miniShootCD=10, miniCD=0,tileX,tileY;
    private ImageTile image;
    private Light light;

    public BirdEnemy(float posX, float posY){
        super();
        this.offX=posX;
        this.posY=posY;
        this.width=16;
        this.height=16;
        if(posY==0) {
            this.speed = 75;
            tileX=0;
        }
        else {
            tileX=1;
            this.speed = -75;
        }
        this.light= new Light(5,0xe53ae5);
        this.image= new ImageTile("/enemies/bird_enemy.png",this.width,this.height);
    }
    @Override
    void move(float dt) {
        posY+=dt*speed;
        posX= (float) (Math.sin((posY)/40)*50+offX);
    }

    @Override
    void shoot(GameManager gm) {
        actualShoot--;
        if(actualShoot<0 && shootLeft>0) {
            if(miniCD==0) {
                gm.addObject(new EnemyBullet(posX, posY, gm.getPlayer().getPosX(), gm.getPlayer().getPosY()));
                miniCD=miniShootCD;
                shootLeft--;
                tileY=1;
            }
            miniCD--;
        }else
            if(shootLeft==0) {
                actualShoot = shootCD;
                shootLeft = shoots;
            }
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImageTile(image,(int)posX,(int)posY,tileX,tileY);
        if(tileY==1 && actualShoot==shootCD-5)
            tileY=0;
        r.drawLight(light,(int)posX+width/2,(int)posY+height/2);
    }
}
