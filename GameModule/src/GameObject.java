import java.awt.*;

public abstract class GameObject {
    // this class will contain all the game's objects
    protected int x, y; // protected will limit these variables only to the classes that inherit the GameObject class
    protected ID id;
    protected int speedX, speedY;
    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
}
