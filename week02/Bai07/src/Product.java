public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setPrice(double n) {
        this.price = n;
    }

    public void setId(String n) {
        this.id = n;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}

class Inventory {
    private Product[] items;
    public Inventory(Product[] initialItems) {
        this.items = initialItems;
    }

    public void print() {
        int n = this.items.length;
        for (int i = 0; i < n; i++) {
            System.out.println(items[i].getId());
            System.out.println(items[i].getName());
            System.out.println(items[i].getPrice());
        }
    }

    public static void main(String[] args) {
        Product a1 = new Product("001", "laptop", 1000);
        Product a2 = new Product("002", "PC", 2500);
        Product[] arr = {a1,a2};
        Inventory kho = new Inventory(arr);
        arr[0].setPrice(5000);
        kho.print();
    }
}