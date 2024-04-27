import java.util.Iterator;

public class MyLinkedList implements MyList {
    private MyNode head;
    private MyNode tail;
    private int size;

    private class MyNode<E> {
        private E element;
        private MyNode next;
        private MyNode previous;

        public MyNode(E element, MyNode next, MyNode prev) {
            this.element = element;
            this.next = next;
            this.previous = prev;
        }

    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(Object item) {
        MyNode newNode = new MyNode(item, null, null);
        if (this.head == null) {
            this.head = newNode;
        }
        newNode.previous = this.tail;
        this.tail = newNode;
        this.size++;
    }

    @Override
    public void set(int index, Object item) {
        if (index == 0) {
            this.head.element = item;
        }
        if (index == this.size - 1) {
            this.tail.element = item;
        }
        MyNode next = head.next;
        for (int i = 1; i < this.size; i++) {
            if (i == index) {
                next.element = item;
            }
            next = next.next;
        }
    }

    @Override
    public void add(int index, Object item) {

    }

    @Override
    public void addFirst(Object item) {
        MyNode newNode = new MyNode(item, this.head, null);

        this.head = newNode;
        this.size++;
    }

    @Override
    public void addLast(Object item) {
        MyNode newNode = new MyNode(item, null, this.tail);
        this.tail = newNode;
        this.size++;
    }

    @Override
    public Object get(int index) {
        if (this.head == null) {
            return null;
        }
        if (index == this.size - 1) {
            return this.tail.element;
        }
        if (index == 0) {
            return this.head.element;
        }

        MyNode next = head.next;
        for (int i = 1; i < this.size; i++) {
            if (i == index) {
                return next.element;
            }
            next = next.next;
        }

        return null;
    }

    @Override
    public Object getFirst() {
        return this.head;
    }

    @Override
    public Object getLast() {
        return this.tail;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            this.head = this.head.next;
        }
        if (index == this.size - 1) {
            this.tail = this.tail.previous;
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

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        MyNode node = this.head;
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
        MyNode node = this.head;
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
        MyNode node = this.head;
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
        MyNode node = this.head;
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
    public Iterator iterator() {
        return null;
    }
}
