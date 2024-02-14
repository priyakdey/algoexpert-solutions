package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class ShortenPath {

    private static final String PATH_SEP = "/";      // unix path separator

    private static final String CURR_DIR = ".";
    private static final String PREV_DIR = "..";

    public static String shortenPath(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("path cannot be empty");
        }

        boolean isAbsPath = path.startsWith(PATH_SEP);

        String[] tokens = path.split(PATH_SEP);

        return normalize(tokens, isAbsPath);
    }

    private static String normalize(String[] tokens, boolean isAbsolutePath) {
        Deque<String> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.isEmpty() || token.equals(CURR_DIR)) {
                continue;
            } else if (token.equals(PREV_DIR)) {
                if (!stack.isEmpty()) {
                    if (!isAbsolutePath && stack.peek().equals(PREV_DIR)) {
                        stack.push(token);
                    } else {
                        stack.pop();
                    }
                } else {
                    if (!isAbsolutePath) {
                        stack.push(token);
                    }
                }
            } else {
                stack.push(token);
            }
        }

        List<String> buf = new ArrayList<>(stack.size());
        while (!stack.isEmpty()) {
            buf.addFirst(stack.pop());
        }

        String normalizedPath = String.join("/", buf);
        if (isAbsolutePath) {
            normalizedPath = PATH_SEP + normalizedPath;
        }

        return normalizedPath;
    }

}
