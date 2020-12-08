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
    public boolean isIn(float posX, float posY, GameContainer gc){
        boolean flag= true;
        flag&=posY>=0;
        flag&=posX>=0;
        flag&= posX<gc.getWidht();
        flag&= posY<gc.getHeight();
        return flag;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
