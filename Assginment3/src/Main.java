public class Main {
    public static void main(String[] args) {
        SmarterPriorityQueue spq = new SmarterPriorityQueue(10);

        // Test if the queue is empty
        System.out.println("The queue is empty: " + spq.isEmpty()); // Should return true

        // Insert some elements and show the initial state
        SmarterPriorityQueue.Entry entryApple = spq.insert(5, "apple");
        SmarterPriorityQueue.Entry entryBanana = spq.insert(3, "banana");
        SmarterPriorityQueue.Entry entryCherry = spq.insert(8, "cherry");
        System.out.println("Initial top element: " + spq.top().getValue()); // Initial top element

        // Display the current state and size of the queue
        System.out.println("Current state of the queue: " + spq.state()); // Shows as Min-Heap
        System.out.println("Size of the queue: " + spq.size()); // Shows as 3

        // Remove the top element and print the result
        System.out.println("Top element removed: " + spq.removeTop().getValue());
        System.out.println("Size of the queue after removal: " + spq.size()); // Shows as 2

        // Toggle the heap type and show the top element after toggling
        spq.toggle(); // Toggle heap type
        System.out.println("Top element after toggle: " + spq.top().getValue());
        System.out.println("Current state of the queue: " + spq.state()); // Shows as Max-Heap

        // Continue inserting elements and testing
        SmarterPriorityQueue.Entry entryDate = spq.insert(1, "date");
        SmarterPriorityQueue.Entry entryFig = spq.insert(2, "fig");
        System.out.println("Top element after inserts: " + spq.top().getValue()); // Top element after inserts

        // Insert specific elements and show
        SmarterPriorityQueue.Entry newEntryApple = spq.insert(5, "new apple");
        System.out.println("Top after inserting apple: " + spq.top().getValue());

        SmarterPriorityQueue.Entry newEntryBanana = spq.insert(3, "new banana");
        System.out.println("Top after inserting banana: " + spq.top().getValue());

        SmarterPriorityQueue.Entry newEntryCherry = spq.insert(8, "new cherry");
        System.out.println("Top after inserting cherry: " + spq.top().getValue());

        // Replace key and value
        int oldKey = spq.replaceKey(entryDate, 10);
        System.out.println("Old key of date was: " + oldKey + ", new key is: " + entryDate.getKey());
        System.out.println("Top after replacing date's key: " + spq.top().getValue());

        Object oldValue = spq.replaceValue(entryFig, "new fig");
        System.out.println("Old value of fig was: " + oldValue + ", new value is: " + entryFig.getValue());
        System.out.println("Top after replacing fig's value: " + spq.top().getValue());

        // Toggle the heap type again and check the top element
        spq.toggle(); // Toggle to the other type
        System.out.println("Top after second toggle: " + spq.top().getValue());
        System.out.println("Current state of the queue: " + spq.state()); // Shows as Min-Heap

        // Verify removal of the top element and the last top element
        System.out.println("Remove top: " + spq.removeTop().getValue());
        System.out.println("New top after removal: " + spq.top().getValue());
        System.out.println("The queue is empty: " + spq.isEmpty()); // Shows whether it's empty
    }
}
