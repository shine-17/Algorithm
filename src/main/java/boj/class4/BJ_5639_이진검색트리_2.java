package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_5639_이진검색트리_2 {

    static Node root;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            root = new Node(Integer.parseInt(br.readLine()));

            String str;
            while ((str = br.readLine()) != null) {
                root.add(Integer.parseInt(str));
            }

            postOrder(root);
            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        result.append(node.value).append("\n");
    }

    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public void add(int value) {
            if (value < this.value) {
                if (this.left != null) this.left.add(value);
                else this.left = new Node(value);
            }
            else {
                if (this.right != null) this.right.add(value);
                else this.right = new Node(value);
            }
        }
    }
}
