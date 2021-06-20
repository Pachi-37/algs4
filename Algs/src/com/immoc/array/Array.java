package com.immoc.array;

/**
 * @author pachi
 * @date 2021-6-19
 */
public class Array {

    private int[] data;
    private int size;

    /**
     * 传入数组容量，构造 Array
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = new int[capacity];
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
    public void addLast(int val) {
        add(size, val);
    }

    /**
     * 在数组开头添加一个元素
     *
     * @param val 元素
     */
    public void addFirst(int val) {
        add(0, val);
    }

    /**
     * 根据索引插入元素
     *
     * @param index 索引
     * @param val   待插入元素
     */
    public void add(int index, int val) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. Array is full.");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
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
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index < size");
        }

        return data[index];
    }

    /**
     * 设置 index 索引位置元素的值
     * @param index 索引
     * @param val 待更改的值
     */
    public void set(int index, int val) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Require index >= 0 and index < size");
        }

        data[index] = val;
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

        Array array = new Array(20);

        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }

        array.addFirst(-1);

        System.out.println(array.toString());
    }
}
