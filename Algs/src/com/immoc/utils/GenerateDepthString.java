package com.immoc.utils;

/**
 * @author pachi
 */
public class GenerateDepthString {
    public static String generate(int depth) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < depth; i++) {
            res.append("--");
        }

        return res.toString();
    }
}
