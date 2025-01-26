
import javax.swing.*;
import java.awt.*;

public class ScreenPanel extends JPanel implements Runnable {
    private void update(){
        Static.player.update();
    }

    public ScreenPanel() {
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(Const.X, Const.Y, Const.WIDTH, Const.HEIGHT);
    }

    @Override
    public void run() {
        while (true){
            try {
                update();
                repaint();
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("sadasda");

        }
    }
}
