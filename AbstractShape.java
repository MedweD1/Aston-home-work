public  abstract class AbstractShape implements Perimetr, Area {
    public String fillColor;
    public String borderColor;

    public AbstractShape(String fillColor, String borderColor) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
    @Override
    public abstract double area();

    @Override
    public abstract double perimeter();

    public abstract String getShapeName();

    public abstract void showInfo();
}
