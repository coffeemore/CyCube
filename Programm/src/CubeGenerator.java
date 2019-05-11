public class CubeGenerator
{
    /**
     * Klasse zum Erstellen von Quadern
     */
    private int[] dimensions;

    /**
     * Konstruktor
     * @param dimensions
     */
    public CubeGenerator(int[] dimensions)
    {
        this.dimensions = dimensions;
    }

    /***
     * Erzeugt STL Informationen aus den Maßen des Quaders
     * @param dimensions
     * @return Stl String
     */
    public String createCube(int[] dimensions)
    {
        String stlResult = "";
        //Matrix aus dimensions in Punkte des Quaders konvertieren
        int[][] cubePoints = toMatrix(dimensions);

        //Rueckgabe der Stl Datei
        return stlResult;
    }

    /**
     *
     * @param dimensions Maße des Quaders
     * @return Matrix mit 8 Eckpunkten des Quaders als x,y,z Koordinaten
     */
    public int[][] toMatrix(int[] dimensions)
    {
        int [][] resultMatrix;
        int x = dimensions[0];
        int y = dimensions[1];
        int z = dimensions[2];
        resultMatrix = new int[][] {
                {0, 0, 0},
                {x, 0, 0},
                {x, y, 0},
                {0, y, 0},
                {0, 0, z},
                {x, 0, z},
                {x, y, z},
                {0, y, z}
        };
        return resultMatrix;
    }

    /**
     * Einfache ausgabe der Koordinaten.
     * @param matrixToPrint
     */
    public void printMatrix(int[][] matrixToPrint)
    {
        for (int[] matrixZeile: matrixToPrint)
        {
            for (int element: matrixZeile)
            {
                System.out.print(element);
            }
            System.out.print("\n");
        }
    }
}
