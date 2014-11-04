package game;


public class Sword extends Wepeon{

    public Sword(String name, int damage, int speed){

        super(name, damage, speed);
    }

    public void attack(){
        System.out.println("I AM AAA SWOOOORD!! My name is " + name + "! And i will Hit you with the damage of " + damage + "!!!");
    }


}
