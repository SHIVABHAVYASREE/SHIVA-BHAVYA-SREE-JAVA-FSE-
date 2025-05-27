public class InterfaceDemo {
    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        
        System.out.println("Guitar:");
        guitar.play();
        
        System.out.println("\nPiano:");
        piano.play();
    }
}