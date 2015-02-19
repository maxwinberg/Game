package model.startup;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.pong.Ball;
import model.pong.BallHandler;
import model.pong.Player;
import model.pong.PlayerHandler;
import model.update.UpdateHandler;
import model.update.Updateable;
import view.render.Drawable;
import java.util.ArrayList;

public class Game extends ApplicationAdapter implements ApplicationListener {

	//Texture
	private SpriteBatch batch;
	private ArrayList<Drawable> drawables;
	private BitmapFont font;

	//Update
	private UpdateHandler updateHandler;

	private Ball balen;
	private Player left, right;


	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setScale(2, 2);
		font.setColor(new Color(0,0,0,1));
		balen = new Ball(100.0f, 100.0f, 5f);

		left = new Player(10, Gdx.graphics.getHeight()/2, 3, 125, "Knug.png");
		right = new Player(Gdx.graphics.getWidth() - 90, Gdx.graphics.getHeight()/2, 3, 125, "Dexterr.png");

		drawables = new ArrayList<Drawable>();
		drawables.add(balen);
		drawables.add(left);
		drawables.add(right);

		BallHandler ballHandler = new BallHandler(balen, left, right, this);
		PlayerHandler leftHandler = new PlayerHandler(left);
		PlayerHandler rightHandler = new PlayerHandler(right);
		ArrayList<Updateable> updateables = new ArrayList<Updateable>();
		updateables.add(ballHandler);
		updateables.add(leftHandler);
		updateables.add(rightHandler);

		updateHandler = new UpdateHandler(updateables, leftHandler, rightHandler);
	}

	public void reset(){

            balen.setY(Gdx.graphics.getHeight()/2);
            balen.setX(Gdx.graphics.getWidth()/2);




	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		font.draw(batch, left.getScore() + " : " + right.getScore(), Gdx.graphics.getWidth()/2 -50, Gdx.graphics.getHeight()/2-50);

		synchronized (drawables) {
			for (int i = 0; i < drawables.size(); i++) {
				drawables.get(i).draw(batch);
			}
		}
		batch.end();

	}

 	@Override
	public void dispose(){

	}

}