package v2;

public class Circle extends Shape {
    private Double radius;
    public static final double PI = 3.14159265;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    public double calculateArea() {
        return PI * radius * radius;
    }

    public void draw() {
        System.out.println("v1.Circle, Perimeter = " + calculatePerimeter() + ", Area = " + calculateArea());
    }

    public boolean equals(Shape shape) {
        if(shape == this)
            return true;
        if(shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return radius.equals(circle.radius);
        }
        return false;
    }

    public String toString() {
        return "Circle: r = " + radius;
    }
}
