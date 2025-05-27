/**
 * Simple class to demonstrate decompilation
 */
public class DecompileExample {
    private final String message;
    private static final int MAGIC_NUMBER = 42;
    
    public DecompileExample(String message) {
        this.message = message;
    }
    
    public void printMessage() {
        System.out.println(message);
    }
    
    public int calculateValue(int input) {
        if (input < 0) {
            return 0;
        } else if (input > 100) {
            return 100;
        }
        return input * MAGIC_NUMBER;
    }
    
    public static void main(String[] args) {
        DecompileExample example = new DecompileExample("Hello, Decompilation!");
        example.printMessage();
        System.out.println("Calculated value: " + example.calculateValue(10));
    }
}

/*
To decompile the class file:

1. Compile the class:
   javac DecompileExample.java

2. Use a decompiler tool:
   
   Option 1: Using CFR (Command-line decompiler)
   - Download CFR from: https://www.benf.org/other/cfr/
   - Run: java -jar cfr-0.152.jar DecompileExample.class

   Option 2: Using JD-GUI (Graphical decompiler)
   - Download JD-GUI from: http://java-decompiler.github.io/
   - Open JD-GUI and open the DecompileExample.class file

3. Analyze the decompiled source:
   - Compare it with the original source code
   - Note how the decompiler reconstructs control flow statements
   - Observe how final variables and constants are handled
   - See if method and variable names are preserved
*/