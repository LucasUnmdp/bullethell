package Game.Animations;

import Engine.GameContainer;
import Engine.Renderer;
import Engine.gfx.ImageTile;
import Game.GameManager;
import Game.GameObject;

public abstract class Animation extends GameObject {
    protected ImageTile image;
    protected int cd=0;
    protected int tileX=0;
    protected int mod=5;
    protected int cantTiles=4;

    @Override
    public void update(GameContainer gc, GameManager gm, float dt) {
        cd++;
        if(cd%mod==0)
            tileX++;
        if(cd==mod*cantTiles-1)
            this.dead=true;
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.drawImageTile(image,(int)posX,(int)posY,tileX,0);
    }
}
