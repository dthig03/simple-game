import java.awt.*;

public class Enemy extends GameObject{
    public Enemy(int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {
        x +=speedX;
        y += speedY;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y,16,16);
    }
}
