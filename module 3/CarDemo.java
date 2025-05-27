public class CarDemo {
    public static void main(String[] args) {
        // Create car objects
        Car car1 = new Car("Toyota", "Corolla", 2020);
        Car car2 = new Car("Honda", "Civic", 2019);
        
        // Display car details
        car1.displayDetails();
        System.out.println();
        car2.displayDetails();
    }
}