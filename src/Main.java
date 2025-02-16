import things.Block;
import util.Const;
import util.KeysMove;
import util.Static;
import window.Screen;
import window.ScreenPanel;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();
        ScreenPanel panel = new ScreenPanel();
        KeysMove keysMove = new KeysMove();
        Thread thread = new Thread(panel);
        thread.start();

        // Внесены изменения

        Static.blocks.add(new Block(0, 345, Const.B_WIDTH, Const.B_HEIGHT));
        Static.blocks.add(new Block(192, 650, Const.B_WIDTH, Const.B_HEIGHT));
        Static.blocks.add(new Block(413, 820, Const.B_WIDTH, Const.B_HEIGHT));
        Static.blocks.add(new Block(639, 651, Const.B_WIDTH, Const.B_HEIGHT)); // 219
        Static.blocks.add(new Block(855, 820, Const.B_WIDTH, Const.B_HEIGHT));
        Static.blocks.add(new Block(1060, 651, Const.B_WIDTH, Const.B_HEIGHT));
        Static.blocks.add(new Block(1264, 544, Const.B_WIDTH, Const.B_HEIGHT));
        Static.blocks.add(new Block(1505, 398, Const.B_WIDTH, Const.B_HEIGHT));
        Static.blocks.add(new Block(1728, 295, Const.B_WIDTH, Const.B_HEIGHT));
        Static.blocks.add(new Block(0, 1080, Const.F_WIDTH, Const.F_HEIGHT));

        screen.addKeyListener(keysMove);
        screen.add(panel);
        screen.setVisible(true);
    }
}