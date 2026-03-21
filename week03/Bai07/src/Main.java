import java.util.Scanner;

abstract class Room {
    protected int day_number;

    public Room(int day_number) {
        this.day_number = day_number;
    }

    public abstract double getPrice();
}

class Standard extends Room {
    public Standard(int day_number) {
        super(day_number);
    }

    public double getPrice() {
        double tmp = this.day_number*500000;
        if (this.day_number > 3) {
            return tmp*0.95;
        } else {
            return tmp;
        }
    }
}

class VIP extends Room {
    public VIP(int day_number) {
        super(day_number);
    }

    public double getPrice() {
        return this.day_number*2000000;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        if (s.equals("S")) {
            Standard r = new Standard(n);
            System.out.println(r.getPrice());
        } else {
            VIP r = new VIP(n);
            System.out.println(r.getPrice());
        }
    }
}