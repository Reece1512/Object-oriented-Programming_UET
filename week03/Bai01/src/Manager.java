class Person {
    private String name;
    private String dob;
//    public Person() {
//        System.out.println("1.Person is created");
//    }
    public Person(String name) {
        this.name = name;
        System.out.println("1. Person is created");
    }
}

class Employee extends Person {
    private double salary;
    public Employee() {
        super("Ronaldo");
        System.out.println("2. Employee is created");
    }
}

public class Manager extends Employee {
    private String department;
    public Manager() {
        System.out.println("3. Manager is created");
    }

    public static void main(String[] args) {
        Manager m = new Manager();
    }
}