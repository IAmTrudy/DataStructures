package com.lxp.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        String exp = "3 4 + 5 * 6 -";
        List<String> strings = parseString(exp);
        int caculate = caculate(strings);
        System.out.println(caculate);

    }

    public static List<String> parseString(String exp){
        String[] chars = exp.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : chars) {
           list.add(s);
        }
        return list;
    }

    public static int caculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for (int i = 0;i<list.size();i++) {
            if (list.get(i).matches("\\d")){
                stack.push(list.get(i));
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (list.get(i).equals("+")){
                    res = num1 + num2;
                }else if(list.get(i).equals("-")){
                    res = num1 - num2;
                }else if(list.get(i).equals("*")){
                    res = num1 * num2;
                }else if(list.get(i).equals("/")){
                    res = num1 / num2;
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
