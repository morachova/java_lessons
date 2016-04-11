package ua.com.morachova.pft.sandbox;

public class Point {
  double x;
  double y;
  static double d;



  public static double distance(Point p1, Point p2){
    d = Math.sqrt((p2.x - p1.x) + (p2.y - p1.y));
    System.out.println(d);
    return d;
  }

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
