package things;

import javax.swing.*;
import java.awt.*;

public class EndLabel {
    private Image image = new ImageIcon("assets/images/objects/auto.png").getImage();
    private boolean shown = false;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isShown() {
        return shown;
    }

    public void setShown(boolean shown) {
        this.shown = shown;
    }
}
