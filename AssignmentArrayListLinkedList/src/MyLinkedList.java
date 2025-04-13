import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = item;
    }


    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(item);
            return;
        }

        if (index == size) {
            addLast(item);
            return;
        }

        MyNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        MyNode newNode = new MyNode(item);
        newNode.prev = temp.prev;
        newNode.next = temp;

        if (temp.prev != null) {
            temp.prev.next = newNode;
        }
        temp.prev = newNode;

        size++;
    }


    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        MyNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public T getFirst() {
        if (size == 0) throw new IndexOutOfBoundsException();
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0) throw new IndexOutOfBoundsException();
        return tail.data;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        if (temp.prev != null) temp.prev.next = temp.next;
        else head = temp.next;

        if (temp.next != null) temp.next.prev = temp.prev;
        else tail = temp.prev;

        size--;
    }


    @Override
    public void removeFirst() {
        if (head == null) throw new IndexOutOfBoundsException();
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new IndexOutOfBoundsException();
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
    }

    @Override
    public void sort() {
        if (size < 2) return;

        for (int i = 0; i < size; i++) {
            MyNode current = head;
            while (current != null && current.next != null) {
                Comparable<T> a = (Comparable<T>) current.data;
                T b = current.next.data;
                if (a.compareTo(b) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }


    @Override
    public int indexOf(Object object) {
        int i = 0;
        for (MyNode node = head; node != null; node = node.next) {
            if (node.data.equals(object)) return i;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int i = size - 1;
        for (MyNode node = tail; node != null; node = node.prev) {
            if (node.data.equals(object)) return i;
            i--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (MyNode temp = head; temp != null; temp = temp.next) {
            arr[i++] = temp.data;
        }
        return arr;
    }


    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        MyNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    private void unlink(MyNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        size--;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.data;
                current = current.next;
                return value;
            }
        };
    }
}
