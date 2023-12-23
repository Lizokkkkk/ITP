public class Parallelepiped extends Cylinder {
    private int length;

    public Parallelepiped (String c, String n, int h, int w, int l) {
        super (c, n, h, w);
        length = l;
    }

    public Parallelepiped () {
        this ("белый", "параллелепипед", 10, 5, 3);
    }

    public int getLength () {
        return length;
    }

    public void setLength (int val) {
        length = val;
    }

    @Override
    public void volume() {
        double volume = getHeight() * getWidth() * getLength();
        System.out.println(Math.round(volume));
    }

    @Override
    public void surfaceArea() {
        double area = 2 * (getHeight() * getWidth() + getHeight() * getLength() + getWidth() * getLength());
        System.out.println(Math.round(area));
    }
}
