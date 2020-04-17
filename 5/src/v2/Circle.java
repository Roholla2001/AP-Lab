package v2;

/**
 * This class represents a circle
 */
public class Circle extends Shape {
    private Double radius;
    public static final double PI = 3.14159265;

    /**
     * Construct a new circle with specified radius
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    /**
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Calculate and return the perimeter of this circle
     * @return the perimeter of this circle
     */
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    /**
     * Calculate and return the area of this circle
     * @return the area of this circle
     */
    public double calculateArea() {
        return PI * radius * radius;
    }

    /**
     * Print the circle's perimeter and area to the standard output
     */
    public void draw() {
        System.out.println("Circle, Perimeter = " + calculatePerimeter() + ", Area = " + calculateArea());
    }

    /**
     * Tell if the given shape is the same as this circle
     * @param shape the shape to be checked
     * @return true if they are the same
     */
    public boolean equals(Shape shape) {
        if(shape == this)
            return true;
        if(shape instanceof Circle) {
            Circle circle = (Circle) shape;
            return radius.equals(circle.radius);
        }
        return false;
    }

    /**
     * @return a string representation of this circle
     */
    public String toString() {
        return "Circle: r = " + radius;
    }
}
