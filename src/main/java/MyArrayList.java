package main.java;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private Object[] arr = new Object[10];
    private int size;

    @Override
    public void add(T item) {
        increaseBuffer();
        arr[this.size-1] = item;
    }
    private void increaseBuffer(){
        size++;
        if (size == arr.length){
            Object[] arr=new Object[size];
            for (int i = 0; i < arr.length-1; i++) {
               arr[i] = this.arr[i];
            }
            this.arr = arr;
        }
    }

    @Override
    public void add(int index, T item) {
        if (index == 0){
            addFirst(item);
            return;
        }
        if(index == size-1){
            addLast(item);
            return;
        }
        if (index == size){
            add(item);
            return;
        }
        increaseBuffer();
        for (int i = index; i < size-1; i++) {
            arr[i+1] = arr[i];
        }
        arr[index] = item;
    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {
        // TODO: Auto-generated method stub
    }

    @Override
    public void set(int index, T item) {
        // TODO: Auto-generated method stub
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getFirst() {
        // TODO: Auto-generated method stub
        return null;
    }

    @Override
    public T getLast() {
        // TODO: Auto-generated method stub
        return null;
    }

    @Override
    public void remove(int index) {
        // TODO: Auto-generated method stub
    }

    @Override
    public void removeFirst() {
        // TODO: Auto-generated method stub
    }

    @Override
    public void removeLast() {
        // TODO: Auto-generated method stub
    }

    @Override
    public void sort() {
        // TODO: Auto-generated method stub
    }

    @Override
    public int indexOf(Object object) {
        // TODO: Auto-generated method stub
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        // TODO: Auto-generated method stub
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        // TODO: Auto-generated method stub
        return false;
    }

    @Override
    public Object[] toArray() {
        // TODO: Auto-generated method stub
        return null;
    }

    @Override
    public void clear() {
        // TODO: Auto-generated method stub
    }

    @Override
    public int size() {
        // TODO: Auto-generated method stub
        return 0;
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
