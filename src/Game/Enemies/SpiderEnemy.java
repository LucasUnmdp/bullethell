package Game.Enemies;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.ImageTile;
import Engine.gfx.Light;
import Engine.sfx.SoundClip;
import Game.Animations.SpiderDeathAnimation;
import Game.GameManager;

public class SpiderEnemy extends Enemy{

    private final int steps=20;
    private int currentSteps=0;
    private int pause=0;
    private float offY,offX;
    private int tileX,tileY;
    private int sign;
    private SoundClip soundClip= new SoundClip("/audio/spider-walking.wav");

    public SpiderEnemy(float posY,float posXmax){
        super();
        if(Math.random()>=0.5) {
            sign = 1;
            posX=0;
        }
        else {
            sign = -1;
            posX=posXmax-width-15;

        }
        this.posY=posY;
        this.width=16;
        this.height=16;
        this.speed=100;
        this.image= new ImageTile("/enemies/spider_enemy.png",17,17);
        this.light= new Light(8,0x00ff00);
        this.soundClip.setVolume(-40);
    }
    @Override
    void move(GameContainer gc,float dt) {
        if(currentSteps>0) {
            this.posX += offX;
            this.posY += offY;
            currentSteps--;
        }else{
            if(pause==steps) {
                tileY = 0;
                checkDirection(dt);
            }
            pause--;
            if(pause<=0){
                currentSteps=steps;
                pause=steps;
                tileY=1;
                soundClip.play();
            }
        }
    }

    @Override
    void shoot(GameContainer gc,GameManager gm) {

    }

    @Override
    void deathAnimation(GameManager gm) {
        gm.addObject(new SpiderDeathAnimation(this.posX,this.posY));
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImageTile(image,(int)posX,(int)posY,tileX,tileY);
        r.drawLight(light,(int)posX+width/2,(int)posY+height/2);
    }

    private void checkDirection(float dt){
        switch ((int)Math.round(Math.random()*4)){
            case 0:
                offX=dt*speed*sign;
                offY=0;
                if(sign==1)
                    tileX=2;
                else
                    tileX=1;
                break;
            case 1:
                offX=dt*speed*sign;
                offY=-dt*speed;
                if(sign==1)
                    tileX=5;
                else
                    tileX=4;
                break;
            case 2:
                offX=dt*speed*sign;
                offY=dt*speed;
                if(sign==1)
                    tileX=6;
                else
                    tileX=7;
                break;
            case 3:
                offX=0;
                offY=dt*speed;
                tileX=0;
                break;
            case 4:
                offX=0;
                offY=-dt*speed;
                tileX=3;
                break;
        }
    }
}
