package util;

import things.Block;
import things.EndLabel;
import things.Star;

import java.util.ArrayList;
import java.util.List;

public class Static {
    public static Hero player = new Hero();
    public static final Level level = new Level();
    public static final Block floor = new Block(0, 1080, Const.F_WIDTH, Const.F_HEIGHT);
    public static List<Block> blocks = new ArrayList<Block>();
    public static List<Star> stars = new ArrayList<Star>();
    public static final EndLabel endLabel = new EndLabel();
}
