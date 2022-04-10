package geometry.triangles;

import geometry.points.Point;

public interface ITriangle
{
    public double getPerimeter();

    public double getArea();

    public double getHeight(int n);

    public void setPoint(Point p, int n);

    public Point getPoint(int n);
}
