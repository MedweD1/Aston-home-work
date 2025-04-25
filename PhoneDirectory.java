import java.util.*;

public class PhoneDirectory {
    private final Map<String, List<String>> directory = new TreeMap<>();

    public void add(String lastName, String phoneNumber) {
        directory.computeIfAbsent(lastName, k -> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return directory.getOrDefault(lastName, Collections.emptyList());
    }

    public void printAllEntries() {
        System.out.println("\nПолный телефонный справочник:");
        directory.forEach((name, phones) ->
                System.out.println(name + ": " + String.join(", ", phones)));
    }

    public static void demo() {
        PhoneDirectory phoneBook = new PhoneDirectory();

        phoneBook.add("Сидоров", "38-185");
        phoneBook.add("Козырев", "38-164");
        phoneBook.add("Бубко", "38-223");
        phoneBook.add("Николаев", "38-108");
        phoneBook.printAllEntries();

        System.out.println("\nПоиск по фамилии:");
        searchAndPrint(phoneBook, "Иванов");
        searchAndPrint(phoneBook, "Бубко");
        searchAndPrint(phoneBook, "Николаев");
    }

    private static void searchAndPrint(PhoneDirectory phoneBook, String lastName) {
        List<String> phones = phoneBook.get(lastName);
        if (phones.isEmpty()) {
            System.out.println("Абонент " + lastName + " не найден");
        } else {
            System.out.println(lastName + ": " + String.join(", ", phones));
        }
    }
}
