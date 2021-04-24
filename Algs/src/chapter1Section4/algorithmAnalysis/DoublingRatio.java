package chapter1Section4.algorithmAnalysis;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingRatio {
    public static double timeTrail(int N) {
        int MAX = 1000000;
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }

        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrail(125);

        for (int i = 250; true; i += i) {
            double time = timeTrail(i);
            StdOut.printf("%6d %7.1f", i, time);
            StdOut.printf("%5.1f\n", time / prev);
        }
    }
}
