package com.datastructures.misc;

import java.util.Stack;

/**
 * To check whether the expression is correct with the proper brackets.
 */
public class ParanthesisBalanced {


    private static int areBracketsMatched(String expression) {

        Stack<Character> stack = new Stack();

        for (int i = 0; i < expression.length(); i++) {

            Character ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ']') {
                if (stack.isEmpty()) return 0;
                if (stack.pop() != '[') return 0;

            } else if (ch == ')') {
                if (stack.isEmpty()) return 0;
                if (stack.pop() != '(') return 0;

            } else if (ch == '}') {
                if (stack.isEmpty()) return 0;
                if (stack.pop() != '{') return 0;
            }

        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(areBracketsMatched("{[1]}"));
    }

}
