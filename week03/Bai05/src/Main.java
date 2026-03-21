import java.util.Scanner;

abstract class Employee {
    private String name;
    private String DoB;
    private int id;

    public Employee(String name, String DoB, int id) {
        this.name = name;
        this.DoB = DoB;
        this.id = id;
    }

    public abstract double real_salary();

    public abstract String getType();

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
}

class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double bonus;
    private double penalty;
    private String type;

    public FullTimeEmployee(String name, String DoB, int id, double baseSalary, double bonus, double penalty) {
        super(name, DoB, id);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.penalty = penalty;
        this.type = "F";
    }

    public double real_salary() {
        return this.baseSalary + (this.bonus - this.penalty);
    }

    public String getType() {
        return this.type;
    }
}

class PartTimeEmployee extends Employee {
    private double workingHours;
    private double hourlyRate;
    private String type;

    public PartTimeEmployee(String name, String DoB, int id, double workingHours, double hourlyRate) {
        super(name, DoB, id);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
        this.type = "P";
    }

    public double real_salary() {
        return this.workingHours*this.hourlyRate;
    }

    public String getType() {
        return this.type;
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
            if (s.equals("F")) {
                String name = sc.next();
                double base = sc.nextDouble();
                double bonus = sc.nextDouble();
                double penalty = sc.nextDouble();
                arr[i] = new FullTimeEmployee(name, "null", i + 1, base, bonus, penalty);
            } else {
                String name = sc.next();
                double workingHours = sc.nextDouble();
                double hourlyRate = sc.nextDouble();
                arr[i] = new PartTimeEmployee(name, "null", i + 1, workingHours, hourlyRate);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i].getType().equals("F")) {
                System.out.println(arr[i].getName() + " - " + "Full-time - " + arr[i].real_salary());
            } else {
                System.out.println(arr[i].getName() + " - " + "Part-time - " + arr[i].real_salary());
            }
        }
    }
}