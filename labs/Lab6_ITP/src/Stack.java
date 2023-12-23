import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
    private T[] data;
    private int size;
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element) {
        if (size + 1 < data.length) {
            data[size++] = element;
        } else {
            resize();
        }
    }

    // удаление элемента из стека
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return data[--size];
        }
    }

    // получение последнего элемента стека
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return data[size - 1];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
