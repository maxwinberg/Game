package model.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import model.startup.Game;
import model.update.Updateable;

/**
 * Created by Max on 2014-12-28.
 */
public class BallHandler implements Updateable{

    private Ball ball;
    private Player left, right;
    private Game game;

    public BallHandler(Ball ball, Player left, Player right, Game game){
        this.ball = ball;
        this.left = left;
        this.right = right;
        this.game = game;

    }

    @Override
    public void update() {

        if(ball.getY() <= 0  || ball.getY() >= Gdx.graphics.getHeight()-20){
            ball.setVelocity(new Vector2(ball.getVelocity().x, (-1)*ball.getVelocity().y));
        }

        if(ball.getRectangle().overlaps(left.getRectangle())){
            ball.setVelocity(new Vector2((-1)*ball.getVelocity().x, ball.getVelocity().y));
        }else if(ball.getRectangle().overlaps(right.getRectangle())){
            ball.setVelocity(new Vector2((-1)*ball.getVelocity().x, ball.getVelocity().y));
        }

        if(ball.getX() < 0){
            right.setScore(right.getScore() + 1);
            game.reset();
        }


        if(ball.getX() > Gdx.graphics.getWidth()){
            left.setScore(left.getScore() + 1);
            game.reset();
        }

        ball.setX(ball.getX() + ball.getVelocity().x);
        ball.setY(ball.getY() + ball.getVelocity().y);

    }
}
