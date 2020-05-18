package com.company;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        int menu;
        List <ThreadNode> threads = new ArrayList<ThreadNode>();
        long ts_b, ts_e;
        Scanner sc = new Scanner(System.in);
        Node root = new Node("A");
        root.left = new Node ("B",root);
        root.right = new Node("C",root);
        root.left.left = new Node("D",root.left);
        root.left.right = new Node("E",root.left);
        root.right.left = new Node("F",root.right);
        root.right.right = new Node("G",root.right);
        root.right.left.right = new Node("K",root.right.left);
        root.right.left.right.left = new Node("L",root.right.left.right);
        Stack stack = new Stack();
        System.out.println("Enter 1 DataSet is already in program "
                +"Enter 2 for random Graf"
                +"Enter 3 read from File");
        menu = sc.nextInt();
        switch (menu){
            case 1 : {
                root = new Node("A");
                root.left = new Node ("B",root);
                root.right = new Node("C",root);
                root.left.left = new Node("D",root.left);
                root.left.right = new Node("E",root.left);
                root.right.left = new Node("F",root.right);
                root.right.right = new Node("G",root.right);
                root.right.left.right = new Node("K",root.right.left);
                root.right.left.right.left = new Node("L",root.right.left.right);
                stack.push(root);
                break;
            }
            case 2 : {
                Random r = new Random();
                stack.push(r.FillGraf());
                System.out.println("Enter the file's name .txt");
                String nameFile = sc.next();
                FileWriterRandomData fw = new FileWriterRandomData(r.root,nameFile);
                break;
            }
            case 3 : {
                FileNode f = new FileNode();
                f.readFile();
                root = f.root;
                stack.push(root);
                break;
            }
        }
        ts_b = Calendar.getInstance().getTimeInMillis();
        Node reccuringNode = (Node) stack.pop();
        while(reccuringNode!=null){
           threads.add(new ThreadNode(reccuringNode));
            reccuringNode = reccuringNode.right;
        }
        for(int i = 0; i < threads.size();i++){
            threads.get(i).t.join();
        }
        ts_e = Calendar.getInstance().getTimeInMillis();
        System.out.println("Time " + (ts_e - ts_b));

    }
}
