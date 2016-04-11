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


}
