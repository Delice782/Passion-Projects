/**This java program is designed to generates and validates
 * passwords based on specified criteria: minimum length, minimum numbers of uppercase letters,
 * digits, and special characters, and a set of allowed special characters.
 *  The program consists of two methods: 'generatePassword' for creating passwords
 *  and 'checkPassword' for validating them, along with a 'main' method for user interaction.
 *  */


// Import the required libraries
import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for password requirements
        System.out.print("Enter minimum password length: ");
        int minPassLength = scanner.nextInt();
        System.out.print("Enter minimum number of uppercase characters: ");
        int minUpperChars = scanner.nextInt();
        System.out.print("Enter minimum number of digits: ");
        int minDigits = scanner.nextInt();
        System.out.print("Enter minimum number of special characters: ");
        int minSpecialChars = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.println("Enter allowed special characters: ");
        String allowedSpecialChars = scanner.nextLine();

        // Generate password
        String generatedPassword = generatePassword(minPassLength, minUpperChars, minDigits, minSpecialChars, allowedSpecialChars);
        System.out.println("The generated Password: " + generatedPassword);

        // Checking if the generated password is valid (optional)
        System.out.println("Is the generated password valid? " + checkPassword(generatedPassword, minPassLength, minUpperChars, minDigits, minSpecialChars, allowedSpecialChars));
	
	    // Check if the generated password is valid
        boolean isValid = checkPassword(generatedPassword, minPassLength, minUpperChars, minDigits, minSpecialChars, allowedSpecialChars);

        // Provide feedback on password validity
        if (isValid) {
            System.out.println("The generated password meets all the specified criteria.");
        } else {
            System.out.println("The generated password does NOT meet all the specified criteria.");
        }
    }

    // Function to generate password

    public static String generatePassword(int minPassLength, int minUpperChars, int minDigits, int minSpecialChars, String allowedSpecialChars) {
        // Initialize necessary variables
        Random random = new Random();
        char[] password = new char[minPassLength];
        int count = 0;

        // Define the array of uppercase characters
        char[] upperChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        // Generate and add random uppercase characters
        for (int i = 0; i < minUpperChars; i++) {
            char randUpperChar = (char)('a' + random.nextInt(26));
            password[count] = randUpperChar;
            count++;
        }

        // Generate and add random digits
        for (int i = 0; i < minDigits; i++) {
            char randDigit = (char) ('0' + random.nextInt(10));
            password[count] = randDigit;
            count++;
        }

        // Generate and add random special characters
        for (int i = 0; i < minSpecialChars; i++) {
            char randSpecialChar = allowedSpecialChars.charAt(random.nextInt(allowedSpecialChars.length()));
            password[count] = randSpecialChar;
            count++;
        }

        // Generate and add random lowercase characters 
        while (count < minPassLength) {
            password[count] = (char) ('a' + random.nextInt(26));
            count++;
        }

        // Return password generated in form of String
        return new String(password);
    }

	// Method to check if the password is valid
	public static boolean checkPassword(String password, int minPassLength, int minUpperChars, int minDigits, int minSpecialChars, String allowedSpecialChars) {
    // Check password length
    if (password.length() < minPassLength) {
        return false;
    }

    // Initialize necessary variables
    int upperCharsCount = 0;
    int digitCount = 0;
    int specialCharCount = 0;

    // Count each type of character
    for (int i = 0; i < password.length(); i++) {
        char currentChar = password.charAt(i);
        if (Character.isUpperCase(currentChar)) {
            upperCharsCount++;
        } else if (Character.isDigit(currentChar)) {
            digitCount++;
        } else if (allowedSpecialChars.indexOf(currentChar) != -1) {
            specialCharCount++;
        }
    }

	// Check if the password meets all requirements
    boolean isValid = upperCharsCount >= minUpperChars && digitCount >= minDigits && specialCharCount >= minSpecialChars;

    // Return the password validity results
    return isValid;

}

}
