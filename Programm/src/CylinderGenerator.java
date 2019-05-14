public class CylinderGenerator
{
    /**
     * Klasse zum Erstellen von Cylinder-Objekten als stlFile
     */
    /**
     * Konstruktor
     */
    public CylinderGenerator()
    {
    }
    /**
     * Erzeugt STL Informationen aus den Maßen des Cylinders
     * @param radius r = 2d
     * @param hight Hoehe des zu erzeugenden objektes
     * @param aufloesung Feinheit des Objektes
     * @return stl String
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
        //Alle Eintraege fuer untere Kreisflaeche
        for (int i = 0; i < aufloesung; i++)
        {
            stlResult += stlService.toStlEntryCy(nullPunkt,i, (i+1)%aufloesung,kreisUntenMatrix);
        }
        //Alle Eintraege fuer obere Kreisflaeche
        for (int i = 0; i < aufloesung; i++)
        {
            nullPunkt[2] = hight; //Referenzpunkt auf z setzen
            stlResult += stlService.toStlEntryCy(nullPunkt, i, (i + 1) % aufloesung, kreisObenMatrix);
        }
        //Seitenwaende obere flaeche
        for (int i = 0; i < aufloesung; i++)
        {
            stlResult += stlService.toStlEntryCy(kreisObenMatrix[i],kreisObenMatrix[(i + 1) % aufloesung],kreisUntenMatrix[i]);
        }
        //Seitenwaende untere flaeche
        for (int i = 0; i < aufloesung; i++)
        {
            stlResult += stlService.toStlEntryCy(kreisUntenMatrix[i],kreisUntenMatrix[(i + 1) % aufloesung],kreisObenMatrix[(i + 1) % aufloesung]);
        }
        return stlResult;
    }
}
