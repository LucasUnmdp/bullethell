package Game.Animations;

import Engine.gfx.ImageTile;

public class BrainDeathAnimation extends Animation{
    public BrainDeathAnimation(float posX,float posY) {
        this.image = new ImageTile("/animations/brain-death.png", 49, 30);
        this.posX = posX;
        this.posY = posY;
    }
}
