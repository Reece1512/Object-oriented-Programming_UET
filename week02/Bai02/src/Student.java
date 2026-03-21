public class Student {
    private int id;
    private String name;
    private double gpa;
    private String email;

    public Student() {
        id = 0001;
        name = "Ronaldo";
        gpa = 3.60;
        email = "ronaldo.vnu.edu.vn";
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Student s) {
        this.id = s.id;
        this.name = s.name;
        this.gpa = s.gpa;
        this.email = s.email;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getGPA() {
        return this.gpa;
    }

    public String getEmail() {
        return this.email;
    }

    public void setGPA(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student(2, "Messi");
        s2.setGPA(-1.5);
        s2.setGPA(3.6);
        Student s3 = new Student(s2);

        System.out.println(s1.getId());
        System.out.println(s1.getName());
        System.out.println(s1.getGPA());
        System.out.println(s1.getEmail());

        System.out.println();

        System.out.println(s2.getId());
        System.out.println(s2.getName());
        System.out.println(s2.getGPA());
        System.out.println(s2.getEmail());

        System.out.println();

        System.out.println(s3.getId());
        System.out.println(s3.getName());
        System.out.println(s3.getGPA());
        System.out.println(s3.getEmail());
    }
}