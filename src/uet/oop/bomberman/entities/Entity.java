package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;


    protected Image img;

    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int xUnit, int yUnit, Image img) {
        this.x = xUnit * Sprite.SCALED_SIZE;
        this.y = yUnit * Sprite.SCALED_SIZE;
        this.img = img;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public abstract void update();
    public boolean check(Entity e) {
       /*int leftX = this.x;
       int rightX = this.x + Sprite.SCALED_SIZE ;
       int topY = this.y;
       int bottomY = this.y + Sprite.SCALED_SIZE ;
       int leftE = e.x ;
       int rightE = e.x + Sprite.SCALED_SIZE;
       int topE = e.y;
       int bottomE = e.y + Sprite.SCALED_SIZE;
       if (bottomY <= topE) return false;
       if (topY >= bottomE) return false;
       if (leftX >= rightE) return false;
       if (rightX <= leftE) return false;
       return true;*/
        int sumX = this.x + Sprite.SCALED_SIZE;
        int sumY = this.y + Sprite.SCALED_SIZE;
        if(sumX >= e.x+10 && sumY >= e.y+5 && this.x <= e.x+Sprite.SCALED_SIZE-5 && this.y<=e.y+Sprite.SCALED_SIZE-10) {
            return true;
        }
        return false;
    }


}