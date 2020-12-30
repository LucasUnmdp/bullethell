package Game.Visual;

import Engine.AbstractGame;
import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.ImageTile;
import Game.GameManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuManager extends AbstractGame {
    private Button startButton;
    @Override
    public void init(GameContainer gc) {
        gc.getHUD().setAmbientColor(-1);
        gc.getRenderer().setAmbientColor(-1);
        startButton=new Button(190,155,new ImageTile("/menu/start.png",100,50));
    }

    @Override
    public void update(GameContainer gc, float dt) {
        startButton.update(gc,dt);
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        startButton.render(gc,r);
    }

    @Override
    public void renderHUD(GameContainer gc, Renderer hUD) {
    }
}
