import java.awt.*;
import java.sql.SQLOutput;

public class Hero {
    private int speedX, speedY;
    private Rectangle collision = new Rectangle();
    private Rectangle pl = new Rectangle(Const.X, Const.Y, Const.WIDTH, Const.HEIGHT);

    public void update(){
        Const.X += speedX;
        System.out.println("asdsad");
    }
    public void moveRight(){
        speedX = Const.SPEED;
    }
    public void moveLeft(){
        speedX = Const.SPEED * -1;
    }
    public void stop(){
        speedX = 0;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public Rectangle getPl() {
        return pl;
    }
}
