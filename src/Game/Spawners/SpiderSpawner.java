package Game.Spawners;

import Engine.GameContainer;
import Game.Enemies.SpiderEnemy;
import Game.GameObject;

import java.util.ArrayList;

public class SpiderSpawner extends Spawner {

    public SpiderSpawner(ArrayList<GameObject> enemies, GameContainer gc) {
        super(enemies, gc);
        this.cooldown =30;
    }

    @Override
    public void spawn() {
        if(time==0) {
            time= cooldown;
            float x, y;

            if (Math.random() >= 0.5)
                x = (float) (Math.random() * (gc.getWidht() - gc.getWidht() * 3 / 4) + gc.getWidht() * 3 / 4);
            else
                x = (float) (Math.random() * (gc.getWidht() * 1 / 4));

            if (Math.random() >= 0.5)
                y = (float) (Math.random() * (gc.getHeight() - gc.getHeight() * 3 / 4) + gc.getHeight() * 3 / 4);
            else
                y = (float) (Math.random() * (gc.getHeight() * 1 / 4));

            enemies.add(new SpiderEnemy(x, y));
        }
        time--;
    }
}
