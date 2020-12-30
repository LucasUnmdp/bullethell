package Game.Enemies;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.ImageTile;
import Engine.gfx.Light;
import Game.GameManager;

public class NormalEnemy extends Enemy{

    private ImageTile image;
    private Light light;
    private final int steps=20;
    private int currentSteps=0;
    private int pause=0;
    private float offX,offY;
    private int tileX,tileY;

    public NormalEnemy(float posX, float posY){
        super();
        this.posX=posX;
        this.posY=posY;
        this.width=16;
        this.height=16;
        this.speed=100;
        this.image= new ImageTile("/enemies/enemy1.png",17,17);
        this.light= new Light(8,0x00ff00);
    }
    @Override
    void move(float dt) {
        if(currentSteps>0) {
            this.posX += offX;
            this.posY += offY;
            currentSteps--;
        }else{
            if(pause<=0){
                currentSteps=steps;
                pause=steps;
                checkDirection(dt);
            }
            pause--;
        }
    }

    @Override
    public void update(GameContainer gc, GameManager gm, float dt) {
        super.update(gc, gm, dt);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImageTile(image,(int)posX,(int)posY,tileX,tileY);
        r.drawLight(light,(int)posX+width/2,(int)posY+height/2);
    }

    private void checkDirection(float dt){
        switch ((int)(Math.random()*7+1)){
            case 1:
                offX=-dt*speed;
                tileX=1;
                break;
            case 2:
                offY=-dt*speed;
                tileX=3;
                break;
            case 3:
                offX=dt*speed;
                tileX=2;
                break;
            case 4:
                offY=dt*speed;
                tileX=0;
                break;
            case 5:
                offY=dt*speed;
                offX=dt*speed;
                break;
            case 6:
                offY=dt*speed;
                offX=-dt*speed;
                break;
            case 7:
                offY=-dt*speed;
                offX=-dt*speed;
                break;
            case 8:
                offY=-dt*speed;
                offX=dt*speed;
        }
    }
}
