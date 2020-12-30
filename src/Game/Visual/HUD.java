package Game.Visual;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.Image;
import Game.GameManager;
import Game.GameObject;
import Game.Player;

public class HUD {

    private Player player;
    Image hp;

    public HUD(GameObject player){
        this.player=(Player)player;
        this.hp= new Image("/hud/hp.png");
    }

    public void update(GameContainer gc, GameManager gm, float dt){
    }
    public void render(GameContainer gc, Renderer r){
        for (int i = 0; i < player.getHP(); i++) {
            r.drawImage(hp,5+i*12,gc.getHeight()-15);
        }
    }


}
