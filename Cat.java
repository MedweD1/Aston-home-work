public class Cat extends Animal {
    int MAX_RUN_DISTANCE = 250;
    private static int CatCount = 0;
    boolean fullness;

    public Cat(String name) {
        super(name);
        ++CatCount;
    }

    public void run(int lenght) {
        if (lenght >= this.MAX_RUN_DISTANCE) {
            System.out.println(this.name + " не может пробежать " + lenght + " м.");
        } else {
            System.out.println(this.name + " пробежал " + lenght + " м.");
        }

    }

    public void swim(int lenght) {
        System.out.println(this.name + ": это кот, поэтому не может плавать. А умел бы плавать,цены бы ему не было :)");
    }

    public static int getCatCount() {
        return CatCount;
    }

    public void eat(int foodAmount) {
        if (foodAmount > 0) {
            this.fullness = true;
            System.out.print(this.name + " покушал из миски и пошел спать или в туалет.");
        } else {
            this.fullness = false;
            System.out.println(this.name + " не может покушать из миски, так как не хватает еды. Надо вовремя приходить на обед !");
        }

    }
}