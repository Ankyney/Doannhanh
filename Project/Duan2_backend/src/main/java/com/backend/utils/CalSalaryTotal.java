/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Huy Le
 */
public class CalSalaryTotal {

    /**
     * Operation priorities.
     */
    public CalSalaryTotal() {
    }

    final static Map<Character, Integer> priorities;

    static {
        priorities = new HashMap<>();
        priorities.put(')', 0);
        priorities.put('(', 1);
        priorities.put('+', 2);
        priorities.put('-', 2);
        priorities.put('*', 3);
        priorities.put('/', 3);
        priorities.put('^', 4);
    }

    public List<String> parse(String input) {
        List<String> result = new ArrayList<>();// List chứa các số
        Stack<Character> opStack = new Stack<>();// stack chứa các toán tử
        for (int pos = 0; pos < input.length(); pos++) {
            char ch = input.charAt(pos); // tìm kiếm kí tự vị trí trong mảng chạy

            if (Character.isDigit(ch) || ch == '.') {

                int begin = pos;
                while ((pos < input.length() && Character.isDigit(input.charAt(pos))) || (pos < input.length() && input.charAt(pos) == '.')) {
                    pos++;
                }
                result.add(input.substring(begin, pos));
                pos--;
            } // kiểm tra có phải giá trị kiểu số sau đó insert vào List lưu trữ số
            else if (ch == '(') {
                opStack.push(ch);
            } else {
                char operation;
                if (ch == '*' && pos < input.length() && input.charAt(pos + 1) == '*') {
                    operation = '^';
                    pos++;
                } else {
                    operation = ch;
                }

                if (operation == '(') {
                    opStack.push(operation);
                } else {
                    while (!opStack.isEmpty()
                            && priorities.get(opStack.peek())
                            >= priorities.get(operation)) {
                        char top = opStack.pop();
                        if (top == '(') {
                            break;
                        }
                        result.add(Character.toString(top));
                    }
                }

                if (operation != ')') {
                    opStack.add(operation);
                }
            }
        }
        while (!opStack.isEmpty()) {
            result.add(Character.toString(opStack.pop()));
        }
        return result;
    }

    public Float eval(Iterable<String> polandTokens) {
        Stack<Float> result = new Stack<>();
        Iterator<String> it = polandTokens.iterator();
        while (it.hasNext()) {
            String t = it.next();
            if (priorities.containsKey(t.charAt(0))) {
                Float right = result.pop();
                result.push(evalOperation(result.pop(), right, t));
            } else {
                result.push(Float.parseFloat(t));
            }
        }
        assert result.size() == 1;
        return result.pop();
    }

    float evalOperation(float left, float right, String operation) {
        switch (operation.charAt(0)) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
            case '^':
                return (float) Math.pow(left, right);
            default:
                throw new RuntimeException("Unknown operation '" + operation + "'");
        }
    }
}
