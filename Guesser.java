// Name: Steven Houser
// Project: The Java Guesser
// Date: 03/13/26

import java.util.*;

public class Guesser {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        new Guesser();
    } // end main

    public Guesser() {
        boolean keepGoing = true;
        while (keepGoing) {
            String response = menu();
            if (response.equals("0")) {
                keepGoing = false;
            } else if (response.equals("1")) {
                humanGuesser();
            } else if (response.equals("2")) {
                computerGuesser();
            } else {
                System.out.println("Please enter 0, 1, or 2.");
            } // end if
        } // end while
    } // end constructor

    // Display menu and return user choice
    public String menu() {
        System.out.println();
        System.out.println("0) Exit");
        System.out.println("1) Human Guesser");
        System.out.println("2) Computer guesser");
        System.out.println();
        System.out.print("Please enter 0-2: ");
        String response = input.nextLine();
        return response;
    } // end menu

    // Run the human guesser game
    public void humanGuesser() {
        System.out.println("human guesser");

        // Pick a random target number between 1 and 100
        int target = (int)(Math.random() * 100) + 1;
        int turns = 0;
        boolean hKeepGoing = true;

        while (hKeepGoing) {
            turns++;
            System.out.print(turns + ") Please enter a number: ");
            String strGuess = input.nextLine();
            try {
                int guess = Integer.parseInt(strGuess);

                if (guess == target) {
                    System.out.println("got it!");
                    hKeepGoing = false;
                } else if (guess < target) {
                    System.out.println("too low...");
                } else {
                    System.out.println("too high...");
                } // end if
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                turns--;
            } // end try
        } // end while

        // Evaluate performance
        if (turns < 7) {
            System.out.println("\nVery good!");
        } else if (turns == 7) {
            System.out.println("\nAverage/Good job");
        } else {
            System.out.println("\nPoor performance");
        } // end if
    } // end humanGuesser

    // Run the computer guesser game
    public void computerGuesser() {
        System.out.println("computer guesser");

        int lower = 1;
        int upper = 100;
        int turns = 0;
        int guess = getMean(lower, upper);
        boolean cKeepGoing = true;

        while (cKeepGoing) {
            turns++;
            System.out.print(turns + ") I guess " + guess);
            System.out.println();
            System.out.print("Too (H)igh, too (L)ow, or (C)orrect? ");
            String response = input.nextLine();

            if (response.equalsIgnoreCase("h")) {
                upper = guess - 1;
                guess = getMean(lower, upper);
            } else if (response.equalsIgnoreCase("l")) {
                lower = guess + 1;
                guess = getMean(lower, upper);
            } else if (response.equalsIgnoreCase("c")) {
                cKeepGoing = false;
            } else {
                System.out.println("Please enter H, L, or C.");
            } // end if
        } // end while
    } // end computerGuesser

    // Return the midpoint between two numbers
    public int getMean(int lower, int upper) {
        return (lower + upper) / 2;
    } // end getMean

} // end class def
