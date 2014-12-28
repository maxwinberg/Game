package game;

public class Axe extends Wepeon{

    public Axe(String name, int damage, int speed){
        super(name, damage, speed);
    }

    public void attack(){

        System.out.println("I AM A AAAAXE!!! My name is " + name + "! And i will Hit you with the damage of " + damage + "!!!");
    }

}
