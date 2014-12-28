package model.pong;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import model.Updateable;
import view.rendering.Drawable;

/**
 * Created by Max on 2014-12-28.
 */
public class Ball implements Drawable{

    //Position
    private Vector2 velocity;
    private float speed;
    private Rectangle rectangle;

    //Graphics
    private Texture img;

    public Ball(float x, float y, float speed){
        this.speed = speed;
        rectangle = new Rectangle(x, y, 25, 25);
        velocity = new Vector2(speed, 1);

        img = new Texture("Ball.png");
    }

    public Vector2 getVelocity(){
        return velocity;
    }

    public void setVelocity(Vector2 velocity){
        this.velocity = velocity;
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

    public Rectangle getRectangle(){
        return rectangle;
    }

    public void setX(float x) {
        this.rectangle.setX(x);
    }

    public void setY(float y) {
        this.rectangle.setY(y);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void draw(SpriteBatch spriteBatch){
        spriteBatch.draw(img, rectangle.getX(), rectangle.getY());
    }


}
