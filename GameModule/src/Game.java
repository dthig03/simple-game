import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private HUD hud;
    public Game() {
        handler = new Handler();

        this.addKeyListener(new KeyboardInput(handler));

        new Window(WIDTH, HEIGHT, "A simple game", this);

        hud = new HUD();

        handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player));
        handler.addObject(new Enemy(WIDTH/2-32,HEIGHT/2-32,ID.Enemy));
    }

    public synchronized void start() {
    thread = new Thread(this);
    thread.start();
    running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // this run method will be the "game loop" and is stolen from the tutorial I'm using to make this game but it's supposedly a pretty common loop
    // this will basically be the logic the game uses to run
    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;
            // counts the amount of frames that the game is running at
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    private void tick() {
     handler.tick();
    }
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH, HEIGHT);

        handler.render(g);

        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        }
        else if (var <= min) {
            return var = min;
        } else
            return var;
    }

    public static void main(String[] args) {
        new Game();
    }
}
