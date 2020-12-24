package Game.Enemies;

public class normalEnemy extends Enemy{

    public normalEnemy(float posX, float posY){
        super();
        this.posX=posX;
        this.posY=posY;
        this.width=16;
        this.height=16;
        this.speed=100;
    }
    @Override
    void move(float dt) {
        posY+=speed*dt;
        this.speed+=10;
    }
}
