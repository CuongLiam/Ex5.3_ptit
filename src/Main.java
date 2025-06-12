import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<ComparableCircle> circles = new ArrayList<>();

        circles.add(new ComparableCircle(2.0));
        circles.add(new ComparableCircle(5.5));
        circles.add(new ComparableCircle(3.1));
        circles.add(new ComparableCircle(1.0));

        System.out.println("Before sorting:");
        for (ComparableCircle c : circles) {
            System.out.println(c);
        }

        Collections.sort(circles);  // Sort based on perimeter

        System.out.println("\nAfter sorting by perimeter:");
        for (ComparableCircle c : circles) {
            System.out.println(c);
        }
    }
}

abstract class GeometricObject {
    private String color = "white";
    private boolean filled = false;
    private Date dateCreated;

    protected GeometricObject() {
        dateCreated = new Date();
    }

    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        dateCreated = new Date();
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
}

class ComparableCircle extends GeometricObject implements Comparable<ComparableCircle> {
    private double radius;

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        this.radius = radius;
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", perimeter=" + getPerimeter() + "]";
    }

    @Override
    public int compareTo(ComparableCircle o){
        return Double.compare(this.getPerimeter(), o.getPerimeter());
    }
}
