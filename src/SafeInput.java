
import java.util.Scanner;
public class SafeInput {
    public static Scanner pipe;

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }
    public static int getInt(Scanner pipe, String prompt) {
        int number = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.println("\n" + prompt + ":");
            if (pipe.hasNextInt())
            {
                number = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Invalid Input:" + trash + ".");
            }

        }while (!done);
        return number;
    }
    public static double getDouble(Scanner pipe, String prompt)
    {
        double decimalNumber =0;
        String trash = "";
        boolean done = false;

        do {
            System.out.println( "\n" + prompt + ":");
            if (pipe.hasNextDouble()) {
                decimalNumber = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else {
                trash = pipe.nextLine();
                System.out.println( "Invalid entry " + trash + ".");
            }

        }while (!done);
        return decimalNumber;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        String trash;
        boolean done = false;
        int retInt = 0;

        do {
            System.out.print("\n" + prompt + " (in range " + low + "-" + high + ") : ");
            if (pipe.hasNextInt()){
                retInt = pipe.nextInt();
                if (retInt >= low && retInt <= high){
                    done = true;
                }
                else {
                    System.out.println("Enter a valid value in range " + low + "-" + high + ", not " + retInt + ".");
                    pipe.nextLine();
                }
            }
            else {
                System.out.println();
                trash = pipe.nextLine();
                System.out.println("Enter a valid value in range " + low + "-" + high + ", not " + trash + ".");
            }
        } while(!done);

        pipe.nextLine();

        return retInt;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        String trash;
        boolean done = false;
        double retDouble = 0;

        do {
            System.out.print("\n" + prompt + " (in range " + low + "-" + high + ") : ");
            if (pipe.hasNextDouble()){
                retDouble = pipe.nextDouble();
                if (retDouble >= low && retDouble <= high){
                    done = true;
                }
                else {
                    System.out.println("Enter a valid value in range " + low + "-" + high + ", not " + retDouble + ".");
                    pipe.nextLine();
                }
            }
            else {
                System.out.println();
                trash = pipe.nextLine();
                System.out.println("Enter a valid value in range " + low + "-" + high + ", not " + trash + ".");
            }
        } while(!done);

        pipe.nextLine();

        return retDouble;
    }
    public static boolean getYNConfirm(String prompt, Scanner pipe) {
        String input;
        boolean confirmation = false;
        boolean done;
        do {
            System.out.print("\n" + prompt + " (Y/N): ");
            input = pipe.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                confirmation = true;
                done = true;
            } else if (input.equalsIgnoreCase("N")) {
                done = true;
            } else {
                done = false;
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!done);
        return confirmation;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        // Print the prompt outside the loop
        System.out.print("\n" + prompt + ": ");

        String input;
        do {
            input = pipe.nextLine();
            if (!input.matches(regEx)) {
                System.out.println("Invalid input. Please enter a string matching the pattern: " + regEx);
            }
        } while (!input.matches(regEx));

        return input;
    }
    public static void prettyHeader(String msg){
        double numberOfSpaces;
        for (int i = 1; i <= 60; i ++){
            System.out.print("*");
        }

        System.out.println();

        for (int i = 1; i <= 3; i ++){
            System.out.print("*");
        }

        numberOfSpaces = 27 - (double) (msg.length()) /2;
        int remainder = msg.length() % 2;

        for (int i = 1; i <= numberOfSpaces; i++){
            System.out.print(" ");
        }

        if(remainder != 0) {
            numberOfSpaces += 1;
        }

        System.out.print(msg);

        for (int i = 1; i <= numberOfSpaces; i++){
            System.out.print(" ");
        }

        for (int i = 1; i <= 3; i ++){
            System.out.print("*");
        }
        System.out.println();

        for (int i = 1; i <= 60; i ++){
            System.out.print("*");
        }

        System.out.println();
    }
    public static double CtoF(double Celsius){
        double fahrenheitTemp;
        fahrenheitTemp = (Celsius*9/5)+32;
        return fahrenheitTemp;
    }
}