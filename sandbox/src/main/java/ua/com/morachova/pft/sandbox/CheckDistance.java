package ua.com.morachova.pft.sandbox;
import static ua.com.morachova.pft.sandbox.Point.distance;

public class CheckDistance {
  public static void main(String[] args){
    Point p1 = new Point();
    Point p2 = new Point();
    p1.x=5.0;
    p1.y=9.0;
    p2.x=8.0;
    p2.y=12.0;

    distance(p1, p2);
  }
}
