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
    public static String toStlEntry(int rowA, int rowB, int rowC, int[][] matrix)
    {
        int[] koArrayA = getRow(rowA,matrix);
        int[] koArrayB = getRow(rowB,matrix);
        int[] koArrayC = getRow(rowC,matrix);
        //StringBuilder initialisieren
        StringBuilder mySB = new StringBuilder();
        mySB.append("facet normal ").append("NORMALE").append("\n");
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
    private static int[] getRow(int row, int[][] matrix)
    {
        int[] koordinaten = new int[3];
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
    private static String getArrayElAsString(int[] array)
    {
        String s ="";
        for ( int element : array)
        {
            s+=element+" ";
        }
        return s;
    }
}
