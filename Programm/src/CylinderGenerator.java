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

        //Kreisflaeche auf hohe [x,y,0]
        for (int i = 0; i < aufloesung; i++)
        {
            double xEintrag, yEintrag, winkel;
            winkel = (2 * Math.PI / aufloesung);
            xEintrag = (Math.cos((i+1) * winkel) * radius);
            yEintrag = (Math.sin((i+1) * winkel) * radius);
            kreisUntenMatrix[i][0] = xEintrag;
            kreisUntenMatrix[i][1] = yEintrag;
            kreisUntenMatrix[i][2] = 0;
        }
        //Kreisflaeche auf hohe z
        double [][] kreisObenMatrix = new double[aufloesung][3];
        for (int i = 0; i < aufloesung; i++)
        {
            kreisObenMatrix[i][0] = kreisUntenMatrix[i][0];
            kreisObenMatrix[i][1] = kreisUntenMatrix[i][1];
            kreisObenMatrix[i][2] = hight;
        }

        //Ausgangspunkt
        double[] nullPunkt = {0,0,0};

        //Ausgabe in Stl Datei Kreisflaechen
        for (int i = 0; i < aufloesung; i++)
        {
            //Alle Eintraege fuer untere Kreisflaeche
            stlResult += stlService.toStlEntryCy(nullPunkt,i, (i+1)%aufloesung,kreisUntenMatrix);
        }
        for (int i = 0; i < aufloesung; i++)
        {
            //Alle Eintraege fuer obere Kreisflaeche
            nullPunkt[2] = hight;
            stlResult += stlService.toStlEntryCy(nullPunkt, i, (i + 1) % aufloesung, kreisObenMatrix);
        }
        for (int i = 0; i < aufloesung; i++)
        {
            stlResult += stlService.toStlEntryCy(kreisObenMatrix[i],kreisObenMatrix[(i + 1) % aufloesung],kreisUntenMatrix[i]);
        }
        for (int i = 0; i < aufloesung; i++)
        {
            stlResult += stlService.toStlEntryCy(kreisUntenMatrix[i],kreisUntenMatrix[(i + 1) % aufloesung],kreisObenMatrix[(i + 1) % aufloesung]);
        }
        return stlResult;
    }
}
