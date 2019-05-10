import java.io.File;

public class Main
{
    public static void main(String[] args)
    {
        int[] dimensions = {1,2,3};
        CubeGenerator myCube = new CubeGenerator(dimensions);
        myCube.toMatrix(dimensions);
        myCube.printMatrix(myCube.toMatrix(dimensions));
    }

    private File FileCreator(String geometryStlData)
    {
        return null;
    }
    private void cmdMenu(){};
}
