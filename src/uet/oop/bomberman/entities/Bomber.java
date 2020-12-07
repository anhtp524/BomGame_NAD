package uet.oop.bomberman.entities;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber<scene> extends Entity {

    private boolean isLeft,isRight,isDown,isUp,isSpace;
    private KeyCode keyCode;

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    public void input() {
        BombermanGame.scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == keyCode.LEFT || keyEvent.getCode() == keyCode.A ) {
                isLeft = true;
            }
            if (keyEvent.getCode() == keyCode.RIGHT || keyEvent.getCode() == keyCode.D ) {
                isRight = true;
            }
            if (keyEvent.getCode() == keyCode.UP || keyEvent.getCode() == keyCode.W) {
                isUp = true;
            }
            if (keyEvent.getCode() == keyCode.DOWN || keyEvent.getCode() == keyCode.S ) {
                isDown = true;
            }
            if (keyEvent.getCode() == keyCode.SPACE || keyEvent.getCode() == keyCode.ENTER ) {
                isSpace = true;
            }
        });
        BombermanGame.scene.setOnKeyReleased(keyEvent -> {
            if (keyEvent.getCode() == keyCode.LEFT || keyEvent.getCode() == keyCode.A) {
                this.img = Sprite.player_left.getFxImage();
                isLeft = false;
            }
            if (keyEvent.getCode() == keyCode.RIGHT || keyEvent.getCode() == keyCode.D) {
                this.img = Sprite.player_right.getFxImage();
                isRight = false;
            }
            if (keyEvent.getCode() == keyCode.UP || keyEvent.getCode() == keyCode.W) {
                this.img = Sprite.player_up.getFxImage();
                isUp = false;
            }
            if (keyEvent.getCode() == keyCode.DOWN || keyEvent.getCode() == keyCode.S) {
                this.img = Sprite.player_down.getFxImage();
                isDown = false;
            }
            if (keyEvent.getCode() == keyCode.SPACE || keyEvent.getCode() == keyCode.ENTER) {
                isSpace = false;
            }
        });
    }


    public void move(){
        if(isUp) this.y--;
        else if(isDown) this.y++;
        else if(isLeft) this.x--;
        else if(isRight) this.x++;
    }

    @Override
    public void update() {
        input();
        if (this.x < 32) this.x = 32;
        if (this.x > 960 - 32) this.x = 960 - 32;
        if (this.y < 32) this.y = 32;
        if (this.y > 384 - 32) this.y = 384 - 32;
        move();
    }
}
