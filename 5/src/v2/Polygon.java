package v2;

import java.util.ArrayList;

/**
 * This super class implements a polygon
 */
public class Polygon extends Shape {
    private ArrayList<Double> sides;

    /**
     * Construct a new polygon with the given sides
     * @param sides the length of each side
     */
    public Polygon(double... sides) {
        super();
        this.sides = new ArrayList<Double>();
        for(double side: sides)
            this.sides.add(side);
    }

    /**
     * @return the list of sides
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    /**
     * Calculate and return the perimeter of this polygon
     * @return the perimeter of this polygon
     */
    @Override
    public double calculatePerimeter() {
        double p = 0;
        for(double side: sides)
            p += side;
        return p;
    }

    /**
     * This method is overridden in its subclasses
     * @return -1
     */
    @Override
    public double calculateArea() {
        return -1;
    }

    /**
     * This method is overridden in its subclasses
     */
    @Override
    public void draw() {

    }

    /**
     * @return the string representation of this polygon
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        int i = 1;
        for(double side: sides) {
            if(i > 1)
                result.append(", ");
            result.append("side" + i++ + ":" + side);
        }
        return result.toString();
    }

    /**
     * This method is overridden in the subclasses
     * @param shape the shape to be checked
     * @return false
     */
    @Override
    public boolean equals(Shape shape) {
        return false;
    }
}
