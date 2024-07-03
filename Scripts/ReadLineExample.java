import java.util.Scanner;

public class ReadLineExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt(); 

        // Consume the leftover newline
        scanner.nextLine(); 

        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); 

        System.out.println("You entered: " + number);
        System.out.println("Your name is: " + name);
    }
}