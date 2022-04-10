package geometry.view;

import geometry.points.IPoint;
import geometry.points.Point;
import geometry.quadrangles.IQuadrangle;
import geometry.quadrangles.Quadrangle;
import geometry.triangles.ITriangle;
import geometry.triangles.Triangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//Przed każdą funkcja dać możliwość (opcjonalnie) wyśietlanie listy np. dostępnych pkt, trójkątów itd

public class View implements IView
{
    static Scanner sc = new Scanner(System.in);

    public int menu()
    {
        System.out.print("Naciśnij jakikowiek klawiesz aby przejsc dalej: ");
        sc.nextLine();
        System.out.println("---MENU---");
        System.out.println("-Punkty-");
        System.out.println("1. Dodaj punkt");
        System.out.println("2. Dodaj wiele punktów");
        System.out.println("3. Zmień współrzędne punktu");
        System.out.println("4. Pokaż punkt");
        System.out.println("5. Pokaż wszystkie punkty");
        System.out.println("6. Oblicz odległość miedzy dwoma punktami");
        System.out.println("");
        System.out.println("-Trójkąty-");
        System.out.println("7. Dodaj trójkat");
        System.out.println("8. Zmień współrzędne punktu w trójkącie");
        System.out.println("9. Pokaż wszystkie trójkąty");
        System.out.println("10. Oblicz obwod trójkąta");
        System.out.println("11. Oblicz pole trójkąta");
        System.out.println("12. Oblicz wysokość trójkąta");
        System.out.println("13. Posortuj tablice trójkątów po polu powierzchni");
        System.out.println("");
        System.out.println("-Czworokąty-");
        System.out.println("14. Dodaj czworokąt");
        System.out.println("15. Zmień współrzędne punktu w czworokącie");
        System.out.println("16. Pokaż wszystkie czworokąty");
        System.out.println("17. Oblicz obwod czworokąta");
        System.out.println("18. Oblicz pole czworokąta");
        System.out.println("19. Oblicz przekątne czworokąta");
        System.out.println("20. Posortuj tablice czworokątów po polu powierzchni");
        System.out.println("21. Wyjdź");
        int option = parseWithMessageInt("WYBIERZ JEDNĄ Z OPCJI: ");
        return option;
    }

    public IPoint addPoint()
    {
        System.out.println("Podaj współrzędne nowego punktu");
        double x = parseWithMessageDouble("x = ");
        double y = parseWithMessageDouble("y = ");
        return new Point(x, y);
    }

    public void addPoints(ArrayList<IPoint> points)
    {
        int n = parseWithMessageInt("Ile punktów chcesz dodać: ");
        if (n < 0) n = 0;
        for (int i = 0; i < n; ++i)
            points.add(addPoint());
    }

    public void changePointCoordinate(ArrayList<IPoint> points)
    {
        System.out.println("--MENU--");
        System.out.println("1. Zmień współrzędną x");
        System.out.println("2. Zmień współrzędną y");
        System.out.println("3. Zmień obie współrzędne");
        int option = parseWithMessageInt("Wybierz opcję: ");

        int selected = parseWithMessageInt("Ktory punkt chcesz zmienic: ");
        if (selected > points.size() || selected < 0) exitProgram();
        double x, y;
        switch (option)
        {
            case 1:
                System.out.println("Podaj współrzedną x");
                x = parseWithMessageDouble("x = ");
                points.get(selected).setX(x);
                break;
            case 2:
                System.out.println("Podaj współrzedną y");
                y = parseWithMessageDouble("y = ");
                points.get(selected).setY(y);
                break;
            case 3:
                System.out.println("Podaj współrzedną x");
                x = parseWithMessageDouble("x = ");
                System.out.println("Podaj współrzedną y");
                y = parseWithMessageDouble("y = ");
                points.get(selected).setPoint(new double[]{x, y});
                break;
            default:
                exitProgram();

        }
    }

    public void showPoint(ArrayList<IPoint> points)
    {
        int n = parseWithMessageInt("Który punkt chcesz pokazać: ");
        if (n > points.size() || n < 0) exitProgram();
        System.out.println("P = (" + points.get(n).getX() + "," + points.get(n).getY() + ")");
    }

    public void showPoints(ArrayList<IPoint> points)
    {
        for (int i = 0; i < points.size(); ++i)
        {
            showPoint(points.get(i), i);
        }
    }

    private void showPoint(IPoint point, int n)
    {
        System.out.println("P" + n + " = (" + point.getX() + "," + point.getY() + ")");
    }

    private String showPoint(IPoint point, String description)
    {
        return description + " = (" + point.getX() + "," + point.getY() + ")";
    }

