package Game;

import Engine.AbstractGame;
import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.Image;
import Engine.gfx.ImageTile;
import Engine.sfx.SoundClip;


public class GameManager extends AbstractGame {

    private Image image;
    private ImageTile tile;
    private SoundClip clip;

    public GameManager(){
        image = new Image("/test.png");
        tile = new ImageTile("/tiletest.png",16,16);
    }
    @Override
    public void update(GameContainer gc, float dt) {
        temp+=dt*10;
        if(temp>3){
            temp=-4;
        }
    }

    float temp=0;

    @Override
    public void render(GameContainer gc, Renderer r) {
        Image image2 = new Image("/blendingtest.png");
        image2.setAlpha(true);
        r.drawImage(image2,gc.getWidht()-image2.getW(),gc.getHeight()-image2.getH());
        r.drawImage(image,gc.getInput().getMouseX()-image.getW()/2,gc.getInput().getMouseY()-image.getH()/2);
        r.fillRect(100,100,32,32,0xffffccff);
        r.drawImageTile(tile,0,0,(int)Math.abs(temp),0);
    }

    public static void main(String args[]){
        GameContainer gc= new GameContainer(new GameManager());
        gc.start();
    }
}
