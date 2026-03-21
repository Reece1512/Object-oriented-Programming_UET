public class Animal {
    public void makeSound() {
        System.out.println("Animal Sound");
    }

    public static void main(String[] args) {
        Animal a = new Dog();
        if (a instanceof Cat) {
            Cat c = (Cat) a;
            c.makeSound();
        } else {
            System.out.println("Day khong phai la Meo!");
        }
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Woof woof");
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Meows meows");
    }
}

class Duck extends Animal {

}

