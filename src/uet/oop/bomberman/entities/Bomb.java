package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.graphics.Sprite;


public class Bomb extends Entity{
    private double time2explode = 120;

    public Bomb(int xUnit, int yUnit, Image img) {
        super(xUnit, yUnit, img);
    }

    public void plantBomb(){
        if(Bomber.isPlantBomb){
            Bomb b = new Bomb(this.x/Sprite.SCALED_SIZE, this.y/Sprite.SCALED_SIZE, Sprite.bomb.getFxImage());
            BombermanGame.getStillObject().add(b);
            Bomber.isPlantBomb = false;
        }
    }
    @Override
    public void update() {
        plantBomb();
    }
}

