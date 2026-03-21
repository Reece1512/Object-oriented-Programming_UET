public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public void setDay(int n) {
        this.day = n;
    }

    public void setMonth(int n) {
        this.month = n;
    }

    public void setYear(int n) {
        this.year = n;
    }
}

class Employee {
    private String name;
    private MyDate birthday;

    public Employee(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Employee(Employee e) {
        this.name = e.name;
        this.birthday = new MyDate(e.birthday.getDay(), e.birthday.getMonth(), e.birthday.getYear());
    }

    public static void main(String[] args) {
        MyDate d = new MyDate(1,1,2000);
        Employee emp1 = new Employee("emp1", d);
        Employee emp2 = new Employee(emp1);
        emp1.birthday.setDay(2);
        emp1.birthday.setMonth(2);
        emp1.birthday.setYear(2022);
        System.out.println(emp2.birthday.getDay());
        System.out.println(emp2.birthday.getMonth());
        System.out.println(emp2.birthday.getYear());
    }
}