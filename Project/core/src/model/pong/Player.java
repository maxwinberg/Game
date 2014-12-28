package model.pong;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import model.Updateable;
import view.rendering.Drawable;

/**
 * Created by Max on 2014-12-28.
 */
public class Player implements Drawable, Updateable {

    //Position
    private float speed;
    private Rectangle rectangle;

    //Graphics
    private Texture img;

    //Game
    private int score;

    public Player(float x, float y, float speed, float height, String imagePath){
        this.speed = speed;
        rectangle = new Rectangle(x, y, 75, height);

        img = new Texture(imagePath);
    }

    public float getX() {
        return rectangle.getX();
    }

    public float getY() {
        return rectangle.getY();
    }

    public float getSpeed() {
        return speed;
    }


    public void setX(float x) {
        this.rectangle.setX(x);
    }

    public void setY(float y) {
        this.rectangle.setY(y);
    }


    public Rectangle getRectangle(){
        return rectangle;
    }


    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void draw(SpriteBatch spriteBatch){
        spriteBatch.draw(img, rectangle.getX(), rectangle.getY());
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    @Override
    public void update() {

    }

}
