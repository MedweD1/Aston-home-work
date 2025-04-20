public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFood(int countFood) {
        if (this.foodAmount >= countFood) {
            this.foodAmount -= countFood;
            return countFood;
        } else {
            this.foodAmount = 0;
            return 0;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            this.foodAmount += amount;
            System.out.println("Докинули еды " + amount);
        }

    }

    public int FoodAmount() {
        return this.foodAmount;
    }
}
