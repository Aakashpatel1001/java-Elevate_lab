import java.util.Scanner;

public class SimpleCalculator {

    // Method for Addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Method for Subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Method for Multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method for Division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Cannot divide by zero.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        double num1, num2;

        do {
            // Menu
            System.out.println("\n--- Simple Calculator ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                // Take two numbers as input
                System.out.print("Enter first number: ");
                num1 = sc.nextDouble();
                System.out.print("Enter second number: ");
                num2 = sc.nextDouble();

                // Perform selected operation
                switch (choice) {
                    case 1:
                        System.out.println("Result of sum is = " + add(num1, num2));
                        break;
                    case 2:
                        System.out.println("Result of  is subtraction is = " + subtract(num1, num2));
                        break;
                    case 3:
                        System.out.println("Result of multiplication= " + multiply(num1, num2));
                        break;
                    case 4:
                        System.out.println("Result of division is = " + divide(num1, num2));
                        break;
                }
            } else if (choice != 5) {
                System.out.println("Invalid choice. Please enter 1 to 5.");
            }

        } while (choice != 5);

        System.out.println("Thank you for using the calculator!");
        sc.close();
    }
}