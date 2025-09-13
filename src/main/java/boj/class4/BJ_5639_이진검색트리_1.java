package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BJ_5639_이진검색트리_1 {
    static Node root;
    static ArrayDeque<Integer> graphs = new ArrayDeque<>();
    static List<Integer> postOrder = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {

            try {
                String read;
                while ((read = br.readLine()) != null) {
                    if (read.isEmpty()) break;
                    int value = Integer.parseInt(read);

                    Node node = new Node(value);
                    if (root == null) root = node;
                    else {
                        root.add(value);
                    }
                }
            } catch (Exception ignored) {}

            postOrder(root);

            StringBuilder result = new StringBuilder();
            for (Integer node : postOrder) {
                result.append(node).append("\n");
            }

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    static void postOrder(Node node) {
        if (node == null) return;
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);

        postOrder.add(node.value);
    }

    static class Node {
        Integer value;
        Node left;
        Node right;

        public Node(Integer value) {
            this.value = value;
        }

        public void add(int value) {
            if (value < this.value) {
                if (this.left == null) this.left = new Node(value);
                else this.left.add(value);
            }
            else {
                if (this.right == null) this.right = new Node(value);
                else this.right.add(value);
            }
        }
    }
}