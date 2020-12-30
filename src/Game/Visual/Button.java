package Game.Visual;

import Engine.GameContainer;
import Engine.Input;
import Engine.Renderer;
import Engine.gfx.ImageTile;
import Game.GameManager;

import java.awt.event.MouseEvent;

public class Button {
    private ImageTile image;
    private int width,height,offX,offY,tileX;

    public Button(int offX,int offY,ImageTile image){
        this.offX=offX;
        this.offY=offY;
        this.width=image.getTileW();
        this.height=image.getTileH();
        this.image=image;
    }

    public void update(GameContainer gc, float dt){
        Input input = gc.getInput();
        if(input.getMouseX()>=offX && input.getMouseX()<=offX+width && input.getMouseY()>=offY && input.getMouseY()<=offY+height){
            tileX=1;
            if(input.isButtonDown(MouseEvent.BUTTON1))
                gc.setGame(new GameManager());
        }else{
            tileX=0;
        }
    }
    public void render(GameContainer gc, Renderer r){
        r.drawImageTile(image,offX,offY,tileX,0);
    }
}
