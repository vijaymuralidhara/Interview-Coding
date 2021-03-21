import java.util.*;

public class Manhattan{
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Scanner cons = new Scanner(System.in);
        int response = 1;
        while (response == 1) {
            intro();
            String res = calculateManhattan(console);
            System.out.println(res);
            System.out.println();
            response = tryAgain(cons);
        }
    }

    public static void intro() {    // Prints intro message      
        System.out.println("This program accepts two coordinate points and returns the Manhattan Distance between the two points.");
        System.out.println();
    }

    public static int tryAgain(Scanner cons) {      // Allows user to run the program again
        System.out.println("Enter 'y' if you want to calculate the distance for another pair of points.");
        System.out.println("Otherwise, enter any other key to exit.");
           String response = cons.next();
           response = response.toLowerCase();
           if (response.startsWith("y")) {
              return 1;
           } else {
              return 0;
           }
        }       

    public static String calculateManhattan(Scanner console) {      // Logic for processing input and printing output. Also handles any errors
        int count = 0;
        int tries = Integer.MAX_VALUE;
        double[] fcoor = new double[2];
        double[] scoor = new double[2];
        while (true) {
            try {
                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        System.out.println("Enter first coordinate: ");
                        fcoor = calc(console);
                    } else {
                        System.out.println("Enter second coordinate: ");
                        scoor = calc(console);
                    }
                }
                double res = Math.abs(scoor[0]-fcoor[0]) + Math.abs(scoor[1]-fcoor[1]);     // Manhattan distance calculation
                return ("The Manhattan distance between (" + fcoor[0] + ", " + fcoor[1] + ") and (" + scoor[0] + ", " + scoor[1] + ") is " + (Math.round(res * 100.0) / 100.0) + " units.");
            } catch (NumberFormatException e) {
                System.out.println("Error Message: " + e.getMessage());
                System.out.println("Proper usage is: (_,_)");
                System.out.println();
                if (++count == tries) throw e;
            }
        }
    }

    public static double[] calc(Scanner console) {      // Logic for filtering and storing user input coordinates
        String coord = console.nextLine();
        System.out.println();
        String[] parts = coord.split(",");
        String x = parts[0].trim().substring(1).trim();
        double xvalue = Double.parseDouble(x);
        String y = parts[1].trim().substring(0, parts[1].trim().length() - 1).trim();
        double yvalue = Double.parseDouble(y);
        return new double[]{xvalue, yvalue};
    } 
}