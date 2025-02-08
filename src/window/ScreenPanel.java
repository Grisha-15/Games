package window;

import util.Const;

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
        g.drawRect(Const.P_X, Const.P_Y, Const.P_WIDTH, Const.P_HEIGHT);
        g.drawRect(Static.floor.x, Static.floor.y, Static.floor.width, Static.floor.height);

        g.drawRect(Static.player.getCollision().x, Static.player.getCollision().y, Static.player.getCollision().width, Static.player.getCollision().height);
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
        }
    }
}
