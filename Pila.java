public class Pila {

    private Nodo ultimo;
    private int size;

    private class Nodo{
        int[] elemento;
        Nodo siguiente;

    }

    public Pila() {
        ultimo = null;
        size = 0; //inicialmente la pila está vacía

    }


    public boolean estaVacia() {
        return size == 0;

    }


    public void apilar(int i, int j) {
        int[] a = new int[2];
        a[0] = i;
        a[1] = j;
        if(estaVacia()){
            ultimo = new Nodo();
            ultimo.elemento = a;
            ultimo.siguiente = null;

        }
        else{
            Nodo aux = ultimo;
            ultimo = new Nodo();
            ultimo.elemento = a;
            ultimo.siguiente = aux;
        }

        size = size+1;
    }

    public int[] desapilar() {
        if (!estaVacia()) {
            int[] x = ultimo.elemento;
            if(size == 1){
                ultimo = null;
            }
            else{
                ultimo = ultimo.siguiente;
            }

            size = size -1;
            return x;

        }
        else{
            return null;
        }
    }

}


