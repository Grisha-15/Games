package things;

import util.Static;

import javax.swing.*;
import java.awt.*;

public class Star {
    private final Image sprite = new ImageIcon("assets/images/objects/star.png").getImage();
    private int x, y, width = 96, height = 100;
    private Rectangle collider = new Rectangle(this.x, this.y, 96, 100);

    public Star(int x, int y) {
        this.x = x;
        this.y = y;
        collider.setBounds(this.x, this.y, 96, 100);
    }

    public void onTouch(){
        Static.endLabel.setShown(true);
    }

    public Image getSprite() {
        return sprite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getCollider() {
        return collider;
    }
}
