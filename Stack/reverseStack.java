package Stack;

import java.util.*;
public class reverseStack {
    public static void pushatBottom(Stack<Integer> s , int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushatBottom(s, data);
        s.push(top);
    }
    public static void reverseStack(Stack<Integer> p ){
        if(p.isEmpty()){
            return;
        }
        int top = p.pop();
        reverseStack(p);
        pushatBottom( p ,top);

    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        
        reverseStack(s);
        printStack(s);
    }
}
