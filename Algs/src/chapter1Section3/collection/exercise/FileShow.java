package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;

import java.io.File;

/**
 * @author pachi
 * @deprecated 文件列表。从命令行接收一个文件夹名字，递归打印出这个文件夹下面所有文件
 */
public class FileShow {
    public static void main(String[] args) {
        System.out.println("Please enter a file's path:");
        String url = StdIn.readString();

        File file = new File(url);

        Queue<String> queue = new Queue<>();
        new FileShow().print(file,0,queue);
        while(!queue.isEmpty())
            System.out.println(queue.dequeue());
    }

    public void print(File file, int count, Queue<String> queue) {
        File[] files = file.listFiles();
        String[] sFiles = file.list();

        for (int i = 0; i < files.length; i++) {
            String s = "";
            for(int j=0;j<count;j++)
                s+="   ";
            assert files != null;
            if (files[i].isDirectory()) {
                print(files[i], count + 1, queue);
            } else {
                assert sFiles != null;
                queue.enqueue(s + sFiles[i]);
            }
        }
    }
}
