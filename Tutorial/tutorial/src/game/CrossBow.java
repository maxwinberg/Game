package game;

public class CrossBow extends Wepeon {


    public CrossBow(String name, int damage, int speed){
        super(name, damage, speed);

    }

    public void attack(){

        System.out.println("I AM AAAAAN CROOOSSSBOW !!! My name is " + name + "! And i will Shoot you with the damage of " + damage + "!!!");
    }

}
