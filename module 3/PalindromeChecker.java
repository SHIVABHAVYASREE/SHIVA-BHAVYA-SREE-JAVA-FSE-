import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Remove non-alphanumeric characters and convert to lowercase
        String processed = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        boolean isPalindrome = true;
        int length = processed.length();
        
        for (int i = 0; i < length / 2; i++) {
            if (processed.charAt(i) != processed.charAt(length - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
        
        scanner.close();
    }
}