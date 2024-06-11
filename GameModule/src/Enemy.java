import java.awt.*;

public class Enemy extends GameObject{
    public Enemy(int x, int y, ID id) {
        super(x, y, id);

        speedX = 5;
        speedY = 5;
    }

    public void tick() {
        x += speedX;
        y += speedY;

        if (y <= 0 || y >= Game.HEIGHT - 60) speedY *= -1;
        if (x<= 0 || x >= Game.WIDTH - 40) speedX *= -1;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y,16,16);
    }
}
