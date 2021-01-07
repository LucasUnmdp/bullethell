package Game.Bullets;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.Image;
import Engine.gfx.Light;
import Engine.sfx.SoundClip;
import Game.Animations.BulletEnemySplashAnimation;
import Game.Animations.BulletSplashAnimation;
import Game.GameManager;
import Game.Player;

public class EnemyBullet extends Bullet{

    protected float value;
    protected int sign;
    private Image image;
    private Light ligth;
    private SoundClip soundClip=new SoundClip("/audio/enemy-shoot.wav");

    public EnemyBullet(float posX, float posY,float posfX, float posfY) {
        super(posX, posY);
        this.image= new Image("/bullets/enemy.png");
        this.ligth= new Light(20,0xff0000);
        this.tag="enemy-bullet";
        this.value=(posfX-posX)/(posfY-posY);
        if(posfY-posY>0)
            sign=1;
        else
            sign=-1;
        this.width=10;
        this.height=10;
        if(Math.abs(value)>1)
            this.speed=this.speed/Math.abs(value);
        soundClip.setVolume(-40);
        this.soundClip.play();
    }

    @Override
    void move(GameContainer gc,float dt) {
        posX+=dt*speed*value*sign;
        posY+=dt*speed*sign;
    }

    @Override
    void collision(GameManager gm) {
        Player p = (Player)gm.getPlayer();
        if(this.checkCollision(p)){
            p.damage();
            this.dead=true;
            gm.addObject(new BulletEnemySplashAnimation(posX,posY));
        }
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImage(image,(int)posX,(int)posY);
        r.drawLight(ligth,(int)(posX+width/2),(int)(posY+height/2));
    }
}
