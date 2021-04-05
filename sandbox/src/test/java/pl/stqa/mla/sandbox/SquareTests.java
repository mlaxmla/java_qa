package pl.stqa.mla.sandbox;

import org.testng.annotations.Test;
import org.testng.Assert;
import pl.stqa.mla.sandbox.Square;

public class SquareTests {

  @Test
  public void testArea() {
    Square s = new Square(5);
    Assert.assertEquals(s.area(), 25);
  }
}
