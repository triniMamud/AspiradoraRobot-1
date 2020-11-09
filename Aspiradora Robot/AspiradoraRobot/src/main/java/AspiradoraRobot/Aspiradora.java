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
package AspiradoraRobot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Aspiradora {
    private ArrayList<Cepillo> cepillos;
    private int velocidad;
    private boolean estaPrendida;
    private int bateria;
    private Map<String, Integer> movimientos;
    private ArrayList<Integer> posicion;
    
    public Aspiradora(){
        this.cepillos=new ArrayList<Cepillo>();
        this.velocidad=0;
        this.estaPrendida=false;
        this.bateria=100;
        this.movimientos = new HashMap<>();
        this.posicion= new ArrayList<Integer>();
    }
    
    public void inicializarCepillos(Cepillo cepilloIzquierdo, Cepillo cepilloDerecho){
         this.cepillos.add(cepilloIzquierdo);
         this.cepillos.add(cepilloDerecho);
    }
    
    public void inicializarMovimientos (){
        this.movimientos.put("Derecha",0);
        this.movimientos.put("Izquierda",0);
        this.movimientos.put("Adelante",0);
        this.movimientos.put("Atras", 0);
    }
    
    public void inicializarPosicion (){
        this.posicion.add(0);
        this.posicion.add(0);
    }
    
      public ArrayList<Cepillo> getCepillos() {
        return cepillos;
    }

    public void setCepillos(ArrayList<Cepillo> cepillos) {
        this.cepillos = cepillos;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isEstaPrendida() {
        return estaPrendida;
    }

    public void setEstaPrendida(boolean estaPrendida) {
        this.estaPrendida = estaPrendida;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public Map<String, Integer> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Map<String, Integer> movimientos) {
        this.movimientos = movimientos;
    }
    
    public void mover(String direccion){
        inicializarMovimientos();
        movimientos.put(direccion, 1);
    }
    
    public void sePuedeMover(ArrayList<ArrayList<Suelo>> ambiente){
        
    }
}
