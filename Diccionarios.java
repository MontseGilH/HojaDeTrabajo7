import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
/**
 * Ultima modificacion: 31/03/2022
 * 
 * Clase que controla los diccionarios
 * @file Diccionarios.java
 * @author Montserrat Gil
 * @author Gabriela Archila
 */
public class Diccionarios {

    /**
     * Obtiene el diccionario de una lengua especifica
     * @param archivo
     * @param lengua
     * @return diccionario
     * @throws Exception
     */
    public BinarySearchTree<Association<String,String []>> diccionario(String archivo, String lengua) throws Exception{
        BinarySearchTree<Association<String,String []>> dic = new BinarySearchTree<Association<String,String []>>();
        ArrayList<String> lineas = new ArrayList<>();
        try{
            File file = new File(archivo);
            Scanner s = new Scanner(file);
            while (s.hasNextLine()){
                lineas.add(s.nextLine());
            }
            s.close();
        } catch (Exception e){
            throw new Exception("Error al leer el archivo");
        }
        
        if (lengua.equalsIgnoreCase("english")){
            for (String s:lineas){
                String [] items = s.toLowerCase().split(",");
                dic.add(new Association(items[0],items));
            }
        } else if (lengua.equalsIgnoreCase("spanish")){
            for (String s:lineas){
                String [] items = s.toLowerCase().split(",");
                dic.add(new Association(items[1],items));
            }
        } else if (lengua.equalsIgnoreCase("french")){
            for (String s:lineas){
                String [] items = s.toLowerCase().split(",");
                dic.add(new Association(items[2],items));
            }
        } else {
            throw new Exception("Error -- lengua no encontrda");
        }

        return dic;
    }

    /**
     * Obtiene el diccionario de una lengua especifica
     * @param archivo
     * @param lenguaI lengua de origen
     * @param lenguaF lengua final
     * @param texto texto a traducir
     * @return texto traducido
     * @throws Exception
     */
    public String translate(String lenguaI, String lenguaF,String text, String archivo)throws Exception{
        String [] items = text.toLowerCase().split(" ");
        String oracion = "";
        if (lenguaI.equalsIgnoreCase("english")){
            if (lenguaF.equalsIgnoreCase("spanish")){
                BinarySearchTree<Association<String,String []>> dic = diccionario(archivo,"english");
                Association<String, String []> palabra;
                for (String s:items){
                    palabra = dic.get(new Association(s,null));
                    if (palabra == null){
                        oracion+="*"+s+"* ";
                    } else {
                        oracion += palabra.value[1] + " ";

                    }
                }
            } else if (lenguaF.equalsIgnoreCase("french")){
                BinarySearchTree<Association<String,String []>> dic = diccionario(archivo,"english");
                Association<String, String []> palabra;
                for (String s:items){
                    palabra = dic.get(new Association(s,null));
                    if (palabra == null){
                        oracion+="*"+s+"* ";
                    } else {
                        oracion += palabra.value[2]+ " ";
                    }
                }
            } else{
                throw new Exception("Error -- lengua no encontrada");
            }
        } else if (lenguaI.equalsIgnoreCase("spanish")){
            if (lenguaF.equalsIgnoreCase("english")){
                BinarySearchTree<Association<String,String []>> dic = diccionario(archivo,"spanish");
                Association<String, String []> palabra;
                for (String s:items){
                    palabra = dic.get(new Association(s,null));
                    if (palabra == null){
                        oracion+="*"+s+"* ";
                    } else {
                        oracion += palabra.value[0]+ " ";
                    }
                }
            } else if (lenguaF.equalsIgnoreCase("french")){
                BinarySearchTree<Association<String,String []>> dic = diccionario(archivo,"spanish");
                Association<String, String []> palabra;
                for (String s:items){
                    palabra = dic.get(new Association(s,null));
                    if (palabra == null){
                        oracion+="*"+s+"* ";
                    } else {
                        oracion += palabra.value[2]+ " ";
                    }
                }
            } else{
                throw new Exception("Error -- lengua no encontrada");
            }
        } else if (lenguaI.equalsIgnoreCase("french")){
            if (lenguaF.equalsIgnoreCase("spanish")){
                BinarySearchTree<Association<String,String []>> dic = diccionario(archivo,"french");
                Association<String, String []> palabra;
                for (String s:items){
                    palabra = dic.get(new Association(s,null));
                    if (palabra == null){
                        oracion+="*"+s+"* ";
                    } else {
                        oracion += palabra.value[1]+ " ";
                    }
                }
            } else if (lenguaF.equalsIgnoreCase("english")){
                BinarySearchTree<Association<String,String []>> dic = diccionario(archivo,"french");
                Association<String, String []> palabra;
                for (String s:items){
                    palabra = dic.get(new Association(s,null));
                    if (palabra == null){
                        oracion+="*"+s+"* ";
                    } else {
                        oracion += palabra.value[0]+ " ";
                    }
                }
            } else{
                throw new Exception("Error -- lengua no encontrada");
            }
        }
        return oracion;
    }


    /**
     * Imprime diccionario in order
     * @param archivo
     * @param lengua
     * @return Diccionario in order
     * @throws Exception
     */
    public String inOrderDic(String lengua, String archivo)throws Exception{
        return diccionario(archivo,lengua).toStringOrder();
    }

    
}
