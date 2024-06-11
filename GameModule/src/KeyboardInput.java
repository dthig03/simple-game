import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

// with this class we'll be able to add keyboard control to the game
public class KeyboardInput extends KeyAdapter {
    private Handler handler;

    public KeyboardInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.Player) {
                // these are the key events for the player
               if (key == KeyEvent.VK_W) tempObject.setSpeedY(-5);
               if (key == KeyEvent.VK_A) tempObject.setSpeedX(-5);
               if (key == KeyEvent.VK_S) tempObject.setSpeedY(5);
               if (key == KeyEvent.VK_D) tempObject.setSpeedX(5);
            }
        }
    }

    public void keyReleased(KeyEvent event) {
        int key = event.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.Player) {
                // these are the key events for the player
                if (key == KeyEvent.VK_W) tempObject.setSpeedY(0);
                if (key == KeyEvent.VK_A) tempObject.setSpeedX(0);
                if (key == KeyEvent.VK_S) tempObject.setSpeedY(0);
                if (key == KeyEvent.VK_D) tempObject.setSpeedX(0);
            }
        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(1); // this will kill the program when esc is pressed
    }
}
