package window;

import util.Const;
import util.Static;

import javax.swing.*;
import java.awt.*;

public class ScreenPanel extends JPanel implements Runnable {
    private void update(){
        Static.player.update();
    }

    public ScreenPanel() {
    }

    @Override
    public void paint(Graphics g) { // Отрисовка объектов
        super.paint(g);
        g.drawImage(Static.level.getBackGround(), Const.BG_X, Const.BG_Y, null);
        g.drawImage(Static.player.getPlayer(), Const.P_X, Const.P_Y, null);
        g.setColor(new Color(0xFFFFFF));
        g.drawRect(Const.P_X, Const.P_Y, Const.P_WIDTH, Const.P_HEIGHT); // Отрисовка персонажа
        g.drawRect(Static.player.getFloorCollision().x, Static.player.getFloorCollision().y, Static.player.getFloorCollision().width, Static.player.getFloorCollision().height);
        g.drawRect(Static.player.getRightCollision().x, Static.player.getRightCollision().y, Static.player.getRightCollision().width, Static.player.getRightCollision().height);
        g.drawRect(Static.player.getLeftCollision().x, Static.player.getLeftCollision().y, Static.player.getLeftCollision().width, Static.player.getLeftCollision().height);


        for (int i = 0; i < Static.blocks.size(); i++){ // Отрисовка платформ
            g.drawRect(Static.blocks.get(i).x, Static.blocks.get(i).y, Static.blocks.get(i).width, Static.blocks.get(i).height);
        }


    }

    @Override
    public void run() { // Поток обновления панели и запуска метода update()
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
