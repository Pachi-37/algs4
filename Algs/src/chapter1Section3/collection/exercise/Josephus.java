package chapter1Section3.collection.exercise;


import chapter1Section3.collection.queue.Queue;

/**
 * @author pachi
 * @deprecated 编写一个 `Queue` 的用例，从命令行接收 `N` 和 `M`并打印出被杀死的人的顺序
 */
public class Josephus {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);

        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < M - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            System.out.print(queue.dequeue() + " ");
        }
    }
}