package model.pong;

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
        player.setY(player.getY() + player.getSpeed());
    }

    public void moveDown(){
        player.setY(player.getY() - player.getSpeed());
    }

    @Override
    public void update() {

    }

}