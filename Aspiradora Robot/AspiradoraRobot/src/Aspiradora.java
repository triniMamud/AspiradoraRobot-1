/*
El TP consiste en el diseño de una aspiradora robot. Básicamente su funcionamiento es recorrer un ambiente y limpiarlo.
Al encontrar obstáculos debe intentar esquivarlos. Ocasionalmente, puede ser que deje de funcionar porque sus cepillos deben ser limpiados.
En esencia, se puede resumir el funcionamiento de la aspiradora a través de los siguientes puntos:
-	Una vez encendida, recorre el ambiente moviéndose  y lo limpia con sus cepillos.
-	Tiene dos cepillos, izquierdo y derecho.
-	Se mueve hacia adelante, hacia atrás, hacia la izquierda,  y hacia la derecha.
-	Si algún cepillo está sucio la aspiradora se apaga e informa el error. Debe manualmente limpiarse y volverla a encender.
-	Tiene dos modos de velocidad: normal y rápido.
        El modo puede cambiarse en todo momento. Con el modo rápido la aspiradora se desplaza con mayor velocidad.
-	Una vez que termina de recorrer el ambiente, se apaga.
-	Si la batería se agota, la aspiradora se apaga e informa el error.
-	Para cargar la batería, simplemente se conecta manualmente a la corriente.
-	Ante la presencia de un obstáculo, debe intentar moverse para ver si es posible esquivarlo. De no ser posible, se apaga e informa el error.

Se debe modelar el ambiente a limpiar, y el funcionamiento de la aspiradora.  Se deben entregar el diagrama de clases,
y 5 diagramas de secuencia para 5 comportamientos específicos a elección.


*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aspiradora {

    final int posEsquivar = 2;
    final int posMover = 1;

    private Cepillo[] cepillos;
    private int velocidad;
    private int bateria;
    private int posicionColumna;
    private int posicionFila;

    public Aspiradora(){
        this.cepillos = new Cepillo[2];
        this.velocidad = 0;
        this.bateria = 100;
        this.posicionColumna = 0;
        this.posicionFila = 0;
    }

    public void inicializarCepillos(Cepillo cepilloIzquierdo, Cepillo cepilloDerecho){
        this.cepillos[0] = cepilloIzquierdo;
        this.cepillos[1] = cepilloDerecho;
    }

    public String determinarSubidas (Suelo[][] ambiente){ //p: par, i: impar
        String baja = "i";
        if (ambiente[0].length %2 == 0){
            baja = "p";
        }

        return baja;
    }

    public boolean limpiar(int posicionFila, int posicionColumna, Suelo[][] ambiente) {
        if (bateria > 0 && cepilloLimpio()){
            ambiente[posicionFila][posicionColumna].setEstaLimpio(true);
        }
        return ambiente[posicionFila][posicionColumna].getEstaLimpio();
    }

    public void mover(int fila, int col, Suelo[][] ambiente) {

        if (!limpiar(posicionFila, posicionColumna, ambiente)){
            System.out.println("ERROR: no se puede seguir limpiando");
        }
        else {
            limpiar(posicionFila, posicionColumna, ambiente);
            if ("p".equals(determinarSubidas(ambiente))) { //BAJO
                if (!ambiente[posicionFila + posEsquivar][posicionColumna].getEsBorde()){
                    if (ambiente[posicionFila + posEsquivar][posicionColumna].getTieneObstaculo()) {
                        mover(posicionFila+posEsquivar, posicionColumna, ambiente);
                    } else {
                        mover(posicionFila+posMover, posicionColumna, ambiente);
                    }
                } else {
                    mover(posicionFila, posicionColumna++, ambiente);
                }

            } else { //SUBO
                if (ambiente[posicionFila + posEsquivar][posicionColumna].getTieneObstaculo()) {
                    posicionFila = posicionFila - posEsquivar;
                } else {
                    posicionFila = posicionFila - posMover;
                }
            }
            //bajarBateria
            //ensuciarCepillos
        }


    }

    public boolean chequearBorde (int fila, int columna, Suelo [][] ambiente){
        return (ambiente[fila][columna].getEsBorde());
    }

    public boolean cepilloLimpio (){
        return (cepillos[0].getEstaLimpio() && cepillos[1].getEstaLimpio());
    }

    public void posicionarEnOrigen (){
        posicionFila = 0;
        posicionColumna = 0;
    }







    //GETTERS Y SETTERS
    public Cepillo[] getCepillos() {
        return cepillos;
    }

    public void setCepillos(Cepillo[] cepillos) {
        this.cepillos = cepillos;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }
}