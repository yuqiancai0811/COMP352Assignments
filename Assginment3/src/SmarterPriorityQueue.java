public class SmarterPriorityQueue {
    private Entry[] heap;  // Extendable array
    private int size;      // Current number of elements in the heap
    private boolean minHeap; // Flag, true for min-heap, false for max-heap

    public static class Entry {
        public int key;
        public Object value;

        public Entry(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }
    }

    public SmarterPriorityQueue(int initialCapacity) {
        heap = new Entry[initialCapacity];
        size = 0;
        minHeap = true;  // Default is set to min-heap
    }

    public void toggle() {
        minHeap = !minHeap;
        System.out.println("Toggling heap type. New heap type is " + (minHeap ? "Min-Heap" : "Max-Heap"));
        buildHeap();
    }


    public Entry removeTop() {
        if (size == 0) return null;  // Return null if the heap is empty

        Entry top = heap[0];         // Get the top element of the heap
        heap[0] = heap[size - 1];    // Move the last element to the top
        heap[size - 1] = null;       // Clear the last element
        size--;                      // Decrease the size of the heap
        downHeap(0);                 // Re-adjust the heap
        return top;
    }

    public Entry top() {
        if (size == 0) return null;
        return heap[0];
    }

    public Entry insert(int k, Object v) {
        if (size == heap.length) {
            // If the array is full, expand the array capacity
            resize();
        }
        Entry newEntry = new Entry(k, v);
        heap[size] = newEntry; // Place the new element at the end of the heap
        upHeap(size); // Adjust the heap to maintain its properties
        size++; // Increase the size of the heap
        return newEntry;
    }

    public int replaceKey(Entry e, int newKey) {
        // Find the index of the entry
        int index = findIndex(e);
        if (index == -1) {
            throw new IllegalArgumentException("Entry not found in the heap");
        }

        // Replace the key and adjust the heap
        int oldKey = heap[index].key;
        heap[index].key = newKey;
        // Re-heapify: Determine whether to upHeap or downHeap based on the heap type and key change
        if (minHeap) {
            if (newKey < oldKey) {
                upHeap(index);
            } else {
                downHeap(index);
            }
        } else {
            if (newKey > oldKey) {
                upHeap(index);
            } else {
                downHeap(index);
            }
        }
        return oldKey;
    }

    public Object replaceValue(Entry e, Object newValue) {
        // Find the index of the entry
        int index = findIndex(e);
        if (index == -1) {
            throw new IllegalArgumentException("Entry not found in the heap");
        }

        // Replace the value
        Object oldValue = heap[index].value;
        heap[index].value = newValue;
        return oldValue;
    }

    public String state() {
        // Returns the current state of the priority queue
        return minHeap ? "Min-Heap" : "Max-Heap";
    }

    public boolean isEmpty() {
        // Returns true if the queue size is 0, indicating the queue is empty
        return size == 0;
    }

    public int size() {
        // Returns the current number of elements in the priority queue
        return size;
    }


    /**
     * Rebuild the heap.
     */
    private void buildHeap() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            downHeap(i);
        }
    }


    /**
     * Adjust the heap from top to bottom.
     */
    private void downHeap(int index) {
        int childIndex = 2 * index + 1;  // Left child index
        Entry tmp = heap[index];         // Save the current node

        while (childIndex < size) {
            // If there is a right child and the right child's key is more suitable (less than or greater than, depending on heap type) then choose the right child
            if (childIndex + 1 < size && compare(heap[childIndex], heap[childIndex + 1])) {
                childIndex++;
            }
            // If the current node is the most suitable node then stop adjusting
            if (!compare(tmp, heap[childIndex])) {
                break;
            }
            // Otherwise, move down
            heap[index] = heap[childIndex];
            index = childIndex;
            childIndex = 2 * index + 1;
        }
        heap[index] = tmp;
    }

    /**
     * Compare two elements.
     */
    private boolean compare(Entry e1, Entry e2) {
        if (minHeap) {
            return e1.key > e2.key; // True if e1 should be below e2 in a min-heap
        } else {
            return e1.key < e2.key; // True if e1 should be below e2 in a max-heap
        }
    }


    private void upHeap(int index) {
        while (index > 0 && compare(heap[parent(index)], heap[index])) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int i, int j) {
        Entry temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resize() {
        Entry[] newHeap = new Entry[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    private int findIndex(Entry entry) {
        for (int i = 0; i < size; i++) {
            if (heap[i] == entry) { // Direct reference comparison
                return i;
            }
        }
        return -1; // Not found
    }

}
