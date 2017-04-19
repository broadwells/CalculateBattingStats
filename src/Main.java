//author: Stephanie Broadwell
//lab #8
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean play = true;
        System.out.println("Welcome To Batting Average Calculator!");

        while (play) {
            System.out.println("Enter number of times at bat: ");
            int batNum = scan.nextInt();    //batNum will be stored as the length of the array atBat

            int[] atBat = new int[batNum];

            System.out.println("0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");
            for (int i = 0; i < atBat.length; i++) {    //gathering bases earned & assigning to each index in the array
                System.out.println("Result for at-bat " + i + ": ");
                int baseEarned = scan.nextInt();
                atBat[i] = baseEarned;
            }

            battingAverage(atBat);  //calling on method to calculate the batting average
            System.out.println();
            slugPercentage(atBat);  //calling on method to calculate the slugging percentage
            System.out.println();

            scan.nextLine();
            boolean validateInput = true;
            while (validateInput) {     //while loop validating the user enters only "Y/y or N/n"
                System.out.println("Another batter? (y/n): ");
                String playBall = scan.nextLine();
                if (playBall.equalsIgnoreCase("n")) {
                    System.out.println("Goodbye!");
                    play = false;   //exits the entire program when false
                    validateInput = false;  //exits the validation while loop
                }
                else if (playBall.equalsIgnoreCase("y")) {
                    validateInput = false;
                    play = true;
                }
                else if (playBall.equalsIgnoreCase("no") || playBall.equalsIgnoreCase("yes")) {
                    System.out.println("Invalid input. Please enter only 'y' or 'n'.");
                    play = false;   //does not allow for the program to restart with invalid input
                }
            }
        }
    }
    //use of printf and "%.3f" is to only print out 3 decimal places
    public static void battingAverage(int[] atbat) {
        double batBase = 0.0;
        double batAvg = 0.0;
        for (int i = 0; i < atbat.length; i++){
            if (atbat[i] > 0) {     //searching for index in array that contain numbers 1 - 4 only
                batBase = batBase + 1;
                batAvg = batBase / atbat.length;
            }
        }
        System.out.printf("Batting average: " + "%.3f", batAvg);
    }
    public static void slugPercentage(int[] atbat) {
        double totalBases = 0.0;
        double percentage = 0.0;
        for (int i = 0; i < atbat.length; i++) {
            if (atbat[i] > 0) {
                totalBases = totalBases + atbat[i];
                percentage = totalBases / atbat.length;
            }
        }
        System.out.printf("Slugging Percentage: " + "%.3f", percentage);
    }
}
