package ua.com.morachova.pft.sandbox;
import static ua.com.morachova.pft.sandbox.Point.distance;

public class CheckDistance {
  public static void main(String[] args){
    Point p1 = new Point(5.0, 9.0);
    Point p2 = new Point(8.0, 12.0);
    Point p3 = new Point(1.2, 3.7);
    Point p4 = new Point(7.3, 9.8);

    distance(p1, p2);
    distance(p3, p4);
    distance(p1, p4);
    distance(p4, p2);
  }
}
