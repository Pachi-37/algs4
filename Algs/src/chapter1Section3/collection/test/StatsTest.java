package chapter1Section3.collection.test;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author minix
 */
public class StatsTest {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String tmp = StdIn.readString();
            System.out.println(tmp == "+");
        }
    }
}
