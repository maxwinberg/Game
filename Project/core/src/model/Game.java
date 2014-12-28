package model;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import model.pong.Ball;
import model.pong.BallHandler;
import model.pong.Player;
import model.pong.PlayerHandler;
import view.rendering.Drawable;

import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game extends ApplicationAdapter implements ApplicationListener {

	//Texture
	private SpriteBatch batch;
	private Texture img;
	private ArrayList<Drawable> drawables;

	//Update
	private UpdateHandler updateHandler;

	private Ball balen;
	private Player left, right;


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");


		balen = new Ball(100.0f, 100.0f, 5f);

		left = new Player(10, Gdx.graphics.getHeight()/2, 3, "Knug.png");
		right = new Player(Gdx.graphics.getWidth() - 90, Gdx.graphics.getHeight()/2, 3, "Dexter.png");

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
