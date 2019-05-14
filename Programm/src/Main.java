import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        //Beispiel Cube
        int[] dimensions = {5,5,5};
        CubeGenerator myCube = new CubeGenerator(dimensions);
        System.out.println(myCube.createCube(dimensions));
	    FileCreator(myCube.createCube(dimensions));

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
    private static void FileCreator(String geometryStlData)
    {
        File file = new File("./test.stl");

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            bw.write(geometryStlData);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not created \n Error: " + e);
        }

    }

    /**
     * Menue-Dialog als Ausgabe in Console
     */
    private void cmdMenu(){};
}
