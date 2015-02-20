package model.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import view.render.Drawable;

/**
 * Created by Max on 2015-02-19.
 */
public abstract class Item implements Drawable{

    //Coordinates
    private int x,y;
    private boolean dropped;

    //Image
    private Texture image;

    public Item(Texture image){
        this.image = image;
        dropped = false;
    }

    public Item(Texture image, boolean dropped, int x, int y){
        this.image = image;
        this.x = x;
        this.y = y;
        this.dropped = dropped;
        if(dropped){
            dropItem(x, y);
        }
    }

    public void setCoordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void dropItem(int x, int y){
        //Start The dropping animation/bouncing...
    }

    public abstract void draw(SpriteBatch batch);
}
