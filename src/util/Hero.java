package util;

import javax.swing.*;
import java.awt.*;

// Класс игрока

public class Hero {
    private int speedX, speedY = Const.P_SPEED; // speedX - Горизонтальная скорость, speedY - вертикальная
    private Rectangle floorCollision = new Rectangle(Const.P_X, Const.P_Y + Const.P_HEIGHT - 10, Const.P_WIDTH, 15); // Маска коллизии

    private final Rectangle pl = new Rectangle(Const.P_X, Const.P_Y, Const.P_WIDTH, Const.P_HEIGHT); // Ректангл игрока
    private Image player = new ImageIcon("assets/images/player_sprite/player.png").getImage(); // Спрайт игрока
    private boolean onFloor; // Проверка на наличия пола под игроком

    public void setPlayer(Image player) {
        this.player = player;
    }

    public void update() {
        Const.P_X += speedX;
        Const.P_Y += speedY;
        floorCollision.setBounds(Const.P_X, Const.P_Y + Const.P_HEIGHT - 10, Const.P_WIDTH, 15);
        collisionFloor();
        touchStar();
        pl.setBounds(Const.P_X, Const.P_Y, Const.P_WIDTH, Const.P_HEIGHT);
    }

    public void moveRight() { // Движение вправо
        speedX = Const.P_SPEED;
        setPlayer(new ImageIcon("assets/images/player_sprite/player.png").getImage());
    }

    public void moveLeft() { // Движение влево
        speedX = Const.P_SPEED * -1;
        setPlayer(new ImageIcon("assets/images/player_sprite/playerR.png").getImage());

    }

    public void jump() { // Прыжок
        if (this.onFloor) { // Эт чтобы летать нельзя было
            Const.P_Y -= Const.P_JUMPFORCE;
        }
    }

    private void collisionFloor() { // Коллизия с объектами класса Block
        for (int i = 0; i < Static.blocks.size(); i++) {
            if (floorCollision.intersects(Static.blocks.get(i))) {
                Const.P_Y = Static.blocks.get(i).y - Const.P_HEIGHT;
                this.onFloor = true;
                return;
            } else {
                this.onFloor = false;
            }
        }
        for (int i = 0; i < Static.stars.size(); i++) {

            if (Static.stars.get(i).getCollider().intersects(pl)) {
                if (i == Static.stars.size() - 1) Static.stars.get(i).onTouch();
                else Static.stars.remove(Static.stars.get(i));
            }
        }

    }

    private void touchStar() {

    }

    public void stop() {
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
}
