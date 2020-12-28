package coffeeMachine;

import java.util.Scanner;

public class CoffeeMachineClass {  static int money = 550;
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disposaleCups = 9;
    CurrentState stan=CurrentState.ON;



    public static void stats() {

        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposaleCups + " of disposable cups");
        System.out.println("$"+money + " of money" + "\n");
    }

    static void buy() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (sc.next()) {
            case "1":
                if(water>= 250 && coffeeBeans>=16 && disposaleCups > 0) {
                    System.out.println("I have enough resources, making you a coffee!\n");

                    water -= 250;
                    milk -= 0;
                    coffeeBeans -= 16;
                    money += 4;
                    disposaleCups -= 1;
                }
                else if(water<250){System.out.println("Sorry, not enough water!\n");}
                else if (coffeeBeans<16){System.out.println("Sorry, not enough coffee beans!\n");}
                break;
            case "2":
                if(water>= 350 && milk>=75 && coffeeBeans>=20 && disposaleCups > 0) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                    disposaleCups -= 1;
                }
                else if(water<250){System.out.println("Sorry, not enough water!\n");}
                else if (coffeeBeans<16){System.out.println("Sorry, not enough coffee beans!\n");}
                else if (milk<75){System.out.println("Sorry, not enough milk!\n");}
                break;
            case "3":
                if(water>= 200 && milk>=100 && coffeeBeans>=12 && disposaleCups > 0) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                    disposaleCups -= 1;
                }
                else if(water<250){System.out.println("Sorry, not enough water!\n");}
                else if (coffeeBeans<16){System.out.println("Sorry, not enough coffee beans!\n");}
                else if (milk<75){System.out.println("Sorry, not enough milk!\n");}
                break;


            case "back":
                break;
        }

    }

    static void take() {
        System.out.println("I gave you " + money+"\n");
        money = 0;


    }

    static void fill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add: ");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffeeBeans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        disposaleCups += sc.nextInt();

    }

    public void start(String input) {

        switch (input) {
            case "fill":
                stan=CurrentState.FILLING;
                fill();
                break;

            case "take":
                stan=CurrentState.CASHING_OUT;
                take();
                break;

            case "buy":
                stan=CurrentState.MAKINGORDER;
                buy();
                break;

            case "remaining":
                stan=CurrentState.STANDBY;
                stats();
                break;

            case "exit":
                stan=CurrentState.OFF;
                System.exit(1);
                break;

        }



    }
}
