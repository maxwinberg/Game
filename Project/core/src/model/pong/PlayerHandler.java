package model.pong;

import com.badlogic.gdx.Gdx;
import model.Updateable;

import java.lang.Runnable;

/**
 * Created by Max on 2014-12-28.
 */
public class PlayerHandler implements Updateable {

    private Player player;

    public PlayerHandler(Player player){
        this.player = player;
    }


    public void moveUp(){
        if (player.getY() < Gdx.graphics.getHeight() - 135){
            player.setY(player.getY() + player.getSpeed());
        }

    }

    public void moveDown(){
        if(player.getY() > 0){
            player.setY(player.getY() - player.getSpeed());
        }

    }

    @Override
    public void update() {

    }

}
