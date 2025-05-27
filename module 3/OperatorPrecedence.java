public class OperatorPrecedence {
    public static void main(String[] args) {
        // Example 1: Multiplication has higher precedence than addition
        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("Explanation: Multiplication (*) has higher precedence than addition (+)");
        System.out.println("So 5 * 2 is calculated first (10), then added to 10, resulting in 20");
        
        // Example 2: Parentheses override default precedence
        int result2 = (10 + 5) * 2;
        System.out.println("\n(10 + 5) * 2 = " + result2);
        System.out.println("Explanation: Parentheses have highest precedence");
        System.out.println("So (10 + 5) is calculated first (15), then multiplied by 2, resulting in 30");
        
        // Example 3: Complex expression
        int result3 = 4 + 10 * 3 / 2 - 1;
        System.out.println("\n4 + 10 * 3 / 2 - 1 = " + result3);
        System.out.println("Explanation: Order of operations: * and / (from left to right), then + and -");
        System.out.println("10 * 3 = 30, then 30 / 2 = 15, then 4 + 15 - 1 = 18");
    }
}