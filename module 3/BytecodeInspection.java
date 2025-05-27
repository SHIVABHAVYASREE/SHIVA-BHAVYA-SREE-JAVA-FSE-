/**
 * Simple class to demonstrate bytecode inspection with javap
 */
public class BytecodeInspection {
    private int value;
    
    public BytecodeInspection(int value) {
        this.value = value;
    }
    
    public int calculateSquare() {
        return value * value;
    }
    
    public static void main(String[] args) {
        BytecodeInspection obj = new BytecodeInspection(5);
        System.out.println("Square: " + obj.calculateSquare());
    }
}

/*
To inspect the bytecode:

1. Compile the class:
   javac BytecodeInspection.java

2. Use javap to view the bytecode:
   javap -c BytecodeInspection

3. Sample output and interpretation:

Compiled from "BytecodeInspection.java"
public class BytecodeInspection {
  public BytecodeInspection(int);
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: iload_1
       6: putfield      #2                  // Field value:I
       9: return

  public int calculateSquare();
    Code:
       0: aload_0
       1: getfield      #2                  // Field value:I
       4: aload_0
       5: getfield      #2                  // Field value:I
       8: imul
       9: ireturn

  public static void main(java.lang.String[]);
    Code:
       0: new           #3                  // class BytecodeInspection
       3: dup
       4: iconst_5
       5: invokespecial #4                  // Method "<init>":(I)V
       8: astore_1
       9: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
      12: new           #6                  // class java/lang/StringBuilder
      15: dup
      16: invokespecial #7                  // Method java/lang/StringBuilder."<init>":()V
      19: ldc           #8                  // String Square: 
      21: invokevirtual #9                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      24: aload_1
      25: invokevirtual #10                 // Method calculateSquare:()I
      28: invokevirtual #11                 // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
      31: invokevirtual #12                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      34: invokevirtual #13                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      37: return
}

Interpretation:
- Constructor: Loads 'this' reference (aload_0), calls Object constructor, loads 'this' again, loads the parameter (iload_1), and stores it in the field (putfield).
- calculateSquare(): Loads 'this', gets the field value twice, multiplies them (imul), and returns the result (ireturn).
- main(): Creates a new BytecodeInspection object with value 5, stores it, gets System.out, creates a StringBuilder, appends strings and the result of calculateSquare(), and prints the result.
*/