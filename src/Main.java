//Software Engineering (Project) Assignment By Mahanoor memon, Maha-shaikh, MahrukhHumail.
//Project Named As Restaurant
package RestaurantBillingSystem;

import java.util.Scanner;
// BillItem.java
    class BillItem {
    private String name;
    private int quantity;
    private float price;

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

    public float getPrice() {
        return price;
    }
}
class BillFormatter {
    public static void format(String date, String name) {
        System.out.println("");
        System.out.println("\t\n             \u001B[1m\u001B[35mIMCS RESTAURANT AND CLUB\u001B[0m");
        System.out.print("             \u001B[1m\u001B[35mSINDH UNIVERSITY JAMSHORO\u001B[0m\n");
        System.out.println("=========================================================");
        System.out.println(" Date " + date);
        System.out.println(" INVOICE TO " + name);
        System.out.println("----------------------------------------------------------");
        System.out.printf(" %-20s %8s %20s%n", "ITEMS", "QTY", "TOTAL");
        System.out.println("----------------------------------------------------------");
    }

    public static void printBill(String item, int qty, float price) {
        // Adjusted formatting for item, quantity, and total
        System.out.printf(" %-20s %8d %20.2f%n", item, qty, qty * price);
    }
}
class BillingCalculator {
    public static void calculateBill(float[] price, int[] quantities) {
        float total = 0;
        for (int i = 0; i < price.length; i++) {
            total += price[i] * quantities[i];
        }
        float discount = (float) (0.1 * total);
        float netTotal = total - discount;
        System.out.println("---------------------------------------------------------");
        System.out.printf(" %-20s %8s %20s%n", "DISCOUNT      10% ", "", discount); // Discount
        System.out.println("---------------------------------------------------------");
        System.out.printf(" %-20s %8s %20s%n", "TOTAL AMOUNT", "", netTotal); // Total Amount
        System.out.println("---------------------------------------------------------");
        System.out.println("           THANK YOU VISIT AGAIN!!      ");
    }
}
class Main {
    public static void main(String[] args) {
        System.out.println("\t\nWELCOME TO IMCS RESTAURANT\n");
        Scanner scn = new Scanner(System.in);
        System.out.println("ENTER CUSTOMER NAME : ");
        String name = scn.nextLine();

        System.out.println("ENTER THE REQUESTED ORDERS ");
        int number = scn.nextInt();
        scn.nextLine(); // Consume newline

        String[] items = new String[number];
        int[] quantities = new int[number];
        float[] prices = new float[number];

        for (int i = 0; i < number; i++) {
            System.out.println(" ");
            System.out.println("ENTER ITEM " + (i + 1) + ": ");
            System.out.print("PLEASE ENTER THE ITEM NAME : ");
            items[i] = scn.nextLine();
            System.out.print("ENTER QUANTITY OF ITEMS : ");
            quantities[i] = scn.nextInt();
            System.out.print("ENTER THE PER UNIT CHARGE OF ITEM : ");
            prices[i] = scn.nextFloat();
            scn.nextLine(); // Consume newline
        }
        BillFormatter.format("05/05/2024", name);
        for (int i = 0; i < number; i++) {
            BillFormatter.printBill(items[i], quantities[i], prices[i]);
        }
        // Call billingCal method after printing all bills
        BillingCalculator.calculateBill(prices, quantities);
    }
}
