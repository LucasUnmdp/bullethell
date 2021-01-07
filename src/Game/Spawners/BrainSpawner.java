package Game.Spawners;

import Engine.GameContainer;
import Engine.sfx.SoundClip;
import Game.Enemies.BrainEnemy;
import Game.GameObject;

import java.util.ArrayList;

public class BrainSpawner extends Spawner{

    private SoundClip soundClip;

    public BrainSpawner(ArrayList<GameObject> enemies, GameContainer gc) {
        super(enemies, gc);
        this.cooldown=1000;
        this.time=400;
        this.soundClip= new SoundClip("/audio/brain-enemy-spawn.wav");
        soundClip.setVolume(-20);
    }

    @Override
    public void spawn() {
        if(time==0){
            time=cooldown;
            enemies.add(new BrainEnemy((float)(Math.random()*(gc.getWidht()-49))));
            soundClip.play();
        }
        time--;
    }
}
