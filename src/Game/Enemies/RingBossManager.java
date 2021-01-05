package Game.Enemies;

import Engine.GameContainer;
import Engine.Renderer;
import Game.GameManager;
import Game.GameObject;

import java.util.ArrayList;

public class RingBossManager extends GameObject {

    private int hp=10,atackCD=180,cd=180;
    private ArrayList<Enemy> bodyParts= new ArrayList<>();

    public RingBossManager(GameContainer gc,ArrayList<GameObject> e){
        bodyParts.add(new RingBossH(0,this));
        bodyParts.add(new RingBossH(gc.getHeight()-40,this));
        bodyParts.add(new RingBossV(0,this));
        bodyParts.add(new RingBossV(gc.getWidht()-40,this));
        for (Enemy enemy:bodyParts) {
            e.add(enemy);
        }
    }
    @Override
    public void update(GameContainer gc, GameManager gm, float dt) {
        //bosslife start
        if(this.hp<=0){
            for (Enemy e:bodyParts) {
                e.setDead(true);
            }
        }
        //bosslife end
    }

    @Override
    public void render(GameContainer gc, Renderer r) {

    }

    public void damage(int x){
        this.hp-=x;
    }
}
