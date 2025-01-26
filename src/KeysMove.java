
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class KeysMove implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_ESCAPE -> System.exit(0);
            case KeyEvent.VK_D -> Static.player.moveRight();
            case KeyEvent.VK_A -> Static.player.moveLeft();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_D -> Static.player.stop();
            case KeyEvent.VK_A -> Static.player.stop();
        }
    }
}
