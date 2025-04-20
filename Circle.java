// Класс для круга
public class Circle extends AbstractShape {
    private double radius;

    /**
     * Конструктор для создания объекта Circle.
     *
     * @param radius Радиус круга
     */

    public Circle(double radius, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    /**
     * Метод вычисляет периметр круга.
     *
     * @return Периметр круга
     */
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * Метод вычисляет площадь круга.
     *
     * @return Площадь круга
     */
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    /**
     * Метод возвращает название фигуры
     *
     * @return Название фигуры
     */
    @Override
    public String getShapeName() {
        return "Круг";
    }

    @Override
    public void showInfo() {
        System.out.println("-----------------------\nХарактеристика фигуры:");
        System.out.println(getShapeName());
        System.out.println("Периметр: " + perimeter());
        System.out.println("Площадь: " + area());
        System.out.println("Цвет фона: " + fillColor);
        System.out.println("Цвет границы: " + borderColor);
    }
}