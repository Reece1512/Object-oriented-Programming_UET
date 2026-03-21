import java.util.Scanner;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private double discount;
    private static double taxRate = 0.1;
    private static double totalRevenue = 0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public static void updateTaxRate (double newRate) {
        taxRate = newRate;
    }

    public double calculateFinalPrice() {
        double ans = (this.price-this.discount)*(1+taxRate);
        return ans;
    }

    public void updateDiscount(double newDiscount) {
        this.discount = newDiscount;
    }

    public void sell(int amount) {
        if (amount <= this.quantity) {
            double tmp = amount*calculateFinalPrice();
            totalRevenue += tmp;
            this.quantity -= amount;
            System.out.println("Success");
        } else {
            System.err.println("Khong du hang trong kho");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name1 =s.nextLine();
        double price1 = s.nextDouble();
        int quantity1 = s.nextInt();
        double discount1 = s.nextDouble();
        Product p1 = new Product(name1, price1, quantity1, discount1);

        s.nextLine();

        String name2 =s.nextLine();
        double price2 = s.nextDouble();
        int quantity2 = s.nextInt();
        double discount2 = s.nextDouble();
        Product p2 = new Product(name2, price2, quantity2, discount2);

        int buy1 = s.nextInt();
        int buy2 = s.nextInt();

        p1.sell(buy1);
        p2.sell(buy2);

        System.out.println(p1.calculateFinalPrice());
        System.out.println(p2.calculateFinalPrice());

        Product.updateTaxRate(0.08);
        System.out.println(p1.calculateFinalPrice());
        System.out.println(p2.calculateFinalPrice());

        p1.updateDiscount(10.0);
        System.out.println(p1.calculateFinalPrice());
        System.out.println(p2.calculateFinalPrice());

        System.out.println(totalRevenue);
    }
}