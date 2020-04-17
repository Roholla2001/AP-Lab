package v2;
import java.util.ArrayList;

/**
 * This class holds a list of shapes and can draw or print them
 */
public class Paint {
    private ArrayList<Shape> shapes;

    /**
     * Construct a new paint
     */
    public Paint() {
        shapes = new ArrayList<Shape>();
    }

    /**
     * Add a shape to the list
     * @param shape the shape to be added
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Draw all the shapes in the list
     */
    public void drawAll() {
        for(Shape shape: shapes)
            shape.draw();
    }

    /**
     * Print all the shapes in the list
     */
    public void printAll() {
        for(Shape shape: shapes)
            System.out.println(shape);
    }

    /**
     * Print the squares and equilateral triangles
     */
    public void describeEqualSides() {
        for(Shape shape: shapes)
            if(shape instanceof Triangle) {
                Triangle triangle = (Triangle) shape;
                if(triangle.isEquilateral())
                    System.out.println(triangle);
            }
            else if(shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                if(rectangle.isSquare())
                    System.out.println(rectangle);
            }

    }

}
