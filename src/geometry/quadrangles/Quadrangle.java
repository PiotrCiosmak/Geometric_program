package geometry.quadrangles;

import geometry.points.Point;

public class Quadrangle implements IQuadrangle
{
    public Quadrangle(Point a, Point b, Point c, Point d)
    {
        this.points[0] = a;
        this.points[1] = b;
        this.points[2] = c;
        this.points[3] = d;
    }

    public double getPerimeter()
    {
        return this.points[0].getDistance(this.points[1]) + this.points[1].getDistance(this.points[2]) + this.points[2].getDistance(this.points[3]) + this.points[3].getDistance(this.points[0]);
    }

    public double getArea()
    {
        double p1 = getPerimeterTriangle(1) / 2;
        double p2 = getPerimeterTriangle(2) / 2;
        return Math.sqrt(p1 * (p1 - this.points[0].getDistance(this.points[1])) * (p1 - this.points[1].getDistance(this.points[2])) * (p1 - this.points[2].getDistance(this.points[0]))) + Math.sqrt(p2 * (p2 - this.points[0].getDistance(this.points[2])) * (p2 - this.points[2].getDistance(this.points[3])) * (p2 - this.points[3].getDistance(this.points[0])));
    }

    public double getDiagonal(int n)
    {
        return this.points[n % 4].getDistance(this.points[(n + 2) % 4]);
    }

    public void setPoint(Point p, int n)
    {
        this.points[n] = p;
    }

    public Point getPoint(int n)
    {
        return this.points[n];
    }

    private double getPerimeterTriangle(int n)
    {
        return this.points[0].getDistance(this.points[n]) + this.points[n].getDistance(this.points[n + 1]) + this.points[n + 1].getDistance(this.points[0]);
    }

    private Point[] points = new Point[4];
}