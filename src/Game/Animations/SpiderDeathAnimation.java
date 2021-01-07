package Game.Animations;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.ImageTile;
import Game.GameManager;

public class SpiderDeathAnimation extends Animation{

    public SpiderDeathAnimation(float posX,float posY) {
        this.image = new ImageTile("/animations/spider-death.png", 16, 16);
        this.posX = posX;
        this.posY = posY;
    }
}
