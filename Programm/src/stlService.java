public class stlService
{
    /**
     *
     * @param rowA Angabe des ersten Vektors
     * @param rowB Angabe des zweiten Vektors
     * @param rowC Angabe des dritten Vektors
     * @param matrix Daten gespeichert in 2d-Array
     * @return ein Stl Eintrag
     */
    public static String toStlEntry(int rowA, int rowB, int rowC, double[][] matrix)
    {
        double[] koArrayA = getRow(rowA,matrix);
        double[] koArrayB = getRow(rowB,matrix);
        double[] koArrayC = getRow(rowC,matrix);
        //StringBuilder initialisieren
        StringBuilder mySB = new StringBuilder();
        mySB.append("facet normal ").append(getNormal(koArrayA,koArrayB,koArrayC)).append("\n");
        mySB.append("\touter loop\n");
        mySB.append("\t\tvertex ").append(getArrayElAsString(koArrayA)).append("\n");
        mySB.append("\t\tvertex ").append(getArrayElAsString(koArrayB)).append("\n");
        mySB.append("\t\tvertex ").append(getArrayElAsString(koArrayC)).append("\n");
        mySB.append("\tendloop\n");
        mySB.append("endfacet\n");

        //Stringobjekt als Ergebnis packen
        String stlEntry = mySB.toString();
        return stlEntry;
    }

    /**
     *
     * @param row zeile auswaehlen
     * @param matrix Daten gespeichert aus 2d-Array
     * @return array der koordinaten
     */
    private static double[] getRow(int row, double[][] matrix)
    {
        double[] koordinaten = new double[3];
        for (int i = 0; i < 3; i++)
        {
            koordinaten[i] = matrix[row][i];
            System.out.println(matrix[row][i]);
        }
        return koordinaten;
    }

    /**
     *
     * @param array wird konvertiert in stl freundliche ausgabe
     * @return Zeichenkette fuer eintrag in stl fileformat
     */
    private static String getArrayElAsString(double[] array)
    {
        String s ="";
        for ( double element : array)
        {
            s+=element+" ";
        }
        return s;
    }

    private static String getNormal(double[] koArrayA, double[] koArrayB, double[] koArrayC)
    {
        if (getArrayElAsString(koArrayA).equals("0.0 0.0 0.0 "))
        {
            return getKreuzprod(koArrayB, koArrayC);
        }
        else if (getArrayElAsString(koArrayB).equals("0.0 0.0 0.0 "))
        {
            return getKreuzprod(koArrayA, koArrayC);
        }
        else {
            return getKreuzprod(koArrayA, koArrayB);
        }
    }

    private static String getKreuzprod(double[] u, double[] t)
    {
        double[] kProd =
                {
                        u[1]*t[2]-u[2]*t[1],
                        u[2]*t[0]-u[1]*t[2],
                        u[0]*t[1]-u[1]*t[0],
                };
        return getArrayElAsString(kProd);
    }


    /**
     * Einfache ausgabe der Koordinaten.
     * @param matrixToPrint
     */
    public static void printMatrix(double[][] matrixToPrint)
    {
        for (double[] matrixZeile: matrixToPrint)
        {
            for (double element: matrixZeile)
            {
                System.out.print(element+" ");
            }
            System.out.print("\n");
        }
    }
}