    public void showDistance(ArrayList<IPoint> points)
    {
        System.out.println("Pomiędzy którymi punktami chcesz poznać odlegość: ");
        int n1 = parseWithMessageInt("Pierwszy: ");
        int n2 = parseWithMessageInt("Drugi: ");
        if (n1 > points.size() || n2 > points.size() || n1 < 0 || n2 < 0) exitProgram();
        System.out.println("Odeglosc pomiedzy " + showPoint(points.get(n1), "P1") + ",a " + showPoint(points.get(n2), "P2") + " wynosi: " + points.get(n1).getDistance(points.get(n2)));
    }

    private void checkTriangle(IPoint p1, IPoint p2, IPoint p3)
    {
        double side1 = p1.getDistance(p2);
        double side2 = p2.getDistance(p3);
        double side3 = p3.getDistance(p1);
        double maxSide = Math.max(side1, Math.max(side2, side3));
        double sumOfTwoShorter;
        if (maxSide == side1) sumOfTwoShorter = side2 + side3;
        else if (maxSide == side2) sumOfTwoShorter = side1 + side3;
        else sumOfTwoShorter = side1 + side2;

        if (maxSide < sumOfTwoShorter) return;
        else
        {
            System.out.println("Niestety z tych punktów nie można zbudować trójkąta");
            exitProgram();
        }
    }

    public ITriangle addTriangle(ArrayList<IPoint> points)
    {
        System.out.println("Wybierz trzy punkty trójkąta");
        int n1 = parseWithMessageInt("Pierwszy: ");
        int n2 = parseWithMessageInt("Drugi: ");
        int n3 = parseWithMessageInt("Trzeci: ");
        if (n1 > points.size() || n2 > points.size() || n3 > points.size() || n1 < 0 || n2 < 0 || n3 < 0) exitProgram();
        checkTriangle(points.get(n1), points.get(n2), points.get(n3));
        return new Triangle((Point) points.get(n1), (Point) points.get(n2), (Point) points.get(n3));
    }

    public void showTriangles(ArrayList<ITriangle> triangles, String arg)
    {
        for (ITriangle t : triangles)
        {
            System.out.print("Trójkąt: " + showPoint(t.getPoint(0), "A") + ", " + showPoint(t.getPoint(1), "B") + ", " + showPoint(t.getPoint(2), "C"));
            if (arg.equals("basic")) System.out.println();
            else if (arg.equals("area")) System.out.println(", " + showAreaTriangle(t));
            else exitProgram();
        }
    }

    public void showPerimeterTriangle(ArrayList<ITriangle> triangles)
    {
        int n = parseWithMessageInt("Obwód którego trójkąta obliczyć: ");
        if (n > triangles.size() || n < 0) exitProgram();
        System.out.println("Obwód wynosi: " + triangles.get(n).getPerimeter());
    }

    public void showAreaTriangle(ArrayList<ITriangle> triangles)
    {
        int n = parseWithMessageInt("Pole którego trójkąta obliczyć: ");
        if (n > triangles.size() || n < 0) exitProgram();
        System.out.println("Pole wynosi: " + triangles.get(n).getArea());
    }

    private String showAreaTriangle(ITriangle t)
    {
        return ("Pole wynosi: " + t.getArea());
    }

    public void showHeightTriangle(ArrayList<ITriangle> triangles)
    {
        int n = parseWithMessageInt("Wysokość którego trójkąta obliczyć: ");
        int s = parseWithMessageInt("Na ktory bok ta wysokość ma zostac opuszczona: ");
        if (n > triangles.size() || s > 2 || n < 0 || s < 0) exitProgram();
        System.out.println("Wysokość opuszczona na bok " + s + " wynosi: " + triangles.get(n).getHeight(s));
    }

    public void changePointTriangle(ArrayList<ITriangle> triangles)
    {
        int n = parseWithMessageInt("W którym trójkącie chcesz zmienić punkt: ");
        int p = parseWithMessageInt("Ktory punkt w tym trójkącie chcesz zmienić: ");
        if (n > triangles.size() || p > 2 || n < 0 || p < 0) exitProgram();
        triangles.get(n).setPoint((Point) addPoint(), p);
        checkTriangle(triangles.get(n).getPoint(0), triangles.get(n).getPoint(1), triangles.get(n).getPoint(2));
    }

    public void sortTriangleByArea(ArrayList<ITriangle> triangles)
    {
        triangles.sort(Comparator.comparing(ITriangle::getArea));
        System.out.println("Tabela trójkątów została posortowana według pola powierzchni");
    }

    private void checkQuadrangle(IPoint p1, IPoint p2, IPoint p3, IPoint p4)
    {
        if (p1.getDistance(p2) != 0 && p1.getDistance(p3) != 0 && p1.getDistance(p4) != 0 && p2.getDistance(p3) != 0 && p2.getDistance(p4) != 0 && p3.getDistance(p4) != 0)
            return;
        else
        {
            System.out.println("Niestety z tych punktów nie można zbudować czworokąta");
            exitProgram();
        }
    }

