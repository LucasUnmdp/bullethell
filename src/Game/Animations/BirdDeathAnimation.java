package Game.Animations;

import Engine.gfx.ImageTile;

public class BirdDeathAnimation extends Animation{
    public BirdDeathAnimation(float posX,float posY) {
        this.image = new ImageTile("/animations/bird-death.png", 20, 20);
        this.posX = posX;
        this.posY = posY;
    }
}
