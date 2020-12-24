package Game.Bullets;

import Engine.GameContainer;
import Engine.Renderer;
import Game.Enemies.Enemy;
import Game.GameManager;
import Game.GameObject;

import java.util.ArrayList;

public abstract class Bullet extends GameObject {

    protected float speed=200;
    protected int direction;

    public Bullet(int direction, float posX, float posY){
        this.direction=direction;
        this.posX=posX;
        this.posY=posY;
        this.width=10;
        this.height=10;
        tag="player-bullet";
    }

    @Override
    public void update(GameContainer gc, GameManager gm, float dt) {
        move(dt);
        collision(gm);
        bulletlife(gc);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.fillRect((int)posX,(int)posY,width,height,0xff0000ff);
    }
    abstract void move(float dt);
    abstract void collision(GameManager gm);


    protected void bulletlife(GameContainer gc){
        if(!isIn(0,0,gc))
            this.dead=true;
    }
}
