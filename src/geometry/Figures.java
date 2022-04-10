package geometry;

import geometry.points.IPoint;
import geometry.quadrangles.IQuadrangle;
import geometry.triangles.ITriangle;
import geometry.view.IView;
import geometry.view.View;

import java.util.ArrayList;

public class Figures
{
    static IView myView = new View();

    public static void main(String[] args)
    {
        ArrayList<IPoint> points = new ArrayList<IPoint>();
        ArrayList<ITriangle> triangles = new ArrayList<ITriangle>();
        ArrayList<IQuadrangle> quadrangles = new ArrayList<IQuadrangle>();

        while (true)
        {
            switch (myView.menu())
            {
                case 1:
                    points.add(myView.addPoint());
                    break;
                case 2:
                    myView.addPoints(points);
                    break;
                case 3:
                    myView.changePointCoordinate(points);
                    break;
                case 4:
                    myView.showPoint(points);
                    break;
                case 5:
                    myView.showPoints(points);
                    break;
                case 6:
                    myView.showPoints(points);
                    myView.showDistance(points);
                    break;
                case 7:
                    myView.showPoints(points);
                    triangles.add(myView.addTriangle(points));
                    break;
                case 8:
                    myView.showTriangles(triangles, "basic");
                    myView.changePointTriangle(triangles);
                    break;
                case 9:
                    myView.showTriangles(triangles, "area");
                    break;
                case 10:
                    myView.showTriangles(triangles, "basic");
                    myView.showPerimeterTriangle(triangles);
                    break;
                case 11:
                    myView.showTriangles(triangles, "basic");
                    myView.showAreaTriangle(triangles);
                    break;
                case 12:
                    myView.showTriangles(triangles, "basic");
                    myView.showHeightTriangle(triangles);
                    break;
                case 13:
                    myView.sortTriangleByArea(triangles);
                    break;
                case 14:
                    myView.showPoints(points);
                    quadrangles.add(myView.addQuadrangle(points));
                    break;
                case 15:
                    myView.showQuadrangles(quadrangles, "basic");
                    myView.changePointQuadrangle(quadrangles);
                    break;
                case 16:
                    myView.showQuadrangles(quadrangles, "area");
                    break;
                case 17:
                    myView.showQuadrangles(quadrangles, "basic");
                    myView.showPerimeterQuadrangle(quadrangles);
                    break;
                case 18:
                    myView.showQuadrangles(quadrangles, "basic");
                    myView.showAreaQuadrangle(quadrangles);
                    break;
                case 19:
                    myView.showQuadrangles(quadrangles, "basic");
                    myView.showDiagonalQuadrangle(quadrangles);
                    break;
                case 20:
                    myView.sortQuadrangleByArea(quadrangles);
                    break;
                case 21:
                    System.out.println("Opuszczanie programu...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nie ma takiej opcji!");
            }
        }
    }
}
