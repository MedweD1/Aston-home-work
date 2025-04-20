public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Dog dogSharik = new Dog("Шарик");
        Cat catKorjik = new Cat("Кот Коржик");
        int minValue = 1;
        int maxValue = 240;
        int randomValue = minValue + (int)(Math.random() * (double)(maxValue - minValue + 1));
        dogSharik.run(randomValue);
        dogSharik.swim(8);
        catKorjik.run(randomValue);
        catKorjik.swim(randomValue);
        System.out.println("Количество созданных типов животных: " + Animal.count);
        System.out.println("Количество созданных кошек: " + Cat.getCatCount());
        System.out.println("Количество созданных собак: " + Dog.getDogCount());
        System.out.println("----------------------");
        Cat[] cats = new Cat[5];

        for(int i = 0; i < cats.length; ++i) {
            cats[i] = new Cat("Кот № " + (i + 1));
        }

        Bowl bowl = new Bowl(35);

        for(int i = 0; i < cats.length; ++i) {
            int foodTaken = bowl.getFood(10);
            cats[i].eat(foodTaken);
            if (i < cats.length - 1) {
                System.out.print("\nОсталось в миске " + bowl.FoodAmount() + " --> ");
            }
        }

        for(Cat cat : cats) {
            if (cat.fullness) {
                System.out.println(cat.name + " сытый.");
            } else {
                System.out.println(cat.name + " голодный.");
            }
        }

        catKorjik.eat(bowl.getFood(10));
        System.out.println("Осталось в миске " + bowl.FoodAmount());
        bowl.addFood(10);
        catKorjik.eat(bowl.getFood(10));
    }
}
