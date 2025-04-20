public class Dog extends Animal {
    int MAX_RUN_DISTANCE = 400;
    int MAX_SWIM_DISTANCE = 10;
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        ++dogCount;
    }

    public void run(int lenght) {
        if (lenght >= this.MAX_RUN_DISTANCE) {
            System.out.println(this.name + " не может пробежать " + lenght + " м.");
        } else {
            System.out.println(this.name + " пробежал " + lenght + " м.");
        }

    }

    public void swim(int lenght) {
        if (lenght >= this.MAX_SWIM_DISTANCE) {
            System.out.println(this.name + " не может проплыть " + lenght + " м.");
        } else {
            System.out.println("И еще " + this.name + "  проплыл " + lenght + " м.  Какой он молодец");
        }

    }

    public static int getDogCount() {
        return dogCount;
    }
}
