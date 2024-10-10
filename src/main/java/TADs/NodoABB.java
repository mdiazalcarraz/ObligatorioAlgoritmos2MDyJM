package TADs;

public class NodoABB<T> implements INodoABB<T> {
    protected T dato;
    protected NodoABB<T> izq;
    protected NodoABB<T> der;

    public NodoABB(T dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "NodoABB[" + dato + ']';
    }
}
