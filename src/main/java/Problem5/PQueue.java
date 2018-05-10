package Problem5;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * Created by wangcheng  on 2018/4/19.
 */
public class PQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        if(stack1.empty() && stack2.empty()){
            throw new RuntimeException();
        }
        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args){
        PQueue pQueue = new PQueue();
        for(int i = 0; i< 10;i++){
            pQueue.push(i);
        }
        for(int i=0;i<10;i++){
            System.out.println(pQueue.pop());
        }
    }
}
