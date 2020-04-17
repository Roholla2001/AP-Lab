package v2;

/**
 * This class represents a Triangle
 */
public class Triangle extends Polygon {

    /**
     * Construct a new triangle with specified sides
     * @param a side a
     * @param b side b
     * @param c side c
     */
    public Triangle(double a, double b, double c) {
        super(a, b, c);
    }

    /**
     * Tell if this triangle is an equilateral
     * @return true if this triangle is an equilateral
     */
    public boolean isEquilateral() {
        return getSides().get(0).equals(getSides().get(1)) && getSides().get(0).equals(getSides().get(2));
    }

    /**
     * Calculate and return the area of this triangle
     * @return the area of this triangle
     */
    public double calculateArea() {
        Double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - getSides().get(0)) * (p - getSides().get(1)) * (p - getSides().get(2)));
    }

    /**
     * Print the triangle's perimeter and area to the standard output
     */
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
