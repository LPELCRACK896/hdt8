import java.util.Arrays;
import java.util.Vector;
public class VectorHeap {
    private Vector<Paciente> cola = new Vector<>();
    private int size=0;
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private Paciente leftChild(int index) {
        return cola.get(getLeftChildIndex(index));
    }

    private Paciente rightChild(int index) {
        return cola.get(getRightChildIndex(index));
    }

    private Paciente parent(int index) {
        return cola.get(getParentIndex(index));
    }

    private void swap(int indexOne, int indexTwo) {
        Paciente temp = cola.get(indexOne);
        cola.insertElementAt( cola.get(indexTwo), indexOne);
        cola.insertElementAt( temp, indexTwo);

    }



    public Paciente peek() {
        if (isEmpty()) return null;
        return cola.get(0);

    }

    //Saca y elimina de la cola
    public Paciente poll() {
        if (isEmpty()) return null;
        Paciente pacienteARetornar = cola.get(0);
        cola.insertElementAt(cola.get(size-1),0);
        size--;
        heapifyDown();
        return pacienteARetornar;
    }
    public void add(Paciente paciente){
        cola.insertElementAt(paciente, size);
        size++;
        heapifyUp();

    }
    public void heapifyUp(){
        int index  = size-1;
        while (hasParent(index) && parent(index).compareTo(cola.get(index)) > 0){
            swap(getParentIndex(index), index);
            index= getParentIndex(index);
        }
    }
    public void heapifyDown(){
        int index=0;
        while (hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0){
                smallerChildIndex = getRightChildIndex(index);
            }
            if(cola.get(index).compareTo(cola.get(smallerChildIndex))<0) break;
            else swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }
    public boolean isEmpty(){return size==0;}

}
