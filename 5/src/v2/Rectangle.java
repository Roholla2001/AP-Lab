package v2;

/**
 * This class represents a rectangle
 */
public class Rectangle extends Polygon{

    /**
     * Construct a new rectangle with the given sides
     * @param a side a
     * @param b side b
     * @param c side c
     * @param d side d
     */
    public Rectangle(double a, double b, double c, double d) {
        super(a, b, c, d);
    }

    /**
     * @return true if this rectangle is a square
     */
    public boolean isSquare() {
        return getSides().get(0).equals(getSides().get(1));
    }

    /**
     * Calculate and return the area of this rectangle
     * @return the area of this rectangle
     */
    @Override
    public double calculateArea() {
        return getSides().get(0) * getSides().get(1);
    }

    /**
     * Print the rectangle's perimeter and area to the standard output
     */
    public void draw() {
        System.out.println("Rectangle, Perimeter = " + calculatePerimeter() + ", Area = " + calculateArea());
    }

    /**
     * Tell if the given rectangle is the same as this one
     * @param rectangle the rectangle to be checked
     * @return true if they are the same
     */
    public boolean equals(Rectangle rectangle) {
        if(rectangle == this)
            return true;
        return getSides().get(0).equals(rectangle.getSides().get(0)) && getSides().get(1).equals(rectangle.getSides().get(1));
    }


}
