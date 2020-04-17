package v2;

/**
 * This is an abstract super class representing a shape
 */
public abstract class Shape {
    /**
     * Construct a new shape
     */
    public Shape() {
    }

    /**
     * Calculate and return the perimeter of the shape
     * @return the perimeter of the shape
     */
    public abstract double calculatePerimeter();

    /**
     * Calculate and return the area of the shape
     * @return the area of the shape
     */
    public abstract double calculateArea();

    /**
     * Print the shape's perimeter and area to the standard output
     */
    public abstract void draw();

    /**
     * @return the string representation of this shape
     */
    public abstract String toString();

    /**
     * Tell if the given shape is the same as this one
     * this method is overridden in the sub-class's
     * @param shape the shape to be checked
     * @return true if they are the same
     */
    public boolean equals(Shape shape) {
        return false;
    }

}
