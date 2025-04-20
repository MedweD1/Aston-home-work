public class Maine {
    public static void main(String[] args) {
        Circle circle = new Circle(18, "Розовый", "Черный");
        circle.showInfo();

        Rectangle rectangle = new Rectangle(5, 6, "Синий", "Красный");
        rectangle.showInfo();

        Triangle triangle = new Triangle(5, 6, 5, "Салатовый", "Серый");
        triangle.showInfo();
    }
}