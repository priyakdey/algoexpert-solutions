package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Priyak Dey
 */
public class ReversePolishNotation {

    public int reversePolishNotation(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            int x, y;
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                y = stack.pop();
                x = stack.pop();
                int result = eval(x, y, token);
                stack.push(result);
            } else {
                try {
                    stack.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("invalid input");
                }
            }

        }

        if (stack.isEmpty()) throw new IllegalArgumentException("invalid expression");

        return stack.peek();
    }

    private int eval(int x, int y, String op) {
        return switch (op) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> {
                if (y != 0) yield x / y;
                throw new IllegalArgumentException("cannot divide by zero");
            }
            default -> throw new IllegalArgumentException("unknown operand");
        };
    }

}
