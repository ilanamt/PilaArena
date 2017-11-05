import java.util.*;

public class PilaArenaOptimizada {


    static int[][] desborde(int[][] matriz, int i, int j){ //método que toma 4 granos de una celda y los reparte en las que lo rodean

        matriz[i][j] -= 4; //se restan 4 granos a la celda
        matriz[i+1][j]++; //se suma 1 grano a la celda de abajo,
        matriz[i][j+1]++; //se suma 1 grano a la celda de la derecha,
        matriz[i-1][j]++; //se suma 1 grano a la celda de arriba,
        matriz[i][j-1]++; //se suma 1 grano a la celda de izquierda,

        return matriz;
    }

    static public void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("Cuantos granos de arena desea en el centro? "); //se pregunta la cantidad inicial de granos de arena

        int N = s.nextInt(); //se ingresa la cantidad de granos N

        //long ti = System.currentTimeMillis();

        double dimaux = Math.sqrt(N);
        int dim = (int) dimaux + 2; //define la dimension de la matriz segun el N
        int centro = dim/2; //define el centro de la matriz

        int[][] matriz = new int[dim][dim]; //se crea la "superficie"
        matriz[centro][centro] = N; //se depositan los N granos al centro

        Pila casillas = new Pila(); //se crea la pila de casillas por desbordar
        casillas.apilar(centro, centro); //se apila el centro

        while(!casillas.estaVacia()){ //mientras la pila no este vacia, se desbordan las casillas guardadas
            int [] indices = casillas.desapilar(); //se desapila la casilla de mas arriba
            desborde(matriz, indices[0], indices[1]); //se desborda esa casilla

            if (matriz[indices[0]][indices[1]] >= 4){ //si a pesar de ser desbordada sigue teniendo mas de 4 granos
                casillas.apilar(indices[0], indices[1]); //se apila de nuevo
            }

            int[] a = new int[2];
            a[0] = indices[0]+1;
            a[1] = indices[1];
            if(matriz[a[0]][a[1]] == 4){ //se revisa si la casilla de abajo necesita ser apilada
                casillas.apilar(a[0], a[1]);
            }

            int[] b = new int[2];
            b[0] = indices[0];
            b[1] = indices[1]+1;
            if(matriz[b[0]][b[1]] == 4){ //se revisa si la casilla de la derecha necesita ser apilada
                casillas.apilar(b[0], b[1]);
            }

            int[] c = new int[2];
            c[0] = indices[0]-1;
            c[1] = indices[1];
            if(matriz[c[0]][c[1]] == 4){ //se revisa si la casilla de arriba necesita ser apilada
                casillas.apilar(c[0], c[1]);
            }

            int[] d = new int[2];
            d[0] = indices[0];
            d[1] = indices[1]-1;
            if(matriz[d[0]][d[1]] == 4){//se revisa si la casilla de la izquierda necesita ser apilada
                casillas.apilar(d[0], d[1]);
            }
        }



        Ventana ventana = new Ventana(dim, "Figura"); //se crea la ventana
        ventana.mostrarMatriz(matriz); //se muestra la ventana

        //long tf = System.currentTimeMillis();
        //long t = tf - ti;
        //System.out.println(t);


    }
}
