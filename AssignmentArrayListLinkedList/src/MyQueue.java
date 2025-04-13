public class MyQueue<T> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.add(item); // добавляем в конец
    }

    public T dequeue() {
        if (list.size() == 0) throw new RuntimeException("queue is empty");
        T value = list.get(0);
        list.remove(0);
        return value;
    }

    public T peek() {
        if (list.size() == 0) throw new RuntimeException("queue is empty");
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
