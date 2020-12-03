package Engine;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameContainer implements Runnable{

    private Thread thread;
    private boolean running=false;
    private Window window;
    private Renderer renderer;
    private AbstractGame game;
    private Input input;
    private final double UPDATE_CAPE = 1.0/60.0;
    private int widht =320, height=240;
    private float scale =3f;
    private String title = "GameEngine";

    public GameContainer(AbstractGame game){
        this.game=game;
    }

    public void start(){
        window= new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);

        thread = new Thread(this);
        thread.run();
    }

    public void stop(){

    }

    public void run(){
        running=true;

        boolean render=false;
        double firstTime=0;
        double lastTime=System.nanoTime()/1000000000.0;
        double passedTime=0;
        double unprocessedTime=0;

        double frameTime=0;
        int frames=0;
        int fps=0;

        while(running){
            render=false;
            firstTime= System.nanoTime()/1000000000.0;
            passedTime= firstTime- lastTime;
            lastTime= firstTime;
            unprocessedTime+=passedTime;
            frameTime+=passedTime;
            while(unprocessedTime >= UPDATE_CAPE){
                unprocessedTime-=UPDATE_CAPE;
                render=true;

                game.update(this,(float)UPDATE_CAPE);

                input.update();

                if(frameTime>=1.0){
                    frameTime=0;
                    fps=frames;
                    frames=0;
                }
            }
            if(render){
                renderer.clear();
                game.render(this,renderer);
                renderer.drawText("FPS:"+fps,widht-24,0,0xffffff00);
                window.update();
                frames++;
            }else{
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        dispose();
    }

    private void dispose(){

    }

    public int getWidht() {
        return widht;
    }

    public int getHeight() {
        return height;
    }

    public float getScale() {
        return scale;
    }

    public String getTitle() {
        return title;
    }

    public void setWidht(int widht) {
        this.widht = widht;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Window getWindow() {
        return window;
    }

    public Input getInput() {
        return input;
    }
}
