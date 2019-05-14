import java.io.File;

public class Main
{
    public static void main(String[] args)
    {
        //Beispiel Cube
        int[] dimensions = {5,5,5};
        CubeGenerator myCube = new CubeGenerator(dimensions);
        System.out.println(myCube.createCube(dimensions));

        //Beispiel Cylinder
        CylinderGenerator myCylinder = new CylinderGenerator(2, 10);
        System.out.println(myCylinder.createCylinder(2,5,6));

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
