import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final Calculator calculator;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.calculator = new Calculator();
    }

    public void performAddition() {
        System.out.println("Choose addition type:");
        System.out.println("1. add(int, int)");
        System.out.println("2. add(double, double)");
        System.out.println("3. add(int, int, int)");
        System.out.print("Enter your choice: ");
        int choice = readIntSafely();
        switch (choice) {
            case 1:
                System.out.print("Enter first integer: ");
                int a1 = readIntSafely();
                System.out.print("Enter second integer: ");
                int b1 = readIntSafely();
                int r1 = calculator.add(a1, b1);
                System.out.println("Result: " + r1);
                break;
            case 2:
                System.out.print("Enter first double: ");
                double a2 = readDoubleSafely();
                System.out.print("Enter second double: ");
                double b2 = readDoubleSafely();
                double r2 = calculator.add(a2, b2);
                System.out.println("Result: " + r2);
                break;
            case 3:
                System.out.print("Enter first integer: ");
                int a3 = readIntSafely();
                System.out.print("Enter second integer: ");
                int b3 = readIntSafely();
                System.out.print("Enter third integer: ");
                int c3 = readIntSafely();
                int r3 = calculator.add(a3, b3, c3);
                System.out.println("Result: " + r3);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void performSubtraction() {
        System.out.print("Enter first integer: ");
        int a = readIntSafely();
        System.out.print("Enter second integer: ");
        int b = readIntSafely();
        int result = calculator.subtract(a, b);
        System.out.println("Result: " + result);
    }

    public void performMultiplication() {
        System.out.print("Enter first double: ");
        double a = readDoubleSafely();
        System.out.print("Enter second double: ");
        double b = readDoubleSafely();
        double result = calculator.multiply(a, b);
        System.out.println("Result: " + result);
    }

    public void performDivision() {
        System.out.print("Enter dividend (int): ");
        int a = readIntSafely();
        System.out.print("Enter divisor (int): ");
        int b = readIntSafely();
        try {
            int result = calculator.divide(a, b);
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void mainMenu() {
        while (true) {
            System.out.println("Welcome to the Calculator Application!");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = readIntSafely();
            if (choice == 5) {
                System.out.println("Goodbye!");
                break;
            }
            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performSubtraction();
                    break;
                case 3:
                    performMultiplication();
                    break;
                case 4:
                    performDivision();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }

    private int readIntSafely() {
        while (true) {
            String line;
            if (scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
            } else {
                System.out.println("Goodbye!");
                System.exit(0);
                return 0;
            }
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.print("Invalid input. Enter an integer: ");
            }
        }
    }

    private double readDoubleSafely() {
        while (true) {
            String line;
            if (scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
            } else {
                System.out.println("Goodbye!");
                System.exit(0);
                return 0.0;
            }
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException ex) {
                System.out.print("Invalid input. Enter a double: ");
            }
        }
    }

    public static void main(String[] args) {
        new UserInterface().mainMenu();
    }
}

