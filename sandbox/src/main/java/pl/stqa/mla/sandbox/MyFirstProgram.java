package pl.stqa.mla.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("universe");
    hello("user");
    hello("Alexei");

    Square s = new Square(5);
    System.out.println("Powierzchnia kwadratu o boku " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Powierzchnia prostokąta o bokach " + r.a + " i " + r.b + " = " + r.area());

    double p1x = 1;
    double p1y = 1;
    double p2x = 4;
    double p2y = 4;
    System.out.println(Math.sqrt((p2x - p1x) * (p2x - p1x) + (p2y - p1y) * (p2y - p1y)));

    System.out.println("Odległość między punktami: P1(" + p1x + "," + p1y + ") i P2(" + p2x + "," + p2y + ") - wynosi: " + Math.sqrt((p2x - p1x) * (p2x - p1x) + (p2y - p1y) * (p2y - p1y)));

    Point p1 = new Point(1,1);
    Point p2 = new Point(4,4);
    System.out.println("Odległość między punktami: P1(" + p1.x + "," + p1.y + ") i P2(" + p2.x + "," + p2.y + ") - wynosi: " + p1.distance_2(p2));

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

}