//Задание 1
abstract class Animals {
    protected String name;
    private static int totalCount = 0;

    public Animals(String name) {
        this.name = name;
        totalCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getTotalCount() {
        return totalCount;
    }
}
