import java.awt.*;

public class Player extends GameObject{

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += speedX;
        y += speedY;

        x = Game.clamp(x, 0, Game.WIDTH - 48);
        y = Game.clamp(y, 0, Game.HEIGHT - 70);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,y,32,32);
    }

}
