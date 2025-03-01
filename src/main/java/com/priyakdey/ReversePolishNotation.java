package com.priyakdey;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * @author Priyak Dey
 */
public class ReversePolishNotation {

    // Use a stack to pop rhs and lhs when operator found. Else
    // push the tokens in the stack.

    public int reversePolishNotation(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> operators = Set.of("+", "-", "*", "/");

        for (String token : tokens) {
            if (operators.contains(token)) {
                int rhs = stack.pop();
                int lhs = stack.pop();
                int result = switch (token) {
                    case "+" -> lhs + rhs;
                    case "-" -> lhs - rhs;
                    case "*" -> lhs * rhs;
                    case "/" -> lhs / rhs;
                    default -> throw new IllegalArgumentException("Invalid operator: " + token);
                };
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

}
