import java.util.Scanner;

public class Main {


    public static void main(String[] args){

        int filas = cargarFilas();
        int columnas = cargarColumnas();

        Suelo[][] ambiente= new Suelo[filas][columnas];

        System.out.println(ambiente.length); //3
        System.out.println(ambiente[0].length); //2

    }


    public static int cargarFilas (){
        System.out.print("Ingrese la cantidad de filas: ");
        return Integer.parseInt(readInput());
    }

    public static int cargarColumnas (){
        System.out.print("Ingrese la cantidad de columnas: ");

        return Integer.parseInt(readInput());
    }



    //Inputs
    public static String readInput (){
        Scanner readInput = new Scanner(System.in);

        return readInput.nextLine();
    }
}
