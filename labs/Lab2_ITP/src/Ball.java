public class Ball extends GeometricFigure {
    private final int radius;
    public Ball (String c, String n, int h) {
        super (c, n, h);
        radius = h / 2;
    }

    public Ball () {
        this ("белый", "шар", 10);
    }

    public int getRadius () {
        return radius;
    }

    @Override
    public void volume() {
        double volume = (double) 4/3 * 3.14 * Math.pow((double) getRadius(), 3);
        System.out.println(Math.round(volume));
    }

    @Override
    public void surfaceArea() {
        double area = 4 * 3.14 * Math.pow((double) getRadius(), 2);
        System.out.println(Math.round(area));
    }
}
