public class CylinderGenerator
{
    /**
     * Klasse zum Erstellen von Cylinder-Objekten
     */
    private int radius;
    private int hight;

    /**
     * Konstruktor
     * @param radius
     * @param hight
     */
    public CylinderGenerator(int radius, int hight)
    {
        this.radius = radius;
        this.hight = hight;
    }

    /**
     * Erzeugt STL Informationen aus den Maßen des Cylinders
     * @param radius
     * @param hight
     * @return stl
     */
    public String createCylinder(int radius, int hight)
    {
        String stlResult = "";
        return stlResult;
    }
}
