import java.util.Scanner;

abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public void chargeBattery() {
        this.batteryLevel = 100;
    }

    final void showIdentity() {
        System.out.print(this.id + " " + this.modelName + " ");
    }

    abstract public void performMainTask();
}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

interface GPS {
    void getCoordinates();
}

class DroneRobot extends Robot implements Flyable, GPS, ElectronicDevice {
    public DroneRobot(int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        this.showIdentity();
        System.out.println("performing main task");
    }

    public void fly() {
        this.showIdentity();
        System.out.println("flying");
    }

    public void getCoordinates() {
        this.showIdentity();
        System.out.println("getting coordinates");
    }

    public void turnOn() {
        this.showIdentity();
        System.out.println("turning on");
    }
}

//class DroneRobot extends Robot, ElectronicDevice implements Flyable, GPS {
//    public DroneRobot(int id, String modelName) {
//        super(id, modelName);
//    }
//
//    public void performMainTask() {
//        this.showIdentity();
//        System.out.println("performing main task");
//    }
//
//    public void fly() {
//        this.showIdentity();
//        System.out.println("flying");
//    }
//
//    public void getCoordinates() {
//        this.showIdentity();
//        System.out.println("getting coordinates");
//    }
//}

class FishRobot extends Robot implements Swimmable {
    public FishRobot(int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        this.showIdentity();
        System.out.println("performing main task");
    }

    public void swim() {
        this.showIdentity();
        System.out.println("swimming");
    }
}

class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {
    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }

    public void performMainTask() {
        this.showIdentity();
        System.out.println("performing main task");
    }

    public void fly() {
        this.showIdentity();
        System.out.println("flying");
    }

    public void swim() {
        this.showIdentity();
        System.out.println("swimming");
    }

    public void getCoordinates() {
        this.showIdentity();
        System.out.println("getting coordinates");
    }
}

interface ElectronicDevice {
    abstract void turnOn();
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Robot[] arr = new Robot[n+1];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int id = sc.nextInt();
            String name = sc.next();
            
            if (s.equals("DR")) {
                arr[i] = new DroneRobot(id,name);
            } else if (s.equals("FR")) {
                arr[i] = new FishRobot(id,name);
            } else {
                arr[i] = new AmphibiousRobot(id, name);
            }
        }
//        for (int i = 0; i < n; i++) {
//            arr[i].performMainTask();
//        }
        //arr[0].fly();

        //((DroneRobot)arr[0]).fly();
        //((DroneRobot)arr[1]).fly();
        //((DroneRobot)arr[2]).fly();

        for (int i = 0; i < n; i++) {
            arr[i].performMainTask();
            if (arr[i] instanceof Flyable) {
                Flyable f = (Flyable) arr[i];
                f.fly();
            }
            if (arr[i] instanceof Swimmable) {
                Swimmable s = (Swimmable) arr[i];
                s.swim();
            }
            if (arr[i] instanceof GPS) {
                GPS g = (GPS) arr[i];
                g.getCoordinates();
            }
            System.out.println();
        }
    }
}