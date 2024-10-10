package TADs;

public interface IABB<T extends Comparable<T>> {
    void insertar(T dato);

    boolean pertenece(T dato);

    T buscar(T dato);

    void listarAscendente();

    void listarDescendente();

    String listarDescendenteString();

    Lista<T> listarElementosAsc();

    void imprimirNivel(int k);
}
