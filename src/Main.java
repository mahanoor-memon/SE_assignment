// Software Engineering (Project) Assignment By Mahanoor memon, Maha-shaikh, MahrukhHumail.
// Project Named As Restaurant
package RestaurantBillingSystem;

// BillItem.java
class BillItem {
    private final String name;
    private final int quantity;
    private final float price;

    public BillItem(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotalPrice() {
        return quantity * price;
    }
}

// BillFormatter.java
class BillFormatter {
    public static void formatHeader(String date, String name) {
        System.out.println();
        System.out.println("\t\n             \u001B[1m\u001B[35mIMCS RESTAURANT AND CLUB\u001B[0m");
        System.out.println("             \u001B[1m\u001B[35mSINDH UNIVERSITY JAMSHORO\u001B[0m");
        System.out.println("=========================================================");
        System.out.println(" Date: " + date);
        System.out.println(" INVOICE TO: " + name);
        System.out.println("----------------------------------------------------------");
        System.out.printf(" %-20s %8s %20s%n", "ITEMS", "QTY", "TOTAL");
        System.out.println("----------------------------------------------------------");
    }

    public static void printBillItem(BillItem item) {
        System.out.printf(" %-20s %8d %20.2f%n", item.getName(), item.getQuantity(), item.getTotalPrice());
    }

    public static void printFooter(float total) {
        System.out.println("----------------------------------------------------------");
        System.out.printf(" %-20s %8s %20.2f%n", "TOTAL", "", total);
        System.out.println("=========================================================");
    }
}

// BillingCalculator.java
class BillingCalculator {
    public static float calculateTotal(BillItem[] items) {
        float total = 0;
        for (BillItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("\t\nWELCOME TO IMCS RESTAURANT\n");

        // Predefined customer name and order date
        String name = "John Doe";
        String date = "05/05/2024";

        // Predefined list of items
        BillItem[] items = {
                new BillItem("Burger", 2, 800),
                new BillItem("Pizza", 1, 1140),
                new BillItem("Coke", 3, 1200),
                new BillItem("Fries", 2, 1000)
        };

        BillFormatter.formatHeader(date, name);

        for (BillItem item : items) {
            BillFormatter.printBillItem(item);
        }

        float total = BillingCalculator.calculateTotal(items);
        BillFormatter.printFooter(total);
    }
}
