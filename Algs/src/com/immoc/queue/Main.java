package com.immoc.queue;

import com.immoc.linear_search.ArrayGenerator;

/**
 * @author pachi
 */
public class Main {
    /**
     * 测试队列入队和出队需要耗费的时间
     *
     * @param queue   队列
     * @param opCount 数量
     * @return 运行时间
     */
    private static double testQueue(Queue<Integer> queue, int opCount) {
        Integer[] arr = ArrayGenerator.generateRandomArray(opCount, 20);
        long startTime = System.nanoTime();

        for (Integer e :
                arr) {
            queue.enqueue(e);
        }

        for (Integer e :
                arr) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);

        System.out.println("ArrayQueue: %lf " + time1 + "LoopQueue: %lf " + time2);
    }
}
