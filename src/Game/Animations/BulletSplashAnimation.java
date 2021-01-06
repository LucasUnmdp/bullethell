package Game.Animations;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.ImageTile;
import Game.GameManager;

public class BulletSplashAnimation extends Animation{

    private int cd=0;
    private int tileX=0;

    public BulletSplashAnimation(float posX,float posY){
        this.image= new ImageTile("/animations/player-bullet.png",16,16);
        this.posX=posX;
        this.posY=posY;
    }
    @Override
    public void update(GameContainer gc, GameManager gm, float dt) {
        cd++;
        if(cd%5==0)
            tileX++;
        if(cd==19)
            this.dead=true;
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImageTile(image,(int)posX,(int)posY,tileX,0);
    }
}
