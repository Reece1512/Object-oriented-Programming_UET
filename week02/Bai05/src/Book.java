public class Book {
    private String title;
    private String author;
    private double price;

    public Book (String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Book b = (Book) obj;

        if (this.title.equals(b.title) && this.author.equals(b.author) && this.price == b.price) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Book x1 = new Book("Sherlock", "Conan Doyle", 15.00);
        Book x2 = new Book("Sherlock", "Conan Doyle", 15.00);
        System.out.println(x1 == x2);
        System.out.println(x1.equals(x2));
    }
}