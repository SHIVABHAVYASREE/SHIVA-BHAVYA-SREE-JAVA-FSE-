public class TypeCastingExample {
    public static void main(String[] args) {
        // Double to int casting
        double doubleValue = 9.99;
        int intValue = (int) doubleValue;
        
        System.out.println("Original double value: " + doubleValue);
        System.out.println("After casting to int: " + intValue);
        
        // Int to double casting
        int anotherInt = 5;
        double anotherDouble = (double) anotherInt;
        
        System.out.println("Original int value: " + anotherInt);
        System.out.println("After casting to double: " + anotherDouble);
    }
}