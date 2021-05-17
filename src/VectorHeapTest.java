import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    @org.junit.jupiter.api.Test
    void peek() {
        Lector lec = new Lector();
        lec.Lectura();
        VectorHeap vec = new VectorHeap();
        vec.addAll(lec.getAllPacientes());
        Assertions.assertEquals(vec.peek().nombre, "Maria Ramirez", "De acuerdo al .txt el primero debe ser Maria Ramirez");
    }

    @org.junit.jupiter.api.Test
    void poll() {
        Lector lec = new Lector();
        lec.Lectura();
        VectorHeap vec = new VectorHeap();
        vec.addAll(lec.getAllPacientes());
        Assertions.assertEquals(vec.poll().nombre, "Maria Ramirez", "De acuerdo al .txt el primero debe ser Maria Ramirez");
        //Al ser eliminado el elemento al tope debe haber otro elemento
        Assertions.assertEquals(vec.poll().nombre, "Carmen Sarmientos", "De acuerdo al .txt el segeundo debe ser Carmen Sarmientos");
    }

    @org.junit.jupiter.api.Test
    void getSize() {
        Lector lec = new Lector();
        lec.Lectura();
        VectorHeap vec = new VectorHeap();
        vec.addAll(lec.getAllPacientes());
        Assertions.assertEquals(vec.getSize(), 4, "El tamaño debe ser 4");
    }
}