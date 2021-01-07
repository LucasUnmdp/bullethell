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
}
