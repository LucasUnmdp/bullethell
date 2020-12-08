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
    public final static int TS=16;
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public GameManager(){
    }

    @Override
    public void init(GameContainer gc) {
        gc.getRenderer().setAmbientColor(-1);
        objects.add(new Player(gc.getWidht()/2,gc.getHeight()/2));
    }

    @Override
    public void update(GameContainer gc, float dt) {
        for(int i=0; i<objects.size();i++){
            objects.get(i).update(gc,this,dt);
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

    public void addObject(GameObject obj){
        objects.add(obj);
    }

    public void removeObject(GameObject obj){
        objects.remove(obj);
    }

    public static void main(String args[]){
        GameContainer gc= new GameContainer(new GameManager());
        gc.setWidht(480);
        gc.setHeight(360);
        gc.setScale(2f);
        gc.start();
    }
}
