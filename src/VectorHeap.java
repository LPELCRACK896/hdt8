import java.util.Arrays;
import java.util.Vector;

/**
 * @author Luis Gonzalez
 */
public class VectorHeap {
    private int capacidad = 10;
    private int size = 0;
    private Paciente[] cola = new Paciente[capacidad];

    /**
     * @param parentIndex ingresa el indice del padre del cual se desea obtener el hijo izquierdo
     * @return devuelve el indice del hijo izquierdo
     */
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    /**
     * @param parentIndex ingresa el indice del padre del cual se desea obtener el hijo derecho
     * @return devuelve el indeice del hijo derecho
     */
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    /**
     * @param childIndex ingresa el indice el hijo
     * @return devuelve el indice del padre
     */
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    /**
     * @param index ingresa el indice del elemento
     * @return devuelve si tiene un hijo izquiero
     */
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    /**
     * @param index ingresa el indice del elemento
     * @return devuelve si tiene un hijo derecho
     */
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    /**
     * @param index ingresa el indice el elemento
     * @return devuelve si tiene padre
     */
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    /**
     * @param index ingresa el indice del elemento
     * @return devuelve el hijo izquierdo del elemento
     */
    private Paciente leftChild(int index) {
        return cola[getLeftChildIndex(index)];
    }

    /**
     * @param index ingresa el indice del elmento
     * @return devuelve el hijo derecho del elemento
     */
    private Paciente rightChild(int index) {
        return cola[getRightChildIndex(index)];
    }

    /**
     * @param index ingresa el indice del elemento
     * @return devuelve el padre del elemento
     */
    private Paciente parent(int index) {
        return cola[getParentIndex(index)];
    }

    /**
     * @param indexOne ingresa el indice del elemento que sea desea interecambiar
     * @param indexTwo ingresa el indice del segundo elemento que se desea integrar
     */
    private void swap(int indexOne, int indexTwo) {
        Paciente temp = cola[indexOne];
        cola[indexOne] = cola[indexTwo];
        cola[indexTwo] = temp;
    }

    /**
     * se aegura que el array tenga espacio para agregar otro elemento y se aumenta el tamaño de ser necesario
     */
    private void ensureExtraCapacity() {
        if (size == capacidad) {
            cola = Arrays.copyOf(cola, capacidad * 2);
            capacidad *= 2;
        }
    }

    /**
     * @return devuelve el primer paciente de la cola
     */
    public Paciente peek() {
        if (isEmpty()) return null;
        return cola[0];
    }

    /**
     * @return devuelve el primer paciente de la cola y lo elimina
     */
    public Paciente poll() {
        if (isEmpty()) return null;
        Paciente item = cola[0];
        if (size == 1) {
            cola[0] = null;
            size = 0;
        } else {
            cola[0] = cola[size - 1];
            size--;
            heapifyDown();
        }
        return item;
    }

    /**
     * @param paciente ingresa al paciente a agregar a la cola
     */
    public void add(Paciente paciente) {
        ensureExtraCapacity();
        cola[size] = paciente;
        size++;
        heapifyUp();

    }

    /**
     * @param coleccion ingresa una coleccion para agregar a la cola
     */
    public void addAll(Vector<Paciente> coleccion) {
        for (Paciente r : coleccion) {
            add(r);
        }
    }

    /**
     * explora la cola y reacomoda
     */
    public void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index).compareTo(cola[index]) > 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * explora la cola y reacomoda
     */
    public void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (cola[index].compareTo(cola[smallerChildIndex]) < 0) break;
            else swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    /**
     * @return devuelve string con la cola actual
     */
    public String verCola() {
        String show = "";
        for (Paciente r : cola) {
            if (r != null) {
                show = show + r;
            }
        }
        return show;
    }

    /**
     * @param collecion reinicia la cola e ingresa la nueva coleccion en la que se basara la cola
     */
    public void reboot(Vector<Paciente> collecion) {
        cola = new Paciente[10];
        size = 0;
        capacidad = 10;
        addAll(collecion);
    }

    /**
     * @return devuelve si la cola esta vacia
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return devuelve el tamaño de la cola
     */
    public int getSize() {
        return size;
    }

    /**
     * @param index ingresa el indice del elemento que se desea eliminar de la cola
     */
    public void eliminar(int index) {
        Paciente[] nuevaCola = new Paciente[capacidad];
        int nuevoSize = 0;
        for (Paciente r : cola) {
            if (nuevoSize != index) {
                nuevaCola[nuevoSize] = r;
                nuevoSize++;
            }
        }
        cola = nuevaCola;
        size = nuevoSize;

    }

    /**
     * @return devuelve la cola
     */
    public Paciente[] getCola() {
        return cola;
    }
}
