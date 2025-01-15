import java.util.Scanner;
import java.util.HashMap;

class Main {
    private static HashMap<String, String> users = new HashMap<>();
    private static boolean isLoggedIn = false;
    private static String currentUser = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main menu
        while (true) {
            System.out.println("Welcome to the Login System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Access Secured Page");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    accessSecuredPage();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Registration method
    private static void register(Scanner scanner) {
        System.out.println("Register a new user");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if username already exists
        if (users.containsKey(username)) {
            System.out.println("Username already taken. Try a different one.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Store username and password in the map
        users.put(username, password);
        System.out.println("Registration successful!");
    }

    // Login method
    private static void login(Scanner scanner) {
        System.out.println("Login");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Verify credentials
        if (users.containsKey(username) && users.get(username).equals(password)) {
            isLoggedIn = true;
            currentUser = username;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    // Secured page method
    private static void accessSecuredPage() {
        if (isLoggedIn) {
            System.out.println("Welcome " + currentUser + ", you have access to the secured page!");
            // You can add more functionality here for secured actions
        } else {
            System.out.println("You must log in first to access the secured page.");
        }
    }
}