package geometry.quadrangles;

import geometry.points.Point;

public interface IQuadrangle
{
    public double getPerimeter();

    public double getArea();

    public double getDiagonal(int n);

    public void setPoint(Point p, int n);

    public Point getPoint(int n);
}
