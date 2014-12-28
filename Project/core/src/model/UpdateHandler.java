package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import model.pong.PlayerHandler;

import java.util.ArrayList;

/**
 * Created by Max on 2014-12-28.
 */
public class UpdateHandler implements Runnable {

    private ArrayList<Updateable> updateables;
    private PlayerHandler left, right;

    //Run
    private Thread thread;
    private boolean playing;

    public UpdateHandler(ArrayList<Updateable> updateables, PlayerHandler left, PlayerHandler right){

        this.updateables = updateables;
        this.left = left;
        this.right = right;

        thread = new Thread(this);
        thread.start();
    }

    public void stop(){

        playing = false;
    }

    public synchronized void addUpdateable(Updateable updateable){
        this.updateables.add(updateable);
    }

    @Override
    public void run() {
        playing = true;
        while(playing){

            if(Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.S)){
                left.moveUp();
            }else if(Gdx.input.isKeyPressed(Input.Keys.S) && !Gdx.input.isKeyPressed(Input.Keys.W)){
                left.moveDown();
            }

            if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP) && !Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)){
                right.moveUp();
            }else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN) && !Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)){
                right.moveDown();
            }
            synchronized (updateables){
                for(int i= 0; i< updateables.size(); i++){
                    updateables.get(i).update();
                }
            }


            try{
                thread.sleep(1);
            }catch(Exception e){

            }
           // thread.interrupt();

        }
    }

}
