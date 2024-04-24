import java.util.Iterator;

public class MyLinkedList<E> implements MyList {
    private MyNode head;
    private MyNode tail;
    private int size;

    private class MyNode {
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
        if (this.head == null) {
            MyNode newNode = new MyNode(item, null, null);

            this.head = newNode;
        } else {

        }

        this.size++;
    }

    @Override
    public void set(int index, Object item) {

    }

    @Override
    public void add(int index, Object item) {

    }

    @Override
    public void addFirst(Object item) {

    }

    @Override
    public void addLast(Object item) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public void remove(int index) {
        this.size--;
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[this.size];
    }

    @Override
    public void clear() {
        this.head = null;
        size = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
