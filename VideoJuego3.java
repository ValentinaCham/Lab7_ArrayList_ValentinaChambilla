package lab7_fp2_valentinachambilla;


import java.util.*;


public class VideoJuego3 {
    public static void main(String[] args) {
        int cantidad1, cantidad2;
        //Inference diamond
        ArrayList<ArrayList<Soldado>> ListaSol = new ArrayList<>();
        //Inference diamond
        ListaSol.add( new ArrayList<>());
        //Que todos contengan un elemento de la clase soldado
        for (int i=0; i<10;i++)
            for (int j = 0; j<10; j++)
                ListaSol.get(i).add(new Soldado());
        //Inicia el juego
        System.out.println("*********************************JUEGO V. 3*********************************");
        System.out.print("El primer equipo tendrá: ");
        //Determina la cantidad de soldados
        cantidad1 = Aleatorio(10, 1);
        System.out.print("El primer equipo tendrá: ");
        //Determina la cantidad de soldados
        cantidad2 = Aleatorio(10, 1);
        /*
        System.out.println(cantidad + " SOLDADOS.");
        if (cantidad>5)
            System.out.println("QUE SUERTE OuO");
        else
            System.out.println("Bueno..., tu suerte quiza estará en otro lado UwU");
        */
        System.out.println("Se estan generando los soldados ~~");
        //Generación de Soldados
        GenerarSoldados(ListaSol, cantidad1, 1);
        GenerarSoldados(ListaSol, cantidad2, 2);
        //Mostrar Matriz Bidimensional
        mostrarMatrizDeSoldados(ListaSol);
        //Mostrar Soldado con más vida
        mostrarSoldadoMayorVida(ListaSol);
        //Promedio de los puntos de Vida
        mostrarPromedioYNivelVida(ListaSol, cantidad);
        
        Soldado[] SoldadoOrd = new Soldado[cantidad];
        SoldadoOrd = crearUnidimensional(ListaSol, cantidad);
        //mostrar en Orden de creación
        mostrarSoldadosOrd(SoldadoOrd);
        ordenarPorPuntosBurbuja(SoldadoOrd);
        mostrarSoldadosOrd(SoldadoOrd);
        ordenarPorPuntosSeleccion(SoldadoOrd);
        mostrarSoldadosOrd(SoldadoOrd);
    }
    
    public static int Aleatorio(int Mayor, int Menor){
        Random aleatorio = new Random();
        
        int num = aleatorio.nextInt(Mayor-Menor+1)+Menor;
        return num;
    }
    
    public static void GenerarSoldados(ArrayList<> ListaSol, int cantidad, int equi){
        String nombre="";
        int vida=0,fila=0,columna=0;
        //Generar
        for (int i=0; i<cantidad; i++){
            nombre = "Soldado"+equi+"X"+i;
            vida = Aleatorio(5,1);
            while(true){
                fila = Aleatorio(9,0);
                columna = Aleatorio(9,0);
                if(ListaSol.get(fila).get(columna).getNom().equalsIgnoreCase("")){
                    ListaSol.get(fila).get(columna).setSoldado(nombre, vida, fila, columna);
                    break;
                }
            }
        }
    }
    
    public static void mostrarMatrizDeSoldados(Soldado[][] ListaSol) {
        System.out.println("MOSTRAR MATRIZ BIDIMENSIONAL DE SOLDADOS");
        System.out.printf("\n%6s%1s%11s%1s%11s%1s%11s%1s%11s%1s%11s%1s%11s%1s%11s%1s%11s%1s%11s%1s%11s\n", "  F/C ", "|" , "     A     ","|", "     B     ","|", "     C     ","|",
                "     D     ","|","     E     ","|", "     F     ","|", "     G     ","|", "     H     ","|","     I     ","|","     J     ");
        for (int i=0; i<ListaSol.length;i++){
            //GenerarLineaSuperior
            for(int k=0; k<126; k++){
                System.out.print("-");
            }
            System.out.printf("\n%6s", "  " + (i+1) + "  ");
            for (int j = 0; j < ListaSol[i].length; j++){
                System.out.printf("%1s%11s", "|", ListaSol[i][j].getNom());
            }
            System.out.println();
        }
    }
    
