package Game.Bullets;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.Image;
import Engine.gfx.Light;
import Engine.sfx.SoundClip;
import Game.Animations.BulletSplashAnimation;
import Game.Enemies.Enemy;
import Game.GameManager;
import Game.GameObject;

import java.util.ArrayList;

public class PlayerBullet extends Bullet{

    private Image image;
    private Light light;
    private SoundClip soundClip=new SoundClip("/audio/player-shoot.wav");

    public PlayerBullet(int direction, float posX, float posY) {
        super(posX, posY);
        this.direction=direction;
        this.width=10;
        this.height=10;
        tag="player-bullet";
        this.image= new Image("/bullets/default.png");
        this.light= new Light(15,0xeec938);
        soundClip.setVolume(-40);
        soundClip.play();
    }

    @Override
    void move(GameContainer gc,float dt) {
        float offX=0,offY=0;
        switch (direction){
            case 1:
                offX=-dt*speed;
                break;
            case 2:
                offY=-dt*speed;
                break;
            case 3:
                offX=dt*speed;
                break;
            case 4:
                offY=dt*speed;
                break;
            case 5:
                offY=dt*speed;
                offX=dt*speed;
                break;
            case 6:
                offY=dt*speed;
                offX=-dt*speed;
                break;
            case 7:
                offY=-dt*speed;
                offX=-dt*speed;
                break;
            case 8:
                offY=-dt*speed;
                offX=dt*speed;
        }
        this.posX+=offX;
        this.posY+=offY;
    }

    @Override
    void collision(GameManager gm) {
        ArrayList<GameObject> list=gm.getEnemies();
        for(GameObject e : list){
            if(this.checkCollision(e)) {
                ((Enemy) e).damage(1);
                this.dead=true;
                gm.addObject(new BulletSplashAnimation(posX,posY));
            }
        }
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImage(image,(int)posX,(int)posY);
        r.drawLight(light,(int)posX+width/2,(int)posY+height/2);
    }
}
