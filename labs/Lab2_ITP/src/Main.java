import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //Point2d myPoint2d = new Point2d();
        //Point2d myOtherPoint2d = new Point2d(5 ,3);
        //Point2d aThirdPoint2d = new Point2d();

        //Point3d myPoint3d = new Point3d();
        //Point3d myOtherPoint3d = new Point3d(3, 9, 6);
        //Point3d aThirdPoint3d = new Point3d();

        //System.out.println(myPoint2d.getX());
        //System.out.println(myPoint2d.getY());
        //myPoint2d.setX(3);
        //myPoint2d.setY(8);
        //System.out.println(myPoint2d.getX());
        //System.out.println(myPoint2d.getY());

        //System.out.println(myOtherPoint3d.getX());
        //System.out.println(myOtherPoint3d.getY());
        //System.out.println(myOtherPoint3d.getZ());
        //myOtherPoint3d.setX(5);
        //myOtherPoint3d.setY(4);
        //myOtherPoint3d.setZ(8);
        //System.out.println(myOtherPoint3d.getX());
        //System.out.println(myOtherPoint3d.getY());
        //System.out.println(myOtherPoint3d.getZ());

        Ball myBall = new Ball();
        myBall.allInfo();
        System.out.println(myBall.getRadius());
        myBall.setColor("голубой");
        System.out.println(myBall.getColor());
        myBall.volume();
        myBall.surfaceArea();
        GeometricFigure.event("шар");
        GeometricFigure.event(20);

        Cylinder firstCylinder = new Cylinder("зеленый", "цилиндр", 15, 10);
        firstCylinder.allInfo();
        firstCylinder.volume();
        firstCylinder.surfaceArea();

        Parallelepiped parallelepiped = new Parallelepiped();
        parallelepiped.setColor("фиолетовый");
        parallelepiped.allInfo();
        parallelepiped.volume();
        parallelepiped.surfaceArea();

        System.out.println(GeometricFigure.getFigureCount());
    }
}