    public static void mostrarSoldadoMayorVida(Soldado[][] ListaSol) {
        System.out.println("\nMOSTRAR SOLDADO CON MAYOR CANTIDAD DE VIDA");
        int mayor = ListaSol[0][0].getPuntoVida();
        for (int i=0; i<ListaSol.length; i++){
            for (int j=0; j<ListaSol[0].length; j++){
                if (mayor<ListaSol[i][j].getPuntoVida())
                    mayor = ListaSol[i][j].getPuntoVida();
            }
        }
        //MOSTRAR LOS SOLDADOS CON LA MAYOR CANTIDAD DE VIDA
        System.out.printf( "%10s%8s%10s%15s\n", "Nombre", "Fila", "Columna","Puntos Vida");
        for (int i=0; i<ListaSol.length; i++){
            for (int j=0; j<ListaSol[0].length; j++){
                if (mayor==ListaSol[i][j].getPuntoVida())
                    System.out.printf( "%10s%8s%10s%15d\n", ListaSol[i][j].getNom(), ListaSol[i][j].getFila(), ListaSol[i][j].getColumna(),ListaSol[i][j].getPuntoVida());
            }
        }
    }
    
    public static void mostrarPromedioYNivelVida(Soldado[][] ListaSol, int num) {
        System.out.println("\nMOSTRAR PROMEDIO DE VIDA");
        double suma=0;
        for (int i=0; i<ListaSol.length; i++){
            for (int j=0; j<ListaSol[0].length; j++){
                suma = suma + ListaSol[i][j].getPuntoVida();
            }
        }
        double promedio = suma/num;
        //MOSTRAR LOS SOLDADOS CON LA MAYOR CANTIDAD DE VIDA
        System.out.println( "EL NIVEL DE VIDA ES: " + suma);
        System.out.println( "EL PROMEDIO DE VIDA ES: " + promedio);
    }
    
    public static Soldado[] crearUnidimensional(Soldado[][] ListaSol, int num) {
        Soldado[] SoldadoOrd = new Soldado[num];
        int indice;
        String name, ulti;
        for (int j = 0; j < SoldadoOrd.length; j++)
            SoldadoOrd[j] = new Soldado();
        for (int i=0; i<ListaSol.length; i++){
            for (int j=0; j<ListaSol[i].length; j++){
                if (!(ListaSol[i][j].getNom()).equalsIgnoreCase("")){
                    name = ListaSol[i][j].getNom();
                    ulti = name.substring(name.length()-1);
                    if(!ulti.equalsIgnoreCase(" ")){
                        indice = Integer.parseInt(ulti);
                        SoldadoOrd[indice] = ListaSol[i][j];
                    }
                }
            }
        }
        return SoldadoOrd;
    }
    
    public static void mostrarSoldadosOrd(Soldado[] ListaSol) {
        System.out.printf( "%5s%10s%8s%10s%15s\n", "Ind." ,"Nombre", "Fila", "Columna","Puntos Vida");
        for (int i=0; i<ListaSol.length; i++){
            System.out.printf( "%5d%10s%8s%10s%15s\n", i, ListaSol[i].getNom(), ListaSol[i].getFila(),ListaSol[i].getColumna(), ListaSol[i].getPuntoVida());
        }
    }
    
    public static void ordenarPorPuntosBurbuja(Soldado[] ListaSol){
        System.out.println("ORDENAR POR PUNTOS: Burbuja");
        for (int i=1; i<ListaSol.length;i++)
            for(int j=0;j<ListaSol.length-i;j++)
                if((ListaSol[j].getPuntoVida())<(ListaSol[j+1].getPuntoVida()))
                    intercambiar(ListaSol, j, j+1);
    }
    
    private static void intercambiar(Soldado[] ListaSol, int i, int j){
        Soldado temp = new Soldado();
        temp = ListaSol[i];
        ListaSol[i] = ListaSol[j];
        ListaSol[j] = temp;
    }
    
    public static void ordenarPorPuntosSeleccion(Soldado[] ListaSol){
        System.out.println("ORDENAR POR PUNTOS: Selección");
        //Encontrar el menor
        Soldado mayor = new Soldado();
        int indice=0;
        for (int i=0; i<ListaSol.length;i++){
            //Determinar el menor
            mayor = ListaSol[i];
            for (int j=i; j<ListaSol.length;i++)
                if (mayor.getPuntoVida()<ListaSol[j].getPuntoVida()){
                    mayor = ListaSol[j];
                    indice = j;
                }
            intercambiar(ListaSol, indice, i);
        }
    }
}
