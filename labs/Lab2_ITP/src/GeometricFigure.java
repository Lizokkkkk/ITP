public abstract class GeometricFigure {
    private String color;
    private String name;
    private int height;
    private static int figureCount = 0;

    public GeometricFigure (String c, String n, int h) {
        color = c;
        name = n;
        height = h;
        figureCount++;
    }

    public GeometricFigure () {
        this("белый", "", 10);
    }

    public String getColor () {
        return color;
    }

    public String getName () {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public void setColor (String val) {
        color = val;
    }

    public void setName (String val) {
        name = val;
    }

    public void setHeight (int val) {
        height = val;
    }

    public abstract void volume ();

    public abstract void surfaceArea ();

    public static void event(String name) {
        System.out.println("Вы хотите создать " + name);
    }

    public static void event(int number) {
        System.out.println("Вы хотите создать фигур: " + number);
    }

    public void allInfo () {
        System.out.println("Фигура " + name + " высотой: " + height + ", цвет: " + color);
    }

    public static int getFigureCount() {
        return figureCount;
    }
}
