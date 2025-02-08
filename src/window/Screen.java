package window;

import util.Const;

import javax.swing.*;

public class Screen extends JFrame {
    public Screen(){
        setSize(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
        setLocation(100, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