    public IQuadrangle addQuadrangle(ArrayList<IPoint> points)
    {
        System.out.println("Wybierz cztery punkty czworokąta");
        int n1 = parseWithMessageInt("Pierwszy: ");
        int n2 = parseWithMessageInt("Drugi: ");
        int n3 = parseWithMessageInt("Trzeci: ");
        int n4 = parseWithMessageInt("Czwarty: ");
        if (n1 > points.size() || n2 > points.size() || n3 > points.size() || n4 > points.size() || n1 < 0 || n2 < 0 || n3 < 0 || n4 < 0)
            exitProgram();
        checkQuadrangle(points.get(n1), points.get(n2), points.get(n3), points.get(n4));
        return new Quadrangle((Point) points.get(n1), (Point) points.get(n2), (Point) points.get(n3), (Point) points.get(n4));
    }

    public void showQuadrangles(ArrayList<IQuadrangle> quadrangles, String arg)
    {
        for (IQuadrangle q : quadrangles)
        {
            System.out.print("Czworokąt: " + showPoint(q.getPoint(0), "A") + ", " + showPoint(q.getPoint(1), "B") + ", " + showPoint(q.getPoint(2), "C") + ", " + showPoint(q.getPoint(3), "D"));
            if (arg.equals("basic")) System.out.println();
            else if (arg.equals("area")) System.out.println(", " + showAreaQuadrangle(q));
            else exitProgram();
        }
    }

    public void showPerimeterQuadrangle(ArrayList<IQuadrangle> quadrangles)
    {
        int n = parseWithMessageInt("Obwód którego czworokąta obliczyć: ");
        if (n > quadrangles.size() || n < 0) exitProgram();
        System.out.println("Obwód wynosi: " + quadrangles.get(n).getPerimeter());
    }

    public void showAreaQuadrangle(ArrayList<IQuadrangle> quadrangles)
    {
        int n = parseWithMessageInt("Pole którego czworokąta obliczyć: ");
        if (n > quadrangles.size() || n < 0) exitProgram();
        System.out.println("Pole wynosi: " + quadrangles.get(n).getArea());
    }

    private String showAreaQuadrangle(IQuadrangle q)
    {
        return ("Pole wynosi: " + q.getArea());
    }

    public void showDiagonalQuadrangle(ArrayList<IQuadrangle> quadrangles)
    {
        int n = parseWithMessageInt("Przekątną którego czworokąta obliczyć: ");
        if (n > quadrangles.size() || n < 0) exitProgram();
        System.out.println("Długość pierwszej przekątej wynosi: " + quadrangles.get(n).getDiagonal(0));
        System.out.println("Długość drugiej przekątej wynosi: " + quadrangles.get(n).getDiagonal(1));
    }

    public void changePointQuadrangle(ArrayList<IQuadrangle> quadrangles)
    {
        int n = parseWithMessageInt("W którym czworokącie chcesz zmienić punkt: ");
        int p = parseWithMessageInt("Ktory punkt w tym czworokącie chcesz zmienić: ");
        if (n > quadrangles.size() || p > 3 || n < 0 || p < 0) exitProgram();
        checkQuadrangle(quadrangles.get(n).getPoint(0), quadrangles.get(n).getPoint(1), quadrangles.get(n).getPoint(2), quadrangles.get(n).getPoint(3));
        quadrangles.get(n).setPoint((Point) addPoint(), p);
    }

    public void sortQuadrangleByArea(ArrayList<IQuadrangle> quadrangles)
    {
        quadrangles.sort(Comparator.comparing(IQuadrangle::getArea));
        System.out.println("Tabela czworokątów została posortowana według pola powierzchni");
    }

    private int parseWithMessageInt(String label)
    {
        System.out.print(label);
        int result;
        try
        {
            result = Integer.parseInt(sc.nextLine());
        } catch (Exception e)
        {
            System.err.println("Wprowadzono niepoprawne dane!");
            System.out.println();
            result = parseWithMessageInt(label);
        }
        return result;
    }

    private double parseWithMessageDouble(String label)
    {
        System.out.print(label);
        double result;
        try
        {
            result = Double.parseDouble(sc.nextLine());
        } catch (Exception e)
        {
            System.err.println("Wprowadzono niepoprawne dane!");
            System.out.println();
            result = parseWithMessageDouble(label);
        }
        return result;
    }

    private void exitProgram()
    {
        System.out.println("Niedozwolona operacja!");
        System.out.println("Następuję opuszczenie programu");
        System.out.print("Naciśnij jakikowiek klawiesz aby wyjść: ");
        sc.nextLine();
        System.exit(1);
    }
}