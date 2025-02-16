package window;

import things.Blocks;
import util.Const;
import util.Hero;

public class Static {
    public static Hero player = new Hero();
    public static Blocks floor = new Blocks(100, 450, Const.B_WIDTH, Const.B_HEIGHT);
}
