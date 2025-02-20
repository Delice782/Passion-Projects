                         
/** This java program compute the total value of an investment and the interest earned over a period. It prompts the user:
-For initial amount to invest (principal)
-The yearly rate (rate)
-The number of times the interest is compounded each year (periodsPerYear)
-The amount the user will add to the investment account in each period after the initial one (deposit)
-The number of periods the investment will accrue over (totalPeriods).  

In other words, it computes the total value of the investment, and the total interest earned over the period (that is, the total value of the investment less t he total amount paid in by the user).
*/

// Import the required libraries
import java.util.Scanner;

public class InvestmentCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading input from the user
        System.out.print("Enter initial amount to invest: ");
        double principal = scanner.nextDouble();
        System.out.print("Enter the yearly rate: ");
        double rate = scanner.nextDouble();
        System.out.print("Enter number of times the interest is compounded each year: ");
        int periodsPerYear = scanner.nextInt();
        System.out.print("Enter the amount you will deposit after each period: ");
        double deposit = scanner.nextDouble();
        System.out.print("Enter the number of periods the investment will accrue over: ");
        int totalPeriods = scanner.nextInt();
        final String CEDISCODE="\u20B5";

        // Calculate the total investment value
        double totalValueOfInvestment = computeInvestmentValue(principal, rate, periodsPerYear, deposit, totalPeriods);

        // Calculate the total interest earned
        double totalInterestEarned = totalValueOfInvestment - (principal + deposit * (totalPeriods - 1));

        // Display the results
        System.out.printf(String.format("The total value of the investment: %s%.3f\n", CEDISCODE, totalValueOfInvestment));
        System.out.printf(String.format("The total interest earned over the period: %s%.3f\n", CEDISCODE, totalInterestEarned));
    }

    // Function to compute investment value
    public static double computeInvestmentValue(double principal, double rate, int periodsPerYear, double deposit, int totalPeriods) {
        // Initialize all required variables
        double totalInvestmentValue = principal;    //total value of investment
        final int PERCENT=100;
        double periodicInterestRate = (rate / PERCENT )/ periodsPerYear;  // Interest rate of the investment
        final String CEDISCODE="\u20B5";  // Sign of Cedis

        // Update the totalInvestmentValue appropriately
        for (int period = 1; period <= totalPeriods; period++) {
            totalInvestmentValue *= (1 + periodicInterestRate); // Total investment over the period
            if (period < totalPeriods) { // Add deposit at the end of each period except the last
                totalInvestmentValue += deposit;
            }
        }

        return totalInvestmentValue;
    }
}
