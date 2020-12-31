package Game.Spawners;

import Engine.GameContainer;
import Game.GameObject;

import java.util.ArrayList;

public abstract class Spawner {

    protected ArrayList<GameObject> enemies;
    protected GameContainer gc;
    protected int cooldown;
    protected int time=0;

    public Spawner(ArrayList<GameObject> enemies, GameContainer gc){
        this.enemies=enemies;
        this.gc=gc;
    }

    public abstract void spawn();
}
