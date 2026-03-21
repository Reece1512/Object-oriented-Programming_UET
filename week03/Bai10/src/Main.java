import java.util.Scanner;

class Employee {
    protected String name;
    protected double baseSalary;

     public Employee(String name, double baseSalary) {
         this.name = name;
         this.baseSalary = baseSalary;
     }

     public double calculateBonus() {
         return (0.1*this.baseSalary);
     }

     public String getName() {
         return this.name;
     }
}

class Developer extends Employee {
    private int overtimeHours;

    public Developer(String name, double baseSalary, int overtimeHours) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateBonus() {
        return (0.1*super.baseSalary + this.overtimeHours*200000);
    }
}

class Tester extends Employee {
    private int bugsFound;

    public Tester(String name, double baseSalary, int bugsFound) {
        super(name, baseSalary);
        this.bugsFound = bugsFound;
    }

    @Override
    public double calculateBonus() {
        return (0.1*super.baseSalary + this.bugsFound*50000);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Employee[] arr = new Employee[n+1];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("E")) {
                String name = sc.next();
                double baseSalary = sc.nextDouble();
                arr[i] = new Employee(name, baseSalary);
            } else if (s.equals("D")) {
                String name = sc.next();
                double baseSalary = sc.nextDouble();
                int overtimeHours = sc.nextInt();
                arr[i] = new Developer(name, baseSalary, overtimeHours);
            } else {
                String name = sc.next();
                double baseSalary = sc.nextDouble();
                int bugsFound = sc.nextInt();
                arr[i] = new Tester(name, baseSalary,bugsFound);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] instanceof Developer) {
                System.out.println(arr[i].getName() + " - " + "Bonus: " + arr[i].calculateBonus());
                System.out.println("Tang khoa hoc AWS");
            } else if (arr[i] instanceof Tester) {
                System.out.println(arr[i].getName() + " - " + "Bonus: " + arr[i].calculateBonus());
                System.out.println("Tang tool Test");
            } else {
                System.out.println(arr[i].getName() + " - " + "Bonus: " + arr[i].calculateBonus());
            }
        }
    }
}