package TADs;

public class ABB<T extends Comparable<T>> implements IABB<T> {

    protected NodoABB<T> raiz;

    @Override
    public void insertar(T dato) {
        if (raiz == null)
            raiz = new NodoABB<>(dato);
        else
            insertar(raiz, dato);
    }

    private void insertar(NodoABB<T> nodo, T dato) {
        if (nodo.dato.compareTo(dato) > 0) {
            if (nodo.izq == null)
                nodo.izq = new NodoABB<>(dato);
            else
                insertar(nodo.izq, dato);
        } else if (nodo.dato.compareTo(dato) < 0) {
            if (nodo.der == null)
                nodo.der = new NodoABB<>(dato);
            else
                insertar(nodo.der, dato);
        }
    }

    @Override
    public boolean pertenece(T dato) {
        return pertenece(raiz, dato);
    }

    private boolean pertenece(NodoABB<T> nodo, T dato) {
        if (nodo != null) {
            if (nodo.dato.equals(dato)) {
                return true;
            } else if (nodo.dato.compareTo(dato) > 0) {
                return pertenece(nodo.izq, dato);
            } else if (nodo.dato.compareTo(dato) < 0) {
                return pertenece(nodo.der, dato);
            }
        }
        return false;
    }

    private int altura(NodoABB<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(altura(nodo.izq), altura(nodo.der));  // Calcula la altura del árbol
    }

    @Override
    public T buscar(T dato) {
        return buscar(raiz, dato);
    }

    private T buscar(NodoABB<T> nodo, T dato) {
        if (nodo != null) {
            if (nodo.dato.equals(dato)) {
                return nodo.dato;
            } else if (nodo.dato.compareTo(dato) > 0) {
                return buscar(nodo.izq, dato);
            } else if (nodo.dato.compareTo(dato) < 0) {
                return buscar(nodo.der, dato);
            }
        }
        return null;
    }

    @Override
    public void listarAscendente() {
        listarAscendente(raiz);

    }

    private void listarAscendente(NodoABB<T> nodo) {
        if (nodo != null) {
            listarAscendente(nodo.izq);
            System.out.println(" " + nodo.dato + " ");
            listarAscendente(nodo.der);
        }
    }

    @Override
    public void listarDescendente() {
        listarDescendente(raiz);
    }

    private void listarDescendente(NodoABB<T> nodo) {
        if (nodo != null) {
            listarDescendente(nodo.der);
            System.out.println(" " + nodo.dato + " ");
            listarDescendente(nodo.izq);
        }
    }

    @Override
    public String listarDescendenteString() {
        return listarDescendenteString(raiz);
    }

    private String listarDescendenteString(NodoABB<T> nodo) {
        if (nodo != null) {
            return listarDescendenteString(nodo.der) + "|" + nodo.dato + "|" + listarDescendenteString(nodo.izq);
        }
        return "";
    }

//    public T borrarMinimo() {
//        if (raiz.izq == null) {
//            raiz = raiz.der;
//            return raiz.dato;
//        } else {
//            return borrarMinimo(raiz);
//        }
//    }
//
//    private T borrarMinimo(NodoABB<T> nodo) {
//        if (nodo.izq.izq == null) {
//            T borrado = nodo.izq.dato;
//            nodo.izq = nodo.izq.der;
//            return borrado;
//        } else {
//            return borrarMinimo(nodo.izq);
//        }
//    }


    @Override
    public Lista<T> listarElementosAsc(){
        Lista<T> elementos = new Lista<T>();
        listarElementosAsc(elementos,raiz);
        return elementos;
    }

    private void listarElementosAsc(Lista<T> elementos, NodoABB<T> nodo) {
        if(nodo!=null) {
            listarElementosAsc(elementos, nodo.der);
            elementos.insertar(nodo.dato);
            listarElementosAsc(elementos, nodo.izq);
        }
    }

    @Override
    public void imprimirNivel(int k){
        imprimirNivel(raiz,0,k);
    }

    private void imprimirNivel(NodoABB<T> nodo, int nivel, int k){
        if(nodo!=null){
            imprimirNivel(nodo.izq,nivel+1,k);
            if(nivel==k){
                System.out.println(nodo.dato);
            }
            imprimirNivel(nodo.der,nivel+1,k);
        }
    }


//    public void imprimirPorNiveles() {
//        int altura = altura(raiz);
//        for (int k = 0; k < altura; k++) {
//            imprimirPorNivel(raiz, 0, k);
//            System.out.println();
//        }
//    }
//
//    private void imprimirPorNivel(NodoABB<T> nodo, int nivel, int k) {
//        if (nodo != null) {
//            imprimirNivel(nodo.izq, nivel + 1, k);
//
//            if (nivel == k) {
//                System.out.print(nodo.dato + " ");
//            }
//
//            imprimirNivel(nodo.der, nivel + 1, k);
//        }
//    }
//
//    public int imprimirContadorNivel(int k){
//        return imprimirContadorNivel(raiz,0,k);
//    }
//
//    private int imprimirContadorNivel(NodoABB<T> nodo, int nivel, int k){
//        if (nodo == null) {
//            return 0; // Si el nodo es nulo, no hay nada que contar
//        }
//
//        if (nivel == k) {
//            // Si estamos en el nivel k, contamos el nodo actual
//            return 1;
//        }
//
//        // Recursivamente contamos en los subárboles izquierdo y derecho, incrementando el nivel
//        return imprimirContadorNivel(nodo.izq, nivel + 1, k) + imprimirContadorNivel(nodo.der, nivel + 1, k);
//    }
//
//    public void imprimirElementosMayoresDelNivel(int nivel,int k){
//        imprimirElementosMayoresDelNivel(raiz,0,nivel,k);
//    }
//
//    private void imprimirElementosMayoresDelNivel(NodoABB<Integer> nodo, int nivelAct, int nivel, int k){
//        if(nodo!=null){
//            imprimirElementosMayoresDelNivel(nodo.izq,nivelAct+1, nivel,k);
//            if(nivelAct==nivel && nodo.dato>k){
//                System.out.println(nodo.dato);
//            }
//            imprimirElementosMayoresDelNivel(nodo.der,nivelAct+1, nivel,k);
//        }
//    }


}
