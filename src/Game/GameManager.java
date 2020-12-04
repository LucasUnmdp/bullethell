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
    private Image shadowtest;
    private SoundClip clip;
    private Light light;

    public GameManager(){
        image = new Image("/test.png");
        image.setAlpha(false);
        light = new Light(200,0xffffffff);
        background= new Image("/background.png");
        clip = new SoundClip("/audio/ungingan.wav");
        shadowtest = new Image("/shadowtest.png");
        shadowtest.setLightBlock(Light.FULL);
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
        r.drawImage(background,0,0);
        r.drawImage(image,gc.getInput().getMouseX()-image.getW()/2,gc.getInput().getMouseY()-image.getH()/2);
        r.drawImage(shadowtest,gc.getWidht()/2-shadowtest.getW()/2,gc.getHeight()/2-shadowtest.getH()/2);
        r.drawLight(light,gc.getInput().getMouseX(),gc.getInput().getMouseY());
    }

    public static void main(String args[]){
        GameContainer gc= new GameContainer(new GameManager());
        gc.start();
    }
}
