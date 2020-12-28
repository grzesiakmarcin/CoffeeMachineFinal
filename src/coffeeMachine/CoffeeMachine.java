package coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CoffeeMachineClass automat = new CoffeeMachineClass();

        // CoffeeMachineClass.stats();


        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");

            String input=sc.nextLine();
            automat.start(input);

        }
}
