// Класс для треугольника
public class Triangle extends AbstractShape {
    private double side1;
    private double side2;
    private double side3;

    /**
     * Конструктор для создания объекта Triangle.
     * @param side1 Длина первой стороны треугольника
     * @param side2 Длина второй стороны треугольника
     * @param side3 Длина третьей стороны треугольника
     */
    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double area() {
        double s = 0.5 * (side1 + side2 + side3);
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    /**
     * Метод возвращает название фигуры
     * @return Название фигуры
     */
    @Override
    public String getShapeName() {
        return "Треугольник";
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
