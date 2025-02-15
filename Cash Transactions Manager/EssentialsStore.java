                                                                            
/**  This program is deigned using JAVA Programming Langage to manage cash transactions effectively. It works by asking the user to enter the total cost of items a student has purchased and the amount the student has paid and it computes the change to give to the student and, to help the cashier, a breakdown of the denominations of notes and coins (in Ghana Cedis) to give to the student.  
*/

import java.util.Scanner;

public class EssentialsStore {

    //Constants declaration
    private static final String CEDIS_SYMBOL = "\u20B5";
    private static final int[] NOTES = {50, 20, 10, 5, 2, 1};
    private static final double[] COINS = {0.50, 0.20, 0.10, 0.05, 0.01};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	
	    //Read the purchase details of bought item
        System.out.print("Enter the cost of the items purchased: ");
        double itemCost = scanner.nextDouble();
        System.out.print("Enter the amount paid by the customer: ");
        double amountPaid = scanner.nextDouble();

        // Calculate the customer's change
        computeChangeBreakdown(amountPaid, itemCost);
    }

    // Function to compute the change breakdown
    public static void computeChangeBreakdown(double amountPaid, double itemCost) {

        // Initializing customer Change
        double customerChange = -1;

        //Checking if the amount paid is enough
        if (amountPaid < itemCost) {
            System.out.println("The amount paid is not enough to buy the item.");
        }
        // If the amount paid is enough, calculate the customer's change?
        else {
            customerChange = amountPaid - itemCost;
            System.out.printf("Total Change: %s%.2f\n", CEDIS_SYMBOL, customerChange);
            System.out.println("Change Breakdown:");

            // Processing number of notes
            for (int i = 0; i < NOTES.length; i++) {
                int count = (int) (customerChange / NOTES[i]);

                //if the value of the count=0, no denomination of notes used.
                if (count != 0) {
                    System.out.printf("%d %s%d note%s\n", count, CEDIS_SYMBOL, NOTES[i], (count > 1 ? "s" : "")); //Add 's' to note if count value is greater than 1.
                    customerChange -= NOTES[i] * count;
                }
            }

            // Processing number of coins
            for (int i = 0; i < COINS.length; i++) {
                int count = (int) (customerChange / COINS[i]);

                //if the value of the count=0, no denomination of coins used.
                if (count != 0) {
                    int coinValue = (int) (COINS[i] * 100);
                    System.out.printf("%d %sp coin%s\n", count, coinValue, (count > 1 ? "s" : "")); //Add 's' to coins if count value is greater than 1.

                    //Updating the change to be given to the customer
                    customerChange -= COINS[i] * count;
                }
            }
        }
    }
}
