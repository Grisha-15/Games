package util;

import window.Static;

import java.awt.*;

// Класс игрока

public class Hero {
    private int speedX, speedY = Const.P_SPEED; // speedX - Горизонтальная скорость, speedY - вертикальная
    private Rectangle collision = new Rectangle(Const.P_X, Const.P_Y + Const.P_HEIGHT - 10, Const.P_WIDTH, 15); // Маска коллизии
    private Rectangle pl = new Rectangle(Const.P_X, Const.P_Y, Const.P_WIDTH, Const.P_HEIGHT); // "Спрайт" игрока
    private boolean onFloor;

    public void update(){
        Const.P_X += speedX;
        Const.P_Y += speedY;
        collision.setBounds(Const.P_X, Const.P_Y + Const.P_HEIGHT - 10, Const.P_WIDTH, 15);
        collision();
    }
    public void moveRight(){
        speedX = Const.P_SPEED;
    }
    public void moveLeft(){
        speedX = Const.P_SPEED * -1;
    }
    public void jump(){
        if (this.onFloor){
            Const.P_Y -= 150;
        }

    }
    private void collision(){
        if (collision.intersects(Static.floor)){
            Const.P_Y = Static.floor.y - Const.P_HEIGHT;
            this.onFloor = true;
        } else {
            this.onFloor = false;
        }
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

    public Rectangle getCollision() {
        return collision;
    }
}
