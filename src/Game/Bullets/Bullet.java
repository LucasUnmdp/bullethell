package Game.Bullets;

import Engine.GameContainer;
import Engine.Renderer;
import Game.GameManager;
import Game.GameObject;

public abstract class Bullet extends GameObject {

    protected float speed=200;
    protected int direction;

    public Bullet(float posX, float posY){
        this.direction=direction;
        this.posX=posX;
        this.posY=posY;
    }

    @Override
    public void update(GameContainer gc, GameManager gm, float dt) {
        move(dt);
        collision(gm);
        bulletLife(gc);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.fillRect((int)posX,(int)posY,width,height,0xff0000ff);
    }
    abstract void move(float dt);
    abstract void collision(GameManager gm);


    protected void bulletLife(GameContainer gc){
        if(!isIn(0,0,gc))
            this.dead=true;
    }
}
