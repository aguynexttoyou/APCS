class Main {
  public static void main(String[] args) {
  test3();
  }
  public static String pointToString(Point coordinate){
    return "(" + coordinate.x + ", " + coordinate.y + ")";
  }
  public static void test1(){
    Point coordinate = new Point();
    coordinate.x = 1.2;
    coordinate.y = 3.4;
    System.out.println(pointToString(coordinate));
  }
  public static double slope(LineSegment line){
    if(line.ptB.x-line.ptA.x==0)
      return 0;
    return ((line.ptB.y-line.ptA.y)/(line.ptB.x-line.ptA.x));
  }
  public static double length(LineSegment line){
    double x = line.ptB.x-line.ptA.x;
    double y = line.ptB.y-line.ptA.y;
    return Math.pow(x*x + y*y, 0.5);
  }
  public static String lineSegmentToString(LineSegment line){
    return "Line Segment between "  + pointToString(line.ptA) + " and " + pointToString(line.ptB) +  " with slope " + slope(line) + " and length " + length(line); 
  }
  public static void test2(){
    LineSegment line = new LineSegment();
    line.ptA.x = 0;
    line.ptA.y = 1;
    line.ptB.x = 11;
    line.ptB.y = 12;
    System.out.print(lineSegmentToString(line));
  }
  public static double area(Rectangle r){
    return length(r.lineSegAB)*length(r.lineSegBC);
  }
  public static String rectangleToString(Rectangle r){
    r.lineSegAB.ptA = r.ptA;
    r.lineSegAB.ptB = r.ptB;
    r.lineSegBC.ptA = r.ptB;
    r.lineSegBC.ptB = r.ptC;
    r.lineSegCD.ptA = r.ptC;
    r.lineSegCD.ptB = r.ptD;
    r.lineSegAD.ptA = r.ptD;
    r.lineSegAD.ptB = r.ptA;
    return "Rectangle with vertices " + pointToString(r.ptA) + ", " + pointToString(r.ptB) + ", " + pointToString(r.ptC) + ", " + pointToString(r.ptD) + "and area " + area(r);
  }
  public static void test3(){
    Rectangle r = new Rectangle();
    r.ptA.x = 0;
    r.ptA.y = 0;
    r.ptB.x = 0;
    r.ptB.y = 2;
    r.ptC.x = 6;
    r.ptC.y = 2;
    r.ptD.x = 6;
    r.ptD.y = 0;
    shift(r, 2, 3);
    System.out.println(rectangleToString(r));
  }
  public static Rectangle shift(Rectangle r, double h, double k){
    r.ptA.x += h;
    r.ptB.x += h;
    r.ptC.x += h;
    r.ptD.x += h;
    r.ptA.y += k;
    r.ptB.y += k;      
    r.ptC.y += k;   
    r.ptD.y += k;   
    return r;
  }
}