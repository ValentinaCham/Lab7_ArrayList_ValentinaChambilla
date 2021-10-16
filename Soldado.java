package lab7_fp2_valentinachambilla;


public class Soldado {
    private String Nom="";
    private int puntoVida=0;
    private int Fila=0;
    private int Columna=0;
    private int Equipo=0;
    //Equipo 0: No pertenece por lo tanto no contiene nada
    //Equipo 1: Primer equipo
    //Equipo 2: Segundo Equipo
    
    public void setSoldado(String nombre, int Vida, int fila, int columna){
        Nom = nombre;
        puntoVida = Vida;
        Fila = fila;
        Columna = columna;
    }
    
    public String getNom(){
        return Nom;
    }
    
    public int getPuntoVida(){
        return puntoVida;
    }
    
    public int getFila(){
        return Fila;
    }
    
    public int getColumna(){
        return Columna;
    }
}
