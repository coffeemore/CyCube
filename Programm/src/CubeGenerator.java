public class CubeGenerator
{
    private int[] dimensions;

    public CubeGenerator(int[] dimensions)
    {
        this.dimensions = dimensions;
    }

    public String createCube(int[] dimensions)
    {
        String stlResult = "";

        return stlResult;
    }

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

    public void printMatrix(int[][] matrixToPrint)
    {
        for (int[] matrixZeile: matrixToPrint)
        {
            for (int element: matrixZeile)
            {
                System.out.print(element);
            }
            System.out.print(";\n");
        }
    }
}
