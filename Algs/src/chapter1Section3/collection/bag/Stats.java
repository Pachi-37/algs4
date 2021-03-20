package chapter1Section3.collection.bag;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author minix
 */
public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<Double>();

        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }

        int len = numbers.size();

        double sum = 0.0;

        for (double x :
                numbers) {
            sum += x;
        }

        double mean = sum / len;

        sum = 0.0;
        for (double x :
                numbers) {
            sum += (x - mean) * (x - mean);
        }
        double std = Math.sqrt(sum / (len - 1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}

