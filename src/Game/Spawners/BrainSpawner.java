package Game.Spawners;

import Engine.GameContainer;
import Game.Enemies.BrainEnemy;
import Game.GameObject;

import java.util.ArrayList;

public class BrainSpawner extends Spawner{
    public BrainSpawner(ArrayList<GameObject> enemies, GameContainer gc) {
        super(enemies, gc);
        this.cooldown=1000;
        this.time=400;
    }

    @Override
    public void spawn() {
        if(time==0){
            time=cooldown;
            enemies.add(new BrainEnemy((float)(Math.random()*gc.getWidht())));
        }
        time--;
    }
}
