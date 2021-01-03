package Game.Enemies;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.ImageTile;
import Engine.gfx.Light;
import Game.Bullets.BrainEnemyBullet;
import Game.GameManager;

public class BrainEnemy extends Enemy{

    private int sign;
    private int shootCD=60,cd=60;
    private double limy;
    int tileX=0;

    public BrainEnemy(float posX){
        super();
        this.posX=posX;
        this.posY=0;
        this.width=49;
        this.height=30;
        this.speed=50;
        this.hp=7;
        if(Math.random()>=0.5)
            sign=1;
        else
            sign=-1;
        limy=Math.random()*(8-6)+6;
        this.light= new Light(30,0xd7777b);
        this.image= new ImageTile("/enemies/brain_enemy.png",this.width,this.height);
    }
    @Override
    void move(GameContainer gc, float dt) {
        if(posY<gc.getHeight()/limy)
            posY+=dt*speed;
        else {
            posX += dt * speed * sign;
            if (posX > gc.getWidht()-100)
                sign = -1;
            else
                if (posX < 100)
                    sign = 1;
        }
    }

    @Override
    void shoot(GameContainer gc,GameManager gm) {
        cd--;
        if(cd==0){
            tileX=1;
            cd=shootCD;
            for(int i=5;i<width;i+=10)
                gm.addObject(new BrainEnemyBullet(posX+i,posY+height,(float)(Math.random()*gc.getWidht()),gc.getHeight()));
        }
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImageTile(image,(int)posX,(int)posY,tileX,0);
        if(tileX==1 && cd==shootCD-10)
            tileX=0;
        r.drawLight(light,(int)posX+width/2,(int)posY+height/2);
    }
}
