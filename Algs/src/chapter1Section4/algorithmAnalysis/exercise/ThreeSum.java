package chapter1Section4.algorithmAnalysis.exercise;

/**
 * @author pachi
 * @deprecated 修改 `ThreeSum`，正确处理两个较大的 `int` 值可能导致溢出的情况; 异号相加不可能溢出：只需要判断同号溢出情况
 */
public class ThreeSum {
    public static int count(int[] a) {

        int N = a.length;
        int cnt = 0;
        int res;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if ((a[i] ^ a[j] >>> 31) < 0) {
                        res = a[i] + a[j];
                        if ((a[i] ^ res >>> 31) < 0) {
                            throw new RuntimeException("溢出");
                        }
                    }
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}
