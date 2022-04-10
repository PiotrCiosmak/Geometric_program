package geometry.points;

public interface IPoint
{
    public void setPoint(double[] point);

    public void setX(double x);

    public void setY(double y);

    public double[] getPoint();

    public double getX();

    public double getY();

    public double getDistance(IPoint otherPoint);
}