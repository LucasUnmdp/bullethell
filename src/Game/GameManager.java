package Game;

import Engine.AbstractGame;
import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.Image;
import Engine.gfx.ImageTile;
import Engine.gfx.Light;
import Engine.sfx.SoundClip;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class GameManager extends AbstractGame {

    private ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public GameManager(){
        objects.add(new Player(1,1));
    }

    @Override
    public void init(GameContainer gc) {
        gc.getRenderer().setAmbientColor(-1);
    }

    @Override
    public void update(GameContainer gc, float dt) {
        for(int i=0; i<objects.size();i++){
            objects.get(i).update(gc,dt);
            if(objects.get(i).isDead()){
                objects.remove(i--);
            }
        }
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        for(GameObject obj: objects){
            obj.render(gc,r);
        }
    }

    public static void main(String args[]){
        GameContainer gc= new GameContainer(new GameManager());
        gc.setWidht(320);
        gc.setHeight(240);
        gc.setScale(3f);
        gc.start();
    }
}
