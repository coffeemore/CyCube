public class CylinderGenerator
{
    /**
     * Klasse zum Erstellen von Cylinder-Objekten
     */
    private int radius;
    private int hight;
    private CubeGenerator cubeGenerator; // Nur zum test

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
    public String createCylinder(int radius, int hight, int aufloesung)
    {
        String stlResult = "";
        double [][] kreisUntenMatrix = new double[aufloesung][3];
        for (int i = 0; i < aufloesung; i++)
        {
            double xEintrag, yEintrag, winkel;
            winkel = (2 * Math.PI / (i+1));
            xEintrag = Math.round(Math.cos((i+1) * winkel) * radius);
            yEintrag = Math.round(Math.sin((i+1) * winkel) * radius);
            kreisUntenMatrix[i][0] = xEintrag;
            kreisUntenMatrix[i][1] = yEintrag;
            kreisUntenMatrix[i][2] = 0;
        }
        /*
        double [][] kreisObenMatrix = kreisUntenMatrix;
        for (int i = 0; i < kreisObenMatrix.length; i++)
        {
            kreisObenMatrix[i][2] = hight;
        }
        cubeGenerator.printMatrix(kreisObenMatrix);
        */
        cubeGenerator.printMatrix(kreisUntenMatrix);

        return stlResult;
    }
}
