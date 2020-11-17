import java.util.Scanner;

public class Main {


    public static void main(String[] args){



    }


    public static int cargarFilas (){
        System.out.print("Ingrese la cantidad de filas: ");
        return Integer.parseInt(readInput());
    }

    public static int cargarColumnas (){
        System.out.print("Ingrese la cantidad de columnas: ");

        return Integer.parseInt(readInput());
    }

    public static void cargarAmbiente (){

        Suelo[][] ambiente= new Suelo[cargarFilas()][cargarColumnas()];
        double cantidadSuelo = ambiente.length*ambiente[0].length;

        for (int i = 0; i < Math.random()*cantidadSuelo; i++) {
            ambiente[(int) (Math.random()* ambiente.length)][(int) (Math.random()* (ambiente[0].length))].setTieneObstaculo(true);
        }
    }



    //Inputs
    public static String readInput (){
        Scanner readInput = new Scanner(System.in);

        return readInput.nextLine();
    }
}
