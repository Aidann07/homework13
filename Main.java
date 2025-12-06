import java.util.*;

class User {
    String name;
    String role; 
    User(String name, String role) { this.name = name; this.role = role; }
}

class Book {
    String title;
    boolean free = true;
    Book(String title) { this.title = title; }
}

class Branch {
    String name;
    List<Book> books = new ArrayList<>();
    Branch(String name) { this.name = name; }
}

class Reservation {
    User user;
    Book book;
    boolean active = true;
    Reservation(User u, Book b) { user = u; book = b; }
}

class LibrarySystem {
    List<User> users = new ArrayList<>();
    List<Branch> branches = new ArrayList<>();
    List<Reservation> reservations = new ArrayList<>();

    User register(String name, String role) {
        User u = new User(name, role);
        users.add(u);
        return u;
    }

    Branch addBranch(String name) {
        Branch b = new Branch(name);
        branches.add(b);
        return b;
    }

    Book addBook(Branch b, String title) {
        Book book = new Book(title);
        b.books.add(book);
        return book;
    }

    Reservation reserve(User u, Book b) {
        if (!b.free) throw new RuntimeException("Book is not free");
        b.free = false;
        Reservation r = new Reservation(u, b);
        reservations.add(r);
        return r;
    }

    void cancel(Reservation r) {
        r.active = false;
        r.book.free = true;
    }

    List<Book> search(Branch b, String q) {
        List<Book> result = new ArrayList<>();
        for (Book book : b.books)
            if (book.title.toLowerCase().contains(q.toLowerCase()))
                result.add(book);
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        LibrarySystem sys = new LibrarySystem();

        User u1 = sys.register("Aidan", "READER");
        User lib = sys.register("Dana", "LIBRARIAN");
        User admin = sys.register("Admin", "ADMIN");

        Branch central = sys.addBranch("Central Library");
        Book b1 = sys.addBook(central, "1984");
        Book b2 = sys.addBook(central, "The Hobbit");

        System.out.println("Іздеу: " + sys.search(central, "hob"));

        Reservation r = sys.reserve(u1, b2);
        System.out.println("Брон жасалды: " + r.book.title);

        sys.cancel(r);
        System.out.println("Брон болдырмау — кітап бос: " + b2.free);
    }
}
