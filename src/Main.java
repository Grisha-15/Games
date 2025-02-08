import util.KeysMove;
import window.Screen;
import window.ScreenPanel;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();
        ScreenPanel panel = new ScreenPanel();
        KeysMove keysMove = new KeysMove();
        Thread thread = new Thread(panel);
        thread.start();



        screen.addKeyListener(keysMove);
        screen.add(panel);
        screen.setVisible(true);
    }
}