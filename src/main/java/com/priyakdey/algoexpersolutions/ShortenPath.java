package com.priyakdey.algoexpersolutions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class ShortenPath {

    public static String shortenPath(String path) {
        boolean isAbsPath = path.startsWith("/");
        int length = path.length();
        Deque<String> deque = new ArrayDeque<>();

        int curr = 0;
        while (curr < length) {
            if (path.charAt(curr) == '/') {
                curr++;
                continue;
            }

            int start = curr;
            while (curr < length && path.charAt(curr) != '/') {
                curr++;
            }

            String sub = path.substring(start, curr);
            if (Objects.equals(sub, ".")) {
                continue;
            } else if (Objects.equals(sub, "..")) {
                if (deque.isEmpty()) {
                    if (!isAbsPath) {
                        deque.push(sub);
                    }
                } else {
                    deque.pop();
                }
            } else {
                deque.push(sub);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isAbsPath) {
            sb.append('/');
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
            if (!deque.isEmpty()) {
                sb.append('/');
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(shortenPath("../../foo/bar/baz"));       // ../../foo/bar/baz
    }
}
