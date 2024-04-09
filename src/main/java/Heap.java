import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap<T extends Comparable<T>> {

    private List<T> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void insertar(T elemento) {
        heap.add(elemento);
        swim(heap.size() - 1);
    }

    public T eliminarMax() {
        if (heap.isEmpty()) {
            return null;
        }
        T maximo = heap.get(0);
        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        sink(0);
        return maximo;
    }

    public List<T> getHeap() {
        return heap;
    }

    private void swim(int k) {
        while (k > 0 && less(k / 2, k)) {
            Collections.swap(heap, k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        int n = heap.size();
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j < n - 1 && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            Collections.swap(heap, k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return heap.get(i).compareTo(heap.get(j)) < 0;
    }
}
