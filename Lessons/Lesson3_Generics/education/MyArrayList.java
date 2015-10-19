package education;

public class MyArrayList<T> {
    private T[] array;
    private int size;
    private int capacity;

    public MyArrayList() {
        array = (T[])new Object[10];
        size = 0;
        capacity = 10;
    }

    public MyArrayList(int capacity) {
        array = (T[])new Object[10];
        size = 0;
        this.capacity = capacity;
    }

    public void add(T value) {
        array[size++] = value;
        if(size == capacity) {
            capacity *= 2;
            T[] arrayTemp = (T[])new Object[capacity];
            System.arraycopy(array, 0, arrayTemp, 0, size);
            array = arrayTemp;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > size - 1 ) {
            System.out.println("incorrect index");
        }
        for (int i = index; i < size; i++ ) {
            array[i] = array[i+1];
        }
        size--;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for ( int i = 0; i < size; i++ ) {
            str.append(array[i]);
            str.append(' ');
        }
        return str.toString();
    }
}

class DemoList {
    public static void main(String[] args) {
        MyArrayList<String> str = new MyArrayList<>();
        str.add("one");
        str.add("two");
        System.out.println(str);
    }
}