package Game.Animations;

import Engine.gfx.ImageTile;

public class BulletEnemySplashAnimation extends Animation{

    public BulletEnemySplashAnimation(float posX,float posY){
        this.image= new ImageTile("/animations/enemy-bullet.png",16,16);
        this.posX=posX;
        this.posY=posY;
    }
}
