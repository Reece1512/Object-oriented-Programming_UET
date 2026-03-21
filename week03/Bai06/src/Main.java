import java.time.LocalDate;
import java.util.Scanner;

class Product {
    private String type;
    private String name;
    protected double price;
    static double total_price;

    public Product(String type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public double getFinalPrice() {
        return this.price;
    }

    public String getType() {
        if (this.type.equals("E")) {
            return "Electronics";
        } else {
            return "Food";
        }
    }

    public String getName() {
        return this.name;
    }
}

class Electronics extends Product {
    private double warranty;

    public Electronics(String type, String name, double price, double warranty) {
        super(type, name, price);
        this.warranty = warranty;
    }

    public double getFinalPrice() {
        return 1.1*this.price + this.warranty;
    }
}

class Food extends Product {
    private String date;

    public Food(String type, String name, double price, String date) {
        super(type, name, price);
        this.date = date;
    }

    public double getFinalPrice() {
        double final_price = this.price;
        LocalDate exDate = LocalDate.parse(this.date);
        LocalDate today = LocalDate.now();
        LocalDate next_week = today.plusDays(7);
        if (exDate.isBefore(next_week)) {
            return this.price*0.8;
        }
        return this.price;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        Product[] arr = new Product[n+1];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("E")) {
                String name = sc.next();
                double price = sc.nextDouble();
                double warranty = sc.nextDouble();
                arr[i] = new Electronics("E", name, price, warranty);
            } else {
                String name = sc.next();
                double price = sc.nextDouble();
                String date = sc.next();
                arr[i] = new Food("F", name, price, date);
            }
        }

        for (int i = 0; i < n; i++) {
            Product.total_price += arr[i].getFinalPrice();
            if (arr[i].getType().equals("Electronics")) {
                System.out.println(arr[i].getName() + " - " + arr[i].getType() + " - " + arr[i].getFinalPrice());
            } else {
                System.out.println(arr[i].getName() + " - " + arr[i].getType() + " - " + arr[i].getFinalPrice());
            }
        }
        System.out.println("Total = " + Product.total_price);
    }
}