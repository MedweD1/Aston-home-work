import java.util.ArrayList;
// Задание 1-2
public class Main {
    public static void main(String[] args) {
        // Задача 1.
        Dog dog1 = new Dog("Рыжик");
        Dog dog2 = new Dog("Котофей");
        Cat cat1 = new Cat("Серый");
        Cat cat2 = new Cat("Малыш");
        Cat cat3 = new Cat("Туман");

        // Проверка действий
        System.out.println("\nПроверка ограничений бега");
        dog1.run(250);
        dog2.run(700);
        cat1.run(100);
        cat2.run(350);
        cat3.run(-50);

        System.out.println("\nПроверка ограничений плавания");
        dog1.swim(3);
        dog2.swim(11);
        cat1.swim(0);
        dog1.swim(-5);

        // Миска
        System.out.println("\nКормление котов:");
        Bowl bowl = new Bowl(13);
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);

        System.out.println("\nПервое кормление:");
        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        System.out.println("\nДобавление еды");
        bowl.addFood(20);
        bowl.addFood(-5);

        System.out.println("\nВторое кормление:");
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl);
            }
        }

        // Сытость
        System.out.println("\nПроверка сытости:");
        for (Cat cat : cats) {
            System.out.println(cat.name + ": " + (cat.isFull() ? "сыт" : "голоден"));
        }

        // Количество животных
        System.out.println("Всего животных: " + Animals.getTotalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());
        System.out.println("Остаток еды в миске: " + bowl.getFood());


        // Задача 2.
        GeometricShape circle = new Circle(2.5, "Жёлтый", "Фиолетовый");
        GeometricShape rectangle = new Rectangle(9, 4, "Красный", "Белый");
        GeometricShape triangle = new Triangle(3, 4, 5, "Синий", "Чёрный");

        System.out.println("\nКруг");
        circle.printInfo();

        System.out.println("\nПрямоугольник");
        rectangle.printInfo();

        System.out.println("\nТреугольник");
        triangle.printInfo();
    }
}
