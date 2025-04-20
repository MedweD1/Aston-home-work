// Класс для прямоугольника
public class Rectangle extends AbstractShape {

    private double width;
    private double height;

    /**
     * Конструктор для создания объекта Rectangle.
     * @param width Ширина прямоугольника
     * @param height Высота прямоугольника
     */
    public Rectangle(double width, double height, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double perimeter() {

        return 2 * (width + height);
    }

    @Override
    public double area() {
        return width * height;
    }
    /**
     * Метод возвращает название фигуры
     * @return Название фигуры
     */
    @Override
    public String getShapeName() {
        return "Прямоугольник";
    }

    @Override
    public void showInfo() {
        System.out.println("-----------------------\nХарактеристики фигуры:");
        System.out.println(getShapeName());
        System.out.println("Периметр: " + perimeter());
        System.out.println("Площадь: " + area());
        System.out.println("Цвет фона: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}