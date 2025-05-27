public class InheritanceDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        
        System.out.println("Animal sound:");
        animal.makeSound();
        
        System.out.println("\nDog sound:");
        dog.makeSound();
    }
}