package pl.stqa.mla.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(0,0);
    Point p2 = new Point(4,0);
    Assert.assertEquals(MyFirstProgram.distance(p1,p2), 4);
    Point p3 = new Point(0,4);
    Assert.assertEquals(MyFirstProgram.distance(p1,p3), 4);
    Point p4 = new Point(4,4);
    Assert.assertEquals(MyFirstProgram.distance(p1,p4), Math.sqrt(Math.pow(p4.y-p1.y,2) + Math.pow(p4.x-p1.x,2)));
  }
}