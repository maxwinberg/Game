package model.image;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

/**
 * Created by Max on 2015-02-21.
 */
public class ImageHandler {

    private static ImageHandler handler = new ImageHandler();
    private HashMap<String, Texture> images;

    private ImageHandler(){
        images = new HashMap<String, Texture>();
    }

    public ImageHandler getHandler(){
        return handler;
    }


    public void addImage(String path){
        if(!images.containsKey(path)){
            try{
                images.put(path, new Texture(path));
            }catch (Exception e){
                System.out.println("ERROR ImageHandler: couldnt load Image:" + path);
            }
        }
    }

    public Texture getImage(String path){
        if(!images.containsKey(path)){
            addImage(path);
        }
        return images.get(path);
    }

    public void reset(){
        images.clear();
    }
}
