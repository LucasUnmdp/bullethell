package Game.Spawners;

import Engine.GameContainer;
import Game.Enemies.SpiderEnemy;
import Game.GameObject;

import java.util.ArrayList;

public class SpiderSpawner extends Spawner {

    public SpiderSpawner(ArrayList<GameObject> enemies, GameContainer gc) {
        super(enemies, gc);
        this.cooldown =60;
    }

    @Override
    public void spawn() {
        if(time==0) {
            time= cooldown;
            enemies.add(new SpiderEnemy((float)(Math.random()*(gc.getHeight()-100)+50),gc.getWidht() ));
        }
        time--;
    }
}
