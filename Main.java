import java.util.Scanner;
import java.io.File;

/**
 * Ultima modificacion: 31/03/2022
 * 
 * Clase main que interactua con el usuario
 * @file Main.java
 * @author Montserrat Gil
 * @author Gabriela Archila
 */
public class Main {
    public static void main(String[] args){
        Diccionarios dics = new Diccionarios();
        Scanner scan = new Scanner(System.in);
        String fin = "";
        while (!fin.equalsIgnoreCase("3")){
            System.out.println("\nIngrese la acciona a realizar:\n1. Traducir (no olvide ingresar el texto en el archivo de texto)\n2. Ver diccionario\n3. Salir");
            fin = scan.nextLine();
            if (fin.equalsIgnoreCase("1")){
                //traducir
                System.out.println("\nIngrese el idioma de origen del texto");
                String org = scan.nextLine();
                System.out.println("\nIngrese el idioma a traducir");
                String dest = scan.nextLine();
                try {
                    File file = new File("texto.txt");
                    Scanner s = new Scanner(file);
                    while (s.hasNextLine()){
                        System.out.println(dics.translate(org, dest, s.nextLine(), "diccionario.txt"));
                    }
                    s.close();
                    
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            } else if (fin.equalsIgnoreCase("2")){
                System.out.println("\nSeleccione el idioma del que quiera saber contenido (en in order)");
                String idiom = scan.nextLine();
                try {
                    System.out.println(dics.inOrderDic(idiom, "diccionario.txt"));
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            } else if (fin.equalsIgnoreCase("3")){
                System.out.println("\nSaliendo del traductor");
            } else {
                System.out.println("\nOpcion invalida");
            }
        }
        scan.close();
    }
}
