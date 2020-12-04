package Game;

import Engine.AbstractGame;
import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.Image;
import Engine.gfx.ImageTile;
import Engine.gfx.Light;
import Engine.sfx.SoundClip;
import java.awt.event.MouseEvent;


public class GameManager extends AbstractGame {

    private Image image;
    private Image background;
    private SoundClip clip;
    private Light light;

    public GameManager(){
        image = new Image("/test.png");
        light = new Light(100,0xffffffff);
        background= new Image("/background.png");
        clip = new SoundClip("/audio/ungingan.wav");
        clip.setVolume(-10);
    }
    @Override
    public void update(GameContainer gc, float dt) {
        if(gc.getInput().isButtonDown(MouseEvent.BUTTON1))
            clip.play();
        temp+=dt*10;
        if(temp>3){
            temp=-4;
        }
    }

    float temp=0;

    @Override
    public void render(GameContainer gc, Renderer r) {

        r.drawLight(light,gc.getInput().getMouseX(),gc.getInput().getMouseY());
        r.drawImage(background,0,0);
        r.drawImage(image,gc.getInput().getMouseX()-image.getW()/2,gc.getInput().getMouseY()-image.getH()/2);
    }

    public static void main(String args[]){
        GameContainer gc= new GameContainer(new GameManager());
        gc.start();
    }
}
