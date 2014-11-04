package game;

/**
 * Created by Max on 2014-11-04.
 */
public abstract class Wepeon {

    protected int damage;
    protected int speed;
    protected String name;

    public Wepeon(String name, int damage, int speed){

        this.name = name;
        this.damage = damage;
        this.speed = speed;

    }

    public void setName(String name){
        this.name = name;
    }

    public int getDamage(){

        return damage;
    }

    public int getSpeed(){

        return speed;
    }

    public String getName(){

        return name;
    }

    public abstract void attack();
}
