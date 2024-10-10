package TADs;

public interface INodoLista<T> {
    T getDato();

    NodoLista<T> getSig();

    @Override
    String toString();
}
