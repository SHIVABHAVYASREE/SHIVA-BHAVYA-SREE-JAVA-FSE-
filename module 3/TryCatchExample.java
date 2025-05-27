import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter the first integer: ");
            int numerator = scanner.nextInt();
            
            System.out.print("Enter the second integer: ");
            int denominator = scanner.nextInt();
            
            int result = numerator / denominator;
            System.out.println(numerator + " / " + denominator + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            scanner.close();
        }
    }
}