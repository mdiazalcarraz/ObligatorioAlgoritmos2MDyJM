package TADs;

public interface ILista<T> {
    void insertar(T dato);

    int largo();

    boolean existe(T dato);

    T recuperar(T dato);

    boolean esVacia();

    boolean esLlena();

    void imprimirDatos(NodoLista<T> nodo);
}
