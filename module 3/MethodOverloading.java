public class MethodOverloading {
    public static void main(String[] args) {
        System.out.println("Sum of 5 and 10: " + add(5, 10));
        System.out.println("Sum of 3.5 and 2.7: " + add(3.5, 2.7));
        System.out.println("Sum of 2, 4, and 6: " + add(2, 4, 6));
    }
    
    // Method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Method to add two doubles
    public static double add(double a, double b) {
        return a + b;
    }
    
    // Method to add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
}