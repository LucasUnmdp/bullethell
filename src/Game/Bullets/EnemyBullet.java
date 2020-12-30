package Game.Bullets;

import Game.GameManager;
import Game.Player;

public class EnemyBullet extends Bullet{
    public EnemyBullet(int direction, float posX, float posY) {
        super(direction, posX, posY);
    }

    @Override
    void move(float dt) {

    }

    @Override
    void collision(GameManager gm) {
        Player p = (Player)gm.getPlayer();
        if(this.checkCollision(p)){
            p.damage();
            this.dead=true;
        }
    }
}
