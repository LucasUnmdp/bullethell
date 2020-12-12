package Game;

import Engine.GameContainer;
import Engine.Renderer;

public abstract class GameObject {

    protected String tag;
    protected float posX,posY;
    protected int width,height;
    protected boolean dead=false;

    public abstract void update(GameContainer gc, GameManager gm,float dt);
    public abstract void render(GameContainer gc, Renderer r);

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isDead() {
        return dead;
    }
    public boolean isIn(float offx, float offy,GameContainer gc){
        if(posY+offy<0 || posY+height+offy>gc.getHeight())
            return false;
        if(posX+offx<0 || posX+width+offx>gc.getWidht())
            return false;
        return true;
    }

    public boolean checkCollision(GameObject r){
        int tw = this.width;
        int th = this.height;
        int rw = r.width;
        int rh = r.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx =(int) this.posX;
        int ty =(int) this.posY;
        int rx =(int) r.posX;
        int ry =(int) r.posY;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
