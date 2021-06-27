package com.immoc.stack;

class Solution {

    public class Array<E> {

        private E[] data;
        private int size;

        public Array(int capacity) {
            data = (E[]) new Object[capacity];
            size = 0;
        }

        public Array() {
            this(10);
        }

        public int getSize() {
            return size;
        }

        public int getCapacity() {
            return data.length;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void addLast(E val) {
            add(size, val);
        }

        public void addFirst(E val) {
            add(0, val);
        }

        private void resize(int length) {
            E[] newDate = (E[]) new Object[length];

            for (int i = 0; i < size; i++) {
                newDate[i] = data[i];
            }

            data = newDate;
        }

        public void add(int index, E val) {

            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
            }

            if (size == data.length) {
                resize(2 * data.length);
            }

            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            size++;
            data[index] = val;
        }

        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Get failed. Require index >= 0 and index < size");
            }

            return data[index];
        }

        public void set(int index, E val) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Set failed. Require index >= 0 and index < size");
            }

            data[index] = val;
        }

        public boolean contains(E val) {

            for (int i = 0; i < size; i++) {
                if (val.equals(data[i])) {
                    return true;
                }
            }

            return false;
        }

        public int find(E val) {

            for (int i = 0; i < size; i++) {
                if (val.equals(data[i])) {
                    return i;
                }
            }

            return -1;
        }

        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IllegalArgumentException("Remove failed. Require index >= 0 and index < size.");
            }

            E ret = data[index];
            for (int i = index + 1; i < size; i++) {
                data[i - 1] = data[i];
            }
            size--;
            // 垃圾回收
            data[size] = null;

            if (size < data.length / 4) {
                resize(size * 2);
            }

            return ret;
        }

        public E removeFirst() {
            return remove(0);
        }

        public E removeLast() {
            return remove(size - 1);
        }

        public void removeElement(E val) {
            int index = find(val);
            if (index != -1) {
                remove(index);
            }
        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();
            res.append(String.format("Array: size =  %d, capacity = %d\n", size, data.length));
            res.append("[");
            for (int i = 0; i < size; i++) {
                res.append(data[i]);
                if (i != size - 1) {
                    res.append(", ");
                }
            }
            res.append("]");

            return res.toString();
        }
    }

    public class ArrayStack<E> implements Stack<E> {

        Array<E> data = new Array<>();

        @Override
        public void push(E val) {
            data.addLast(val);
        }

        @Override
        public E pop() {
            return data.get(0);
        }

        @Override
        public E peek() {
            return data.removeLast();
        }

        @Override
        public int getSize() {
            return data.getSize();
        }

        @Override
        public boolean isEmpty() {
            return data.isEmpty();
        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();
            res.append("Stack: ");
            res.append("top [");
            for (int i = 0; i < getSize(); i++) {
                res.append(data.get(i));
                if (i != data.getSize() - 1){
                    res.append(", ");
                }
            }
            res.append(']');
            return res.toString();
        }
    }

    public interface Stack<E> {

        void push(E val);

        E pop();

        E peek();

        int getSize();

        boolean isEmpty();
    }

    public boolean isValid(String s) {

        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();

                if (topChar == '(' && c != ')') {
                    return false;
                }
                if (topChar == '[' && c != ']') {
                    return false;
                }
                if (topChar == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
    }
}
