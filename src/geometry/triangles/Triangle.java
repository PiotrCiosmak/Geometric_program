package geometry.triangles;

import geometry.points.Point;

import java.util.Comparator;

public class Triangle implements ITriangle
{
    public Triangle(Point a, Point b, Point c)
    {
        this.points[0] = a;
        this.points[1] = b;
        this.points[2] = c;
    }

    public double getPerimeter()
    {
        return this.points[0].getDistance(this.points[1]) + this.points[1].getDistance(this.points[2]) + this.points[2].getDistance(this.points[0]);
    }

    public double getArea()
    {
        double p = getPerimeter() / 2;
        return Math.sqrt((p - this.points[0].getDistance(this.points[1])) * (p - this.points[1].getDistance(this.points[2])) * (p - this.points[2].getDistance(this.points[0])));
    }

    public double getHeight(int n)
    {
        return this.points[(n + 2) % 3].getDistance(this.points[(n + 1) % 3]);
    }

    public void setPoint(Point p, int n)
    {
        this.points[n] = p;
    }

    public Point getPoint(int n)
    {
        return this.points[n];
    }

    private Point[] points = new Point[3];
}