public class NumberWrapper {
    private int value;

    public void set_value (int value) {
        this.value = value;
    }

    public int get_value() {
        return this.value;
    }

    public static void swap(NumberWrapper a, NumberWrapper b) {
//        int x1 = a.get_value();
//        int x2 = b.get_value();
//        int tmp;
//        tmp = x1;
//        x1 = x2;
//        x2 = tmp;
//        a.set_value(x1);
//        b.set_value(x2);
        NumberWrapper tmp;
        tmp = a;
        a = b;
        b = tmp;
    }

    public static void main (String[] args) {
        NumberWrapper n1 = new NumberWrapper();
        NumberWrapper n2 = new NumberWrapper();
        n1.set_value(5);
        n2.set_value(10);
        swap(n1,n2);
        System.out.println(n1.get_value());
        System.out.println(n2.get_value());
    }
}

