package main.java;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private Object[] arr = new Object[0];
    private int size;

    @Override
    public void add(T item) {
        increaseBuffer();
        arr[this.size-1] = item;
    }
    private void increaseBuffer(){
        size++;
        Object[] arr=new Object[size];
        for (int i = 0; i < arr.length-1; i++) {
           arr[i] = this.arr[i];
        }
        this.arr = arr;
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
        Object[] arr = new Object[size];
        for (int i = 0; i < index; i++) {
            arr[i] = this.arr[i];
        }
        arr[index]=item;
        for (int i = index; i < size-1; i++) {
            arr[i+1] = this.arr[i];
        }
        this.arr = arr;
    }

    @Override
    public void addFirst(T item) {
        increaseBuffer();
        Object[] arr = new Object[size];
        for (int i = 0; i < size-1; i++) {
            arr[i+1] = this.arr[i];
        }
        arr[0]=item;
        this.arr = arr;
    }

    @Override
    public void addLast(T item) {
        increaseBuffer();
        arr[size-1]=item;
    }

    @Override
    public void set(int index, T item) {
        arr[index] = item;
    }

    @Override
    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public T getFirst() {
        return (T) arr[0];
    }

    @Override
    public T getLast() {
        return (T) arr[size-1];
    }

    @Override
    public void remove(int index) {
        Object[] arr = new Object[size-1];
        for (int i = 0; i < index; i++) {
            arr[i] = this.arr[i];
        }
        for (int i = index; i < size-1; i++) {
            arr[i] = this.arr[i+1];
        }
        this.arr = arr;
        size--;
    }

    @Override
    public void removeFirst() {
        Object[] arr = new Object[size-1];
        for (int i = 1; i < size; i++) {
            arr[i-1] = this.arr[i];
        }
        this.arr = arr;
        size--;
    }

    @Override
    public void removeLast() {
        Object[] arr = new Object[size-1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.arr[i];
        }
        this.arr = arr;
        size--;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void sort() {
        Arrays.sort(arr, (o1, o2) -> {
            BigDecimal num1 = toBigDecimal(o1);
            BigDecimal num2 = toBigDecimal(o2);
            return num1.compareTo(num2);
        });
    }

    private static BigDecimal toBigDecimal(Object obj) {
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        } else if (obj instanceof String) {
            try {
                return new BigDecimal((String) obj);
            } catch (NumberFormatException e) {
                // Handle or log error for non-numeric strings
                return BigDecimal.ZERO; // or some other handling logic
            }
        } else if (obj instanceof Number) {
            return new BigDecimal(obj.toString());
        }
        return BigDecimal.ZERO; // Default case, can be adjusted based on requirements
    }

    @Override
    public int indexOf(Object object) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(object)){
                return i;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(object)){
                index = i;
            }
        }
        return index;
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public void clear() {
        arr = new Object[0];
        size = 0;
    }

    @Override
    public int size() {
        return size;
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
