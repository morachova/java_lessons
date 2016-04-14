package ua.com.morachova.pft.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance() {
    Point a = new Point(4.2, 9.3);
    Point b = new Point(5.9, 10.0);

    Assert.assertEquals((Point.distance(a,b)), 1.5491933384829666);
  }
}
