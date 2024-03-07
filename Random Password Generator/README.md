# Random Password Generator

## Project Overview

The Random Password Generator is a Java program designed to create secure passwords that comply with specified security requirements. It allows users to define password complexity rules, including the minimum length, minimum number of uppercase characters, digits, and special characters, as well as a set of allowed special characters. The program ensures that the generated passwords meet these criteria before presenting them to the user.

## Features

- **Customizable Password Requirements:** Users can specify their own password criteria, including length, number of uppercase letters, digits, and special characters.
- **Allowed Special Characters:** Users define which special characters are permissible in the password.
- **Password Validation:** Includes a method to validate whether a given password meets the specified requirements.
- **User Interaction:** Through the main method, the program interacts with the user to collect input for password rules and to choose between generating a new password or validating an existing one.

## Usage 

- **To Generate a Password:** The program will prompt you to enter the minimum password length, the minimum number of uppercase characters, digits, and special characters, and a string of allowed special characters.
- **To Validate a Password:** You can also use the program to check if a specific password meets the set rules by entering the password along with the criteria it needs to satisfy.
Code Structure
- **generatePassword Method:** Takes parameters for minimum password length, minimum uppercase characters, digits, special characters, and a string of allowed special characters. It returns a string representing the generated password.
-**checkPassword Method:** Accepts a password and the same set of criteria as generatePassword to verify if the password is valid based on the given rules.
- **Main Method:** Interacts with the user to gather input for generating or validating a password and invokes the appropriate methods based on user choice.