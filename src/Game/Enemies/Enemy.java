package Game.Enemies;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.ImageTile;
import Engine.gfx.Light;
import Game.GameManager;
import Game.GameObject;

public abstract class Enemy extends GameObject {

    protected int speed;
    protected int hp=1;
    protected ImageTile image;
    protected Light light;

    public Enemy (){
        this.tag="enemy";
    }
    abstract void move(GameContainer gc,float dt);
    abstract void shoot(GameContainer gc,GameManager gm);
    abstract void deathAnimation(GameManager gm);
    @Override
    public void update(GameContainer gc, GameManager gm, float dt) {
        move(gc,dt);
        shoot(gc,gm);
        enemyLife(gc,gm);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.fillRect((int)posX,(int)posY,width,height,0xffff0000);
    }

    public void damage(int x){
        this.hp-=x;
    }
    protected void enemyLife(GameContainer gc,GameManager gm){
        if(!isIn(0,0,gc))
            this.dead=true;
        if(hp<=0) {
            deathAnimation(gm);
            this.dead = true;
        }
    }
}
