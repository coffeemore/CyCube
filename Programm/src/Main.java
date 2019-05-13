import java.io.File;

public class Main
{
    public static void main(String[] args)
    {
        int[] dimensions = {5,5,5};
        CubeGenerator myCube = new CubeGenerator(dimensions);
        System.out.println(myCube.createCube(dimensions));
    }

    /**
     * Erzeugt Stl Datei aus den Resultaten der Geometry Klassen
     * @param geometryStlData
     * @return File
     * @author ggf. File als Seiteneffekt erstellen
     */
    private File FileCreator(String geometryStlData)
    {
        return null;
    }

    /**
     * Menue-Dialog als Ausgabe in Console
     */
    private void cmdMenu(){};
}
