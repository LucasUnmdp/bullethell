package Game.Enemies;

import Engine.GameContainer;
import Game.GameObject;

import java.util.ArrayList;

public class Spawner {

    private ArrayList<GameObject> enemies;
    private GameContainer gc;
    private final int couldown=10;
    private int time=0;

    public Spawner(ArrayList<GameObject> enemies, GameContainer gc){
        this.enemies=enemies;
        this.gc=gc;
    }

    public void spawn(){
        if(time==0) {
            time=couldown;
            float x, y;

            if (Math.random() >= 0.5)
                x = (float) (Math.random() * (gc.getWidht() - gc.getWidht() * 3 / 4) + gc.getWidht() * 3 / 4);
            else
                x = (float) (Math.random() * (gc.getWidht() * 1 / 4));

            if (Math.random() >= 0.5)
                y = (float) (Math.random() * (gc.getHeight() - gc.getHeight() * 3 / 4) + gc.getHeight() * 3 / 4);
            else
                y = (float) (Math.random() * (gc.getHeight() * 1 / 4));

            enemies.add(new NormalEnemy(x, y));
        }
        time--;
    }
}
