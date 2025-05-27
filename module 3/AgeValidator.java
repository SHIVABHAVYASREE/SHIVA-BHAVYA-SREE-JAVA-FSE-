// Define the custom exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    // Method to check age
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is less than 18. Not eligible.");
        } else {
            System.out.println("Age is valid. Access granted.");
        }
    }

    // Main method
    public static void main(String[] args) {
        int userAge = 16; // You can change this value to test other scenarios

        try {
            validateAge(userAge);
        } catch (InvalidAgeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}

