import java.util.Scanner;

interface IPayable {
    public double getPaymentAmount();
}

abstract class Staff implements IPayable {
    private String id;
    private String name;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}

class PartTimeStaff extends Staff {
    private int workingHours;
    private double hourlyRate;

    public PartTimeStaff(String id, String name, int workingHours, double hourlyRate) {
        super(id,name);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double getPaymentAmount() {
        return (this.workingHours*this.hourlyRate);
    }
}

class Invoice implements IPayable {
    private String itemName;
    private int quantity;
    private double pricePerItem;

    public Invoice(String itemName, int quantity, double pricePerItem) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getItemName() {
        return this.itemName;
    }

    @Override
    public double getPaymentAmount() {
        return (this.quantity*this.pricePerItem);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        IPayable[] payableList = new IPayable[n+1];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("S")) {
                String id = sc.next();
                String name = sc.next();
                int workingHours = sc.nextInt();
                double hourlyRate = sc.nextDouble();
                payableList[i] = new PartTimeStaff(id, name, workingHours, hourlyRate);
            } else {
                String name = sc.next();
                int quantity = sc.nextInt();
                double pricePerItem = sc.nextDouble();
                payableList[i] = new Invoice(name, quantity, pricePerItem);
            }
        }

        for (int i = 0; i < n; i++) {
            if (payableList[i] instanceof PartTimeStaff) {
                total += (payableList[i]).getPaymentAmount();
                System.out.print("PartTimeStaff ");
                System.out.print(((PartTimeStaff) payableList[i]).getName());
                System.out.println(" - " + "Payment: " + (payableList[i]).getPaymentAmount());
            } else {
                total += (payableList[i]).getPaymentAmount();
                System.out.print("Invoice ");
                System.out.print(((Invoice) payableList[i]).getItemName());
                System.out.println(" - " + "Payment: " + (payableList[i]).getPaymentAmount());
            }
        }
        System.out.println("Total Payment = " + total);
    }
}