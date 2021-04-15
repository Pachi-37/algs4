package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * @author pachi
 * @deprecated 栈的可生成性。设计一个算法，测试用例是否能产生某个给定的排列
 */
public class StackProblem {
    public static boolean isOverFlow(String[] seq){
        int cnt = 0;
        for (int i = 0; i < seq.length; i++) {
            if (seq[i].equals("-")){
                cnt--;
            } else {
                cnt++;
            }
            if (cnt < 0){
                return true;
            }
        }
        return false;
    }

    public static String[] generate(String[] seq){
        int cnt = 0;
        String[] ans = new String[seq.length];
        if (isOverFlow(seq)){
            throw new RuntimeException("Overflow");
        } else {
            for (int i = 0; i < seq.length; i++) {
                if (seq[i].equals("-")){
                    cnt--;
                } else {
                    ans[cnt++] = seq[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] seq = new String[]{"0","1","-","-","3","-","-"};
        StdOut.println(isOverFlow(seq));
        String[] seq1 = new String[]{"2", "5", "6", "7", "4", "8", "-", "3", "1", "0"};
        for (String str :
                generate(seq1)) {
            if (str == null){
                break;
            }
            StdOut.println(str);
        }
    }
}
