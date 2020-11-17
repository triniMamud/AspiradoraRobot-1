

public class Suelo {
    private boolean tieneObstaculo;
    private boolean estaLimpio;
    private boolean esBorde;

    public Suelo (){
        this.tieneObstaculo = false;
        this.estaLimpio = false;
        this.esBorde = false;
    }

    public boolean getEsBorde() {
        return esBorde;
    }

    public void setEsBorde(boolean esBorde) {
        this.esBorde = esBorde;
    }

    public boolean getTieneObstaculo() {
        return tieneObstaculo;
    }

    public void setTieneObstaculo(boolean tieneObstaculo) {
        this.tieneObstaculo = tieneObstaculo;
    }

    public boolean getEstaLimpio() {
        return estaLimpio;
    }

    public void setEstaLimpio(boolean estaLimpio) {
        this.estaLimpio = estaLimpio;
    }
}
