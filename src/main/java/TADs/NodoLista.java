package TADs;

public class NodoLista<T> implements INodoLista<T> {
    private T dato;
    private NodoLista<T> sig;

    public NodoLista(T dato, NodoLista<T> sig) {
        this.dato = dato;
        this.sig = sig;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public NodoLista<T> getSig() {
        return sig;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
}
