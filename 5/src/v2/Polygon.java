package v2;

import java.util.ArrayList;

public class Polygon extends Shape {
    private ArrayList<Double> sides;

    public Polygon(double... sides) {
        super();
        this.sides = new ArrayList<Double>();
        for(double side: sides)
            this.sides.add(side);
    }

    public ArrayList<Double> getSides() {
        return sides;
    }

    @Override
    public double calculatePerimeter() {
        double p = 0;
        for(double side: sides)
            p += side;
        return p;
    }

    @Override
    public double calculateArea() {
        return -1;
    }

    @Override
    public void draw() {

    }

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

    @Override
    public boolean equals(Shape shape) {
        return false;
    }
}
