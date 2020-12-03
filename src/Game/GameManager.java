package Game;

import Engine.AbstractGame;
import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.Image;


public class GameManager extends AbstractGame {

    private Image image;

    public GameManager(){
        image = new Image("/test.png");
    }
    @Override
    public void update(GameContainer gc, float dt) {

    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImage(image,gc.getInput().getMouseX()-image.getW()/2,gc.getInput().getMouseY()-image.getH()/2);
    }

    public static void main(String args[]){
        GameContainer gc= new GameContainer(new GameManager());
        gc.start();
    }
}
