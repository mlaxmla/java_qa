package pl.stqa.mla.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static pl.stqa.mla.sandbox.Point.distanceOld;

public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(0,0);
    Point p2 = new Point(4,0);
    Assert.assertEquals(distanceOld(p1,p2), 4);
    Point p3 = new Point(0,4);
    Assert.assertEquals(distanceOld(p1,p3), 4);
    Point p4 = new Point(4,4);
    Assert.assertEquals(distanceOld(p1,p4), Math.sqrt(Math.pow(p4.y-p1.y,2) + Math.pow(p4.x-p1.x,2)));
    Assert.assertEquals(p1.distance_2(p2), 4);
    Assert.assertEquals(p1.distance_2(p3), 4);
  }

}


