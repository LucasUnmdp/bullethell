package Game.Enemies;

import Engine.GameContainer;
import Engine.Renderer;
import Game.GameManager;
import Game.GameObject;

public abstract class Enemy extends GameObject {

    protected int speed;

    public Enemy (){
        this.tag="enemy";
    }
    abstract void move(float dt);
    @Override
    public void update(GameContainer gc, GameManager gm, float dt) {
        move(dt);
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
