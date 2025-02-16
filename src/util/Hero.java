package util;

import javax.swing.*;
import java.awt.*;

// Класс игрока

public class Hero {
    private int speedX, speedY = Const.P_SPEED; // speedX - Горизонтальная скорость, speedY - вертикальная
    private Rectangle floorCollision = new Rectangle(Const.P_X, Const.P_Y + Const.P_HEIGHT - 10, Const.P_WIDTH, 15); // Маска коллизии
    private Rectangle rightCollision = new Rectangle(Const.P_X, Const.P_Y + 10, 15, 10);
    private Rectangle leftCollision = new Rectangle(Const.P_X + Const.P_WIDTH - 10, Const.P_Y + 10, 15, 10);

    private Rectangle pl = new Rectangle(Const.P_X, Const.P_Y, Const.P_WIDTH, Const.P_HEIGHT); // Ректангл игрока
    private Image player = new ImageIcon("assets/images/player_sprite/player.png").getImage(); // Спрайт игрока
    private boolean onFloor; // Проверка на наличия пола под игроком

    public void update(){
        Const.P_X += speedX;
        Const.P_Y += speedY;
        floorCollision.setBounds(Const.P_X, Const.P_Y + Const.P_HEIGHT - 10, Const.P_WIDTH, 15);
        rightCollision.setBounds(Const.P_X, Const.P_Y + 10, 15, 270);
        leftCollision.setBounds(Const.P_X + Const.P_WIDTH - 15, Const.P_Y + 10, 15, 270);
        collisionFloor();
        collisionRightLeft();
    }
    public void moveRight(){ // Движение вправо
        speedX = Const.P_SPEED;
    }
    public void moveLeft(){ // Движение влево
        speedX = Const.P_SPEED * -1;
    }
    public void jump(){ // Прыжок
        if (this.onFloor){ // Эт чтобы летать нельзя было
            Const.P_Y -= Const.P_JUMPFORCE;
        }
    }
    private void collisionFloor(){ // Коллизия с объектами класса Block
        for (int i = 0; i < Static.blocks.size(); i++){
            if (floorCollision.intersects(Static.blocks.get(i))){
                Const.P_Y = Static.blocks.get(i).y - Const.P_HEIGHT;
                this.onFloor = true;
                return;
            } else {
                this.onFloor = false;
            }
        }
    }
    private void collisionRightLeft(){ // Коллизия по бокам
        for (int i = 0; i < Static.blocks.size(); i++){
            if (rightCollision.intersects(Static.blocks.get(i))){
                Const.P_X -= Static.blocks.get(i).x - Const.B_WIDTH;
            }
            if (leftCollision.intersects(Static.blocks.get(i))){
                Const.P_X -= Static.blocks.get(i).x - Const.B_WIDTH;
            }
        }
    }
    public void stop(){
        speedX = 0;
    } // Остановка персонажа

    // Всякие методы для получения значений >>>

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public Rectangle getPl() {
        return pl;
    }

    public Rectangle getFloorCollision() {
        return floorCollision;
    }

    public Image getPlayer() {
        return player;
    }

    public Rectangle getRightCollision() {
        return rightCollision;
    }

    public Rectangle getLeftCollision() {
        return leftCollision;
    }
}
