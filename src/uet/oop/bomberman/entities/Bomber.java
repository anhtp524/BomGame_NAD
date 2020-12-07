package uet.oop.bomberman.entities;

import javafx.animation.Animation;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends Entity {
    private boolean isMoveLeft, isMoveRight, isMoveUp, isMoveDown, isPlantBomb;
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }
    private KeyCode keyCode;
    public double step = 2;
    private int down = 1;
    private int up = 1;
    private int left = 1;
    private int right =1;



    public void input() {
        BombermanGame.scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == keyCode.LEFT || keyEvent.getCode() == keyCode.A ) {
                isMoveLeft = true;
            }
            if (keyEvent.getCode() == keyCode.RIGHT || keyEvent.getCode() == keyCode.D ) {
                isMoveRight = true;
            }
            if (keyEvent.getCode() == keyCode.UP || keyEvent.getCode() == keyCode.W) {
                isMoveUp = true;
            }
            if (keyEvent.getCode() == keyCode.DOWN || keyEvent.getCode() == keyCode.S ) {
                isMoveDown = true;
            }
            if (keyEvent.getCode() == keyCode.SPACE || keyEvent.getCode() == keyCode.ENTER ) {
                isPlantBomb = true;
            }
        });
        BombermanGame.scene.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == keyCode.LEFT || keyEvent.getCode() == keyCode.A) {
                isMoveLeft = false;
            }
            if (keyEvent.getCode() == keyCode.RIGHT || keyEvent.getCode() == keyCode.D) {
                isMoveRight = false;
            }
            if (keyEvent.getCode() == keyCode.UP || keyEvent.getCode() == keyCode.W) {
                isMoveUp = false;
            }
            if (keyEvent.getCode() == keyCode.DOWN || keyEvent.getCode() == keyCode.S) {
                isMoveDown = false;
            }
            if (keyEvent.getCode() == keyCode.SPACE || keyEvent.getCode() == keyCode.ENTER) {
                isPlantBomb = false;
            }
        });
    }

    public void move() {

        if(isMoveDown) {
            if(down == 1) this.img = Sprite.player_down.getFxImage();
            else if(down == 2) this.img = Sprite.player_down_1.getFxImage();
            else if(down == 3) {
                this.img = Sprite.player_down_2.getFxImage();
                down = 1;
            }
            this.y ++;
            down++;
            up = 1;
            left = 1;
            right = 1;

        }
        else if(isMoveUp) {
            if(up == 1) this.img = Sprite.player_up.getFxImage();
            else if(up == 2) this.img = Sprite.player_up_1.getFxImage();
            else if(up == 3) {
                this.img = Sprite.player_up_2.getFxImage();
                up = 1;
            }
            this.y --;
            up++;
            down = 1;
            left = 1;
            right =1;
        }
        else if(isMoveLeft) {
            if(left == 1) this.img = Sprite.player_left.getFxImage();
            else if(left == 2) this.img = Sprite.player_left_1.getFxImage();
            else if (left == 3) {
                this.img = Sprite.player_left_2.getFxImage();
                left = 1;
            }
            this.x --;
            left ++;
            right = 1;
            down = 1;
            up = 1;
        }
        else if(isMoveRight) {
            if(right == 1) this.img = Sprite.player_right.getFxImage();
            else if(right == 2) this.img = Sprite.player_right_1.getFxImage();
            else if (right == 3) {
                this.img = Sprite.player_right_2.getFxImage();
                right = 1;
            }
            this.x ++;
            right ++;
            left = 1;
            down = 1;
            up = 1;
        }


    }
    @Override
    public void update() {
        input();
        if (this.x < 32) this.x = 32;
        if (this.x > 960 - 32) this.x = 960 - 32;
        if (this.y < 32) this.y = 32;
        if (this.y > 384 - 32) this.y = 384 - 32;
        move();
        //    plantBomb((int) x, (int) y);
        // buffItem();
        // died();
        //   if (!isLive) {
        //       afterKill();
        //        return;
    }
}