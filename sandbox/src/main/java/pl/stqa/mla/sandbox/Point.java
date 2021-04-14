package pl.stqa.mla.sandbox;

public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distanceOld(Point p1, Point p2) {
    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
  }

  public double distance_2(Point p2) {
    double kw_x = (p2.x - this.x) * (p2.x - this.x);
    double kw_y = (p2.y - this.y) * (p2.y - this.y);
    return Math.sqrt(kw_x + kw_y);
  }

}
