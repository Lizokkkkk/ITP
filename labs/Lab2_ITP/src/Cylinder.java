public class Cylinder extends GeometricFigure {
     private int width;

     public Cylinder (String c, String n, int h, int w) {
          super (c, n, h);
          width = w;
     }

     public Cylinder () {
          this ("белый", "цилиндр", 10, 5);
     }

     public int getWidth () {
          return width;
     }

     public void setWidth(int val) {
          width = val;
     }

     @Override
     public void volume() {
          double volume = 3.14 * Math.pow((double) getWidth() / 2, 2) * getHeight();
          System.out.println(Math.round(volume));
     }

     @Override
     public void surfaceArea() {
          double area = 2 * 3.14 * getWidth() / 2 * (getHeight() + (double) getWidth() / 2);
          System.out.println(Math.round(area));
     }
}
