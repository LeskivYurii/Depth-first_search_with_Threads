package com.company;

import java.util.Stack;

public class ThreadNode implements Runnable {
    Node root;
    Thread t;
    static int  countT = 0;

    public ThreadNode(Node root) {
        t = new Thread(this,"Thread - "+ ++countT);
        this.root = root;
        t.start();
    }

    @Override
    public void run() {
        Stack stack = new Stack();
        System.out.println(Thread.currentThread().getName()+ " "+ root.nameNode);
        if (root.left != null)  stack.push(root.left);
        while (!stack.empty()) {
            Node reccuringNode = (Node) stack.pop();
            System.out.println(Thread.currentThread().getName()+ " "+ reccuringNode.nameNode);
            if (reccuringNode.left != null) {
                stack.push(reccuringNode.left);
            }
            if (reccuringNode.right != null) {
                stack.push(reccuringNode.right);
            }
        }
    }
}