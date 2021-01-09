package Game.Animations;

import Engine.gfx.ImageTile;

public class SpiderDeathAnimation extends Animation{

    public SpiderDeathAnimation(float posX,float posY) {
        this.image = new ImageTile("/animations/spider-death.png", 20, 20);
        this.posX = posX;
        this.posY = posY;
    }
}
