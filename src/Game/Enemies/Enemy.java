package Game.Enemies;

import Engine.GameContainer;
import Engine.Renderer;
import Game.GameManager;
import Game.GameObject;

import java.util.Random;

public class Enemy extends GameObject {

    private int speed =100;
    private int steps = 0;
    private int directionX = 0;
    private int directionY = 0;

    public Enemy (){
        this.tag="enemy";
        this.posX=150;
        this.posY=200;
        this.width=16;
        this.height=16;

    }

    @Override
    public void update(GameContainer gc, GameManager gm, float dt) {
        Random r= new Random();
        if(steps==0) {
            directionX = r.nextBoolean() ? -1 : 1;
            directionX -= r.nextBoolean() ? -1 : 1;
            directionY = r.nextBoolean() ? -1 : 1;
            directionY += r.nextBoolean() ? -1 : 1;
            steps=8;
        }
        steps--;
        this.posY += speed * dt * directionY;
        this.posX += speed * dt * directionX;

        //Enemy life start
        if(!isIn(0,0,gc))
            this.dead=true;
        //Enemy life finish
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.fillRect((int)posX,(int)posY,width,height,0xffff0000);
    }
}
