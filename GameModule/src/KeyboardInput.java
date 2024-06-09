import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// with this class we'll be able to add keyboard control to the game
public class KeyboardInput extends KeyAdapter {
    private Handler handler;

    public KeyboardInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
    }

    public void keyReleased(KeyEvent event) {

    }
}
