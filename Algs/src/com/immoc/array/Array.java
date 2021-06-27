package com.immoc.array;

/**
 * @author pachi
 * @date 2021-6-19
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 传入数组容量，构造 Array
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认容量为 capacity = 10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     *
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组最后一个元素
     * @return 尾元素
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 返回数组中第一个值
     * @return 首元素
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获取数组容量
     *
     * @return 容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return true 空 false 非空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 数组中追加一个元素
     *
     * @param val 追加元素
     */
    public void addLast(E val) {
        add(size, val);
    }

    /**
     * 在数组开头添加一个元素
     *
     * @param val 元素
     */
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

    /**
     * 根据索引插入元素
     *
     * @param index 索引
     * @param val   待插入元素
     */
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

    /**
     * 获取 index 索引位置元素的值
     *
     * @param index 索引
     * @return 返回位置取值
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index < size");
        }

        return data[index];
    }

    /**
     * 设置 index 索引位置元素的值
     *
     * @param index 索引
     * @param val   待更改的值
     */
    public void set(int index, E val) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index < size");
        }

        data[index] = val;
    }

    /**
     * 查看数组中是否包含 val 元素
     *
     * @param val 待查找元素
     * @return 有 真 无 假
     */
    public boolean contains(E val) {

        for (int i = 0; i < size; i++) {
            if (val.equals(data[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * 查找数组中元素，并返回其对应的索引，如果未查找到返回 -1
     *
     * @param val 待查找元素
     * @return 返回索引（或 -1）
     */
    public int find(E val) {

        for (int i = 0; i < size; i++) {
            if (val.equals(data[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 删除指定索引的元素
     *
     * @param index 索引
     * @return 删除的元素
     */
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

    /**
     * 删除第一个元素，并返回其值
     *
     * @return 返回删除值
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素，并返回其值
     *
     * @return 返回最后一个元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除元素
     *
     * @param val 待删除元素
     */
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

    public static void main(String[] args) {

        Array<Integer> array = new Array<>(20);

        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }

        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();

        System.out.println(array.toString());
    }
}
