public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> data;

    public MyMinHeap() {
        data = new MyArrayList<>();
    }

    public void add(T value) {
        data.add(value);
        moveUp(data.size() - 1);
    }

    public T removeMin() {
        if (isEmpty()) throw new RuntimeException("");

        T smallest = data.get(0);
        T last = data.get(data.size() - 1);

        data.set(0, last);
        data.remove(data.size() - 1);

        moveDown(0);
        return smallest;
    }

    public T getMin() {
        if (isEmpty()) throw new RuntimeException("");
        return data.get(0);
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public int size() {
        return data.size();
    }

    private void moveUp(int childIndex) {
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            T child = data.get(childIndex);
            T parent = data.get(parentIndex);

            if (child.compareTo(parent) < 0) {
                swap(childIndex, parentIndex);
                childIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void moveDown(int parentIndex) {
        int length = data.size();
        while (true) {
            int left = 2 * parentIndex + 1;
            int right = 2 * parentIndex + 2;
            int minIndex = parentIndex;

            if (left < length && data.get(left).compareTo(data.get(minIndex)) < 0) {
                minIndex = left;
            }

            if (right < length && data.get(right).compareTo(data.get(minIndex)) < 0) {
                minIndex = right;
            }

            if (minIndex == parentIndex) break;

            swap(parentIndex, minIndex);
            parentIndex = minIndex;
        }
    }

    private void swap(int a, int b) {
        T tmp = data.get(a);
        data.set(a, data.get(b));
        data.set(b, tmp);
    }
}
