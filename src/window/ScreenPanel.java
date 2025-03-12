package window;

import util.Const;
import util.Static;

import javax.swing.*;
import java.awt.*;

public class ScreenPanel extends JPanel implements Runnable {
    private void update() {
        Static.player.update();
    }

    public ScreenPanel() {
    }

    @Override
    public void paint(Graphics g) { // Отрисовка объектов
        super.paint(g);
        g.drawImage(Static.level.getBackGround(), Const.BG_X, Const.BG_Y, null);
        g.drawImage(Static.player.getPlayer(), Const.P_X, Const.P_Y, null);
        g.setColor(new Color(0x0FFFFFF, true));
        //g.setColor(new Color(0xFFFFFF));
        //  g.drawRect(Const.P_X, Const.P_Y, Const.P_WIDTH, Const.P_HEIGHT); // Отрисовка персонажа
        //g.setColor(Color.RED);
        g.drawRect(Static.player.getPl().x, Static.player.getPl().y, Static.player.getPl().width, Static.player.getPl().height);

        g.drawRect(Static.player.getFloorCollision().x, Static.player.getFloorCollision().y, Static.player.getFloorCollision().width, Static.player.getFloorCollision().height);
        //g.drawRect(Static.player.getRightCollision().x, Static.player.getRightCollision().y, Static.player.getRightCollision().width, Static.player.getRightCollision().height);
        //g.drawRect(Static.player.getLeftCollision().x, Static.player.getLeftCollision().y, Static.player.getLeftCollision().width, Static.player.getLeftCollision().height);

        for (int i = 0; i < Static.stars.size(); i++) {
            g.drawImage(Static.stars.get(i).getSprite(), Static.stars.get(i).getX(), Static.stars.get(i).getY(), Static.stars.get(i).getWidth(), Static.stars.get(i).getWidth(), null);
            g.drawRect(Static.stars.get(i).getCollider().x, Static.stars.get(i).getCollider().y, Static.stars.get(i).getCollider().width, Static.stars.get(i).getCollider().height);
        }
        for (int i = 0; i < Static.blocks.size(); i++) { // Отрисовка платформ
            g.drawRect(Static.blocks.get(i).x, Static.blocks.get(i).y, Static.blocks.get(i).width, Static.blocks.get(i).height);
        }
        if (Static.endLabel.isShown()){
            g.drawImage(Static.endLabel.getImage(), 0, 100, null);
        }

    }

    @Override
    public void run() { // Поток обновления панели и запуска метода update()
        while (true) {
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
