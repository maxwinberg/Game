package game;

import java.util.Scanner;

public class Game {

    public static void main(String[] args){

        Game spelet = new Game();

    }

    private Wepeon[] weapon;

    private Scanner in;

    public Game(){

        weapon = new Wepeon[3];

        System.out.println("Its time to build wepeons!!");
        for(int i = 0; i < weapon.length; i++){
            in = new Scanner(System.in);

            int val;
            System.out.println("Wepeon Number: " + i);

            System.out.println("What type of weapon?! (0) = crossbow, (1) = sword and (2) = axe");
            val = in.nextInt();
            in = new Scanner(System.in);

            System.out.println("Name:");
            String name = in.nextLine();
            in.reset();
            System.out.println("Damage:");
            int damage = in.nextInt();

            System.out.println("Speed:");
            int speed = in.nextInt();

            switch(val){

                case 0:
                    weapon[i] = new CrossBow(name, damage, speed);
                    break;
                case 1:
                    weapon[i] = new Sword(name, damage, speed);
                    break;
                case 2:
                    weapon[i] = new Axe(name, damage, speed);
                    break;
                default:
                    System.out.println("Finns inte!!!");
                    i--;
                    break;
            }

            System.out.println("Weapon " + weapon[i].getName() + " CREATED!");
        }

        for(int i = 0; i < weapon.length; i++){

            weapon[i].attack();
        }

        weapon[1].setName("Orvar");


        for(int i = 0; i < weapon.length; i++){

            weapon[i].attack();
        }



    }
}
