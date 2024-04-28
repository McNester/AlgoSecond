import java.util.Arrays;
import java.util.Iterator;

//TODO: take a look at all the methods, somewhere you will need to return,
//when you have a check for the head or tail indexes or smth,
//also check where you need to adjust your starting point in your for statements.
public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    private class MyNode<E> {
        private E element;
        private MyNode<T> next;
        private MyNode<T> previous;

        public MyNode(E element, MyNode<T> next, MyNode<T> prev) {
            this.element = element;
            this.next = next;
            this.previous = prev;
        }

    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item, null, null);
        if (this.head == null) {
            this.head = newNode;
        }
        newNode.previous = this.tail;
        this.tail = newNode;
        this.size++;
    }

    @Override
    public void set(int index, T item) {
        if (index == 0) {
            this.head.element = item;
            return;
        }
        if (index == this.size - 1) {
            this.tail.element = item;
            return;
        }
        MyNode<T> next = head.next;
        for (int i = 1; i < this.size; i++) {
            if (i == index) {
                next.element = item;
            }
            next = next.next;
        }
    }

    @Override
    public void add(int index, T item) {
        MyNode<T> node = new MyNode<T>(item, null, null);
        if (index == 0) {
            node.next = this.head;
            this.head.previous = node;
            this.head = node;
            return;
        }
        if (index == this.size - 1) {
            node.previous = this.tail;
            this.tail.next = node;
            this.tail = node;
            return;
        }
        MyNode<T> currNode = head;
        for (int i = 1; i < this.size; i++) {
            if (index == i - 1) {
                node.previous = currNode;
                currNode.next.previous = node;
                currNode.next = node;
            }
            currNode = currNode.next;
        }

    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item, this.head, null);

        this.head = newNode;
        this.size++;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item, null, this.tail);
        this.tail = newNode;
        this.size++;
    }

    @Override
    public T get(int index) {
        if (this.head == null) {
            return null;
        }
        if (index == this.size - 1) {
            return (T) this.tail.element;
        }
        if (index == 0) {
            return (T) this.head.element;
        }

        MyNode<T> next = head.next;
        for (int i = 1; i < this.size; i++) {
            if (i == index) {
                return next.element;
            }
            next = next.next;
        }

        return null;
    }

    @Override
    public T getFirst() {
        return this.head.element;
    }

    @Override
    public T getLast() {
        return this.tail.element;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        if (index == this.size - 1) {
            this.tail = this.tail.previous;
            return;
        }

        MyNode<T> node = head;
        for (int i = 0; i < this.size; i++) {
            if (i == index - 1) {
                node.next = node.next.next;
                node.next.previous = node.next.previous.previous;
            }
            node = node.next;
        }

        this.size--;
    }

    @Override
    public void removeFirst() {
        this.head = this.head.next;
    }

    @Override
    public void removeLast() {
        this.tail = this.tail.previous;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void sort() {
        Object[] arr = toArray();
        Arrays.sort(arr);

        MyNode<T> node = head;
        for (int i = 0; i < arr.length; i++) {
            node.element = (T) arr[i];
            node = node.next;
        }
    }

    @SuppressWarnings("unchecked")
    public void sortManually() {
        Object[] arr = toArray();
        timSort(arr);
        MyNode<T> node = head;
        for (int i = 0; i < arr.length; i++) {
            node.element = (T) arr[i];
            node = node.next;
        }
    }

    private void timSort(Object[] arr) {
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> node = this.head;
        for (int i = 0; i < this.size; i++) {
            if (node.element == object) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> node = this.head;
        int index = -1;
        for (int i = 0; i < this.size; i++) {
            if (node.element == object) {
                index = i;
            }
            node = node.next;
        }
        return index;
    }

    @Override
    public boolean exists(Object object) {
        MyNode<T> node = this.head;
        for (int i = 0; i < this.size; i++) {
            if (node.element == object) {
                return true;
            }
            node = node.next;
        }
        return false;

    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.size];
        MyNode<T> node = this.head;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = node.element;
            node = node.next;
        }
        return new Object[this.size];
    }

    @Override
    public void clear() {
        this.head = null;
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
