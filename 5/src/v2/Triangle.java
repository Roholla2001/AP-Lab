package v2;


public class Triangle extends Polygon {

    public Triangle(double a, double b, double c) {
        super(a, b, c);
    }

    public boolean isEquilateral() {
        return getSides().get(0).equals(getSides().get(1)) && getSides().get(0).equals(getSides().get(2));
    }

    public double calculateArea() {
        Double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - getSides().get(0)) * (p - getSides().get(1)) * (p - getSides().get(2)));
    }

    public void draw() {
        System.out.println("Triangle, Perimeter = " + calculatePerimeter() + ", Area = " + calculateArea());
    }

    public boolean equals(Triangle triangle) {
        if(triangle == this)
            return true;
        return getSides().get(0).equals(triangle.getSides().get(0)) && getSides().get(1).equals(triangle.getSides().get(1)) && getSides().get(2).equals(triangle.getSides().get(2));
    }

    public String toString() {
        return "Triangle:: " + super.toString();
    }

}
