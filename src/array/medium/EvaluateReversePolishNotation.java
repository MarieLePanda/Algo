/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array.medium;

import java.util.ArrayList;

/**
 *
 * @author lgirardin
 */
public class EvaluateReversePolishNotation {
    /*
        Evaluate the value of an arithmetic expression in Reverse Polish Notation.

    Valid operators are +, -, *, and /. Each operand may be an integer or 
    another expression.

    Note that division between two integers should truncate toward zero.

    It is guaranteed that the given RPN expression is always valid. That means 
    the expression would always evaluate to a result, and there will not be any 
    division by zero operation.



    Example 1:

    Input: tokens = ["2","1","+","3","*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9

    Example 2:

    Input: tokens = ["4","13","5","/","+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6

    Example 3:

    Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    Output: 22
    Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    = ((10 * (6 / (12 * -11))) + 17) + 5
    = ((10 * (6 / -132)) + 17) + 5
    = ((10 * 0) + 17) + 5
    = (0 + 17) + 5
    = 17 + 5
    = 22



    Constraints:

        1 <= tokens.length <= 104
        tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].


    */
    
    public static void main(String ... args){
        String[] tokens1 = {"2","1","+","3","*"};
        String[] tokens2 = {"4","13","5","/","+"};
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        
        System.out.println("tokens1: expected: 9 Result:" + Solution.evalRPN(tokens1));
        System.out.println("tokens2: expected: 6 Result:" + Solution.evalRPN(tokens2));
        System.out.println("tokens3: expected: 22 Result:" + Solution.evalRPN(tokens3));

    }
}

class Solution {
    public static int evalRPN(String[] tokens) {
        int size = tokens.length;
        ArrayList<String> operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("/");
        operators.add("*");
        
        for(int i = 0; i < size; i++){
            if(operators.contains(tokens[i])){
                int result = 0;
                int n1 = Integer.parseInt(tokens[i-2]);
                int n2 = Integer.parseInt(tokens[i-1]);
                
                switch(tokens[i]){
                    case "*":
                        result = n1 * n2;
                        break;
                    case "/":
                        result = n1 / n2;
                        break;
                    case "-":
                        result = n1 - n2;
                        break;
                    case "+":
                        result = n1 + n2;
                        break;
                }
                
                tokens[i] = Integer.toString(result);
                for(int j = i; j < size; j++){
                    tokens[j-2] = tokens[j];
                    
                }
                size = size - 2;
                i = i - 2;
            }
        }
        
        return Integer.parseInt(tokens[0]);
    }
}