/**
 * Класс Employeer представляет сотрудника компании.
 */
public class Employeer {
    public String fio;
    public String position;
    public String email;
    public String phone;
    public int salary;
    public int age;

    public Employeer(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("ФИО: " + fio);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
    }

    public static void main(String[] args) {
        Employeer employeer = new Employeer("Замухрышев Петр Никонорович", "Инженер по безоблачным технологиями", "starover@examp.com","7919691484", 50000, 130);
        employeer.displayInfo();
    }
}
