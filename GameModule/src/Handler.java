import java.awt.*;
import java.util.LinkedList;

public class Handler {
    // this class will update and render the objects of the game
    LinkedList<GameObject> objects = new LinkedList<GameObject>(); // this should track the amount of objects we have in the game
    // sets our temp object to get the id of the current object in the loop
    public void tick(){
        for (int i = 0; i < objects.size(); i++) {

           GameObject tempObject = objects.get(i);

           tempObject.tick();
        }
    }
    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }
    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }
}
