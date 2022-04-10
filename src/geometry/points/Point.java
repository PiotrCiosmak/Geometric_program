package geometry.points;

public class Point implements IPoint
{
    public Point(double x, double y)
    {
        this.setX(x);
        this.setY(y);
    }

    public Point(double[] point)
    {
        this.setPoint(point);
    }

    public void setPoint(double[] point)
    {
        this.point = point;
    }

    public void setX(double x)
    {
        this.point[0] = x;
    }

    public void setY(double y)
    {
        this.point[1] = y;
    }

    public double[] getPoint()
    {
        return point;
    }

    public double getX()
    {
        return this.point[0];
    }

    public double getY()
    {
        return this.point[1];
    }

    public double getDistance(IPoint otherPoint)
    {
        return Math.sqrt((Math.pow(this.getX() - otherPoint.getX(), 2) + Math.pow(this.getY() - otherPoint.getY(), 2)));
    }

    private double[] point = new double[2];
}