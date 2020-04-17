package v2;

public class Rectangle extends Polygon{

    public Rectangle(double a, double b, double c, double d) {
        super(a, b, c, d);
    }

    public boolean isSquare() {
        return getSides().get(0).equals(getSides().get(1));
    }

    public double calculateArea() {
        return getSides().get(0) * getSides().get(1);
    }

    public void draw() {
        System.out.println("Rectangle, Perimeter = " + calculatePerimeter() + ", Area = " + calculateArea());
    }

    public boolean equals(Rectangle rectangle) {
        if(rectangle == this)
            return true;
        return getSides().get(0).equals(rectangle.getSides().get(0)) && getSides().get(1).equals(rectangle.getSides().get(1));
    }


}
