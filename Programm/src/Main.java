import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        String input = "";
        //Cube
        int x = 0;
        int y = 0;
        int z = 0;
        //Cylinder
        int r = 0;
        int h = 0;
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(System.in));
        while(!input.equals("y") && !input.equals("u"))
        {
            System.out.println("Choose: C[u]be or C[y]linder");
            try {
                input = br.readLine();
            } catch (IOException e) {
                System.out.println("Not a String");
            }
        }
        if (input.equals("u")) //Case: Cube
        {
            System.out.println("Choice : Cube");
            while(x < 1 || x > 500) //Abfangen falscher Formate + Zahlenbereich
            {
                System.out.print("Enter Width (0<x<501): ");
                try {
                    x = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                    System.err.println("Invalid Format!");
                }
            }
            while(y < 1 || y > 500) //Abfangen falscher Formate + Zahlenbereich
            {
                System.out.print("Enter Length (0<y<501): ");
                try {
                    y = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                    System.err.println("Invalid Format!");
                }
            }
            while(z < 1 || z > 500) //Abfangen falscher Formate + Zahlenbereich
            {
                System.out.print("Enter Heigth (0<z<501): ");
                try {
                    z = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                    System.err.println("Invalid Format!");
                }
            }
            int[] dimensions = {x,y,z};
            CubeGenerator myCube = new CubeGenerator(dimensions);
            System.out.println(myCube.createCube(dimensions));
            FileCreator(myCube.createCube(dimensions));
        }
        else //Case: Cylinder
        {
            System.out.println("Choice : Cylinder");
            while(r < 1 || r > 500) //Abfangen falscher Formate + Zahlenbereich
            {
                System.out.print("Enter Radius (0<x<501): ");
                try {
                    r = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                    System.err.println("Invalid Format!");
                }
            }
            while(h < 1 || h > 500) //Abfangen falscher Formate + Zahlenbereich
            {
                System.out.print("Enter Heigth (0<x<501): ");
                try {
                    h = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                    System.err.println("Invalid Format!");
                }
            }
        }

        //Beispiel Cube
        /*int[] dimensions = {5,5,5};
        CubeGenerator myCube = new CubeGenerator(dimensions);
        System.out.println(myCube.createCube(dimensions));
        FileCreator(myCube.createCube(dimensions));*/

        //Beispiel Cylinder
        CylinderGenerator myCylinder = new CylinderGenerator();
        FileCreator(myCylinder.createCylinder(2,5,100));

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
