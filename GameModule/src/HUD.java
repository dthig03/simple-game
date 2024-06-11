import java.awt.*;

public class HUD {

    public static int HEALTH = 100; // this is static since there won't be any other health bars to track in the game.

    public void tick() {

        HEALTH = Game.clamp(HEALTH, 0, 100); // stops the health bar from going behind the designated area
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15,15,200,32);
        g.setColor(Color.green);
        g.fillRect(15,15,HEALTH * 2,32);
        g.setColor(Color.white);
        g.drawRect(15,15,200,32);
    }
}
