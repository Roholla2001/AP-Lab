package v2;
import java.util.ArrayList;

public class Paint {
    private ArrayList<Shape> shapes;

    public Paint() {
        shapes = new ArrayList<Shape>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }


    public void drawAll() {
        for(Shape shape: shapes)
            shape.draw();
    }

    public void printAll() {
        for(Shape shape: shapes)
            System.out.println(shape);
    }

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
