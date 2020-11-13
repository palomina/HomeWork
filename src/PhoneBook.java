import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PhoneBook {
    private final HashMap<String, HashSet<String>> book;

    public PhoneBook() {
        this.book = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
// 1 вариант
//        if (book.get(lastName) == null) {
//            book.put(lastName, new HashSet<>());
//        }
//        book.get(lastName).add(phoneNumber);

// 2 вариант
        book.computeIfAbsent(lastName, s -> new HashSet<>()).add(phoneNumber);
    }

    public void get(String lastName) {
        if (book.get(lastName) != null) {
            System.out.println(lastName + ": " + book.get(lastName).toString());
        } else {
            System.out.println(lastName + ": номер не найден");
        }
    }

    public void print() {
        for (Map.Entry<String, HashSet<String>> e : book.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue().toString());
        }
    }
}
