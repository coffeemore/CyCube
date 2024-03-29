public class CubeGenerator
{
    /**
     * Klasse zum Erstellen von Quader-Objekten als stlFile
     */

    /**
     * Konstruktor
     */
    public CubeGenerator()
    {
    }

    /***
     * Erzeugt STL Informationen aus den Maßen des Quaders
     * @param dimensions
     * @return Stl String
     */
    public String createCube(int[] dimensions)
    {
        String stlResult="";
        //Matrix aus dimensions in Punkte des Quaders konvertieren
        double[][] cubePoints = toMatrix(dimensions);
        //Unten
        stlResult += stlService.toStlEntry(0,1,2,cubePoints);
        stlResult += stlService.toStlEntry(0,2,3,cubePoints);
        //Oben
        stlResult += stlService.toStlEntry(4,5,6,cubePoints);
        stlResult += stlService.toStlEntry(4,6,7,cubePoints);
        //Innen
        stlResult += stlService.toStlEntry(0,3,4,cubePoints);
        stlResult += stlService.toStlEntry(3,4,7,cubePoints);
        //Rechts
        stlResult += stlService.toStlEntry(1,2,5,cubePoints);
        stlResult += stlService.toStlEntry(2,5,6,cubePoints);
        //Vorn
        stlResult += stlService.toStlEntry(0,1,4,cubePoints);
        stlResult += stlService.toStlEntry(1,4,5,cubePoints);
        //Hint
        stlResult += stlService.toStlEntry(2,3,6,cubePoints);
        stlResult += stlService.toStlEntry(3,6,7,cubePoints);
        return stlResult;
    }

    /**
     *
     * @param dimensions Maße des Quaders
     * @return Matrix mit 8 Eckpunkten des Quaders als x,y,z Koordinaten
     */
    public double[][] toMatrix(int[] dimensions)
    {
        double [][] resultMatrix;
        int x = dimensions[0];
        int y = dimensions[1];
        int z = dimensions[2];
        resultMatrix = new double[][] {
                {0.0, 0.0, 0.0},
                {  x, 0.0, 0.0},
                {  x,   y, 0.0},
                {0.0,   y, 0.0},
                {0.0, 0.0,   z},
                {  x, 0.0,   z},
                {  x,   y,   z},
                {0.0,   y,   z}
        };
        return resultMatrix;
    }
}
