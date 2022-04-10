package geometry.view;

import geometry.points.IPoint;
import geometry.quadrangles.IQuadrangle;
import geometry.triangles.ITriangle;

import java.util.ArrayList;

public interface IView
{
    public int menu();

    public IPoint addPoint();

    public void addPoints(ArrayList<IPoint> points);

    public void changePointCoordinate(ArrayList<IPoint> points);

    public void showPoint(ArrayList<IPoint> points);

    public void showPoints(ArrayList<IPoint> points);

    public void showDistance(ArrayList<IPoint> points);

    public ITriangle addTriangle(ArrayList<IPoint> points);

    public void changePointTriangle(ArrayList<ITriangle> triangles);

    public void showTriangles(ArrayList<ITriangle> triangles, String arg);

    public void showPerimeterTriangle(ArrayList<ITriangle> triangles);

    public void showAreaTriangle(ArrayList<ITriangle> triangles);

    public void showHeightTriangle(ArrayList<ITriangle> triangles);

    public void sortTriangleByArea(ArrayList<ITriangle> triangles);

    public IQuadrangle addQuadrangle(ArrayList<IPoint> points);

    public void changePointQuadrangle(ArrayList<IQuadrangle> quadrangles);

    public void showQuadrangles(ArrayList<IQuadrangle> quadrangle, String arg);

    public void showPerimeterQuadrangle(ArrayList<IQuadrangle> quadrangle);

    public void showAreaQuadrangle(ArrayList<IQuadrangle> quadrangle);

    public void showDiagonalQuadrangle(ArrayList<IQuadrangle> quadrangles);

    public void sortQuadrangleByArea(ArrayList<IQuadrangle> quadrangles);

}