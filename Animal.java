public abstract class Animal {
    static int animalCount = 0;
    String name;
    static int count;

    public Animal(String name) {
        this.name = name;
        ++count;
    }

    public abstract void run(int var1);

    public abstract void swim(int var1);
}
