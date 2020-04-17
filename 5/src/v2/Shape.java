package v2;

public abstract class Shape {
    public Shape() {
    }

    public abstract double calculatePerimeter();

    public abstract double calculateArea();

    public abstract void draw();

    public abstract String toString();

    public abstract boolean equals(Shape shape);

}
