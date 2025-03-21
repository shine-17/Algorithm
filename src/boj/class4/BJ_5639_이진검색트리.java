package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_5639_이진검색트리 {
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
                    int node = Integer.parseInt(read);

                    graphs.add(node);
                }
            } catch (Exception ignored) {}

            root = new Node(graphs.poll(), null, null, null);
            Node parentNode = root;

            while (!graphs.isEmpty()) {
                int nodeValue = graphs.poll();

                if (nodeValue < root.value) {
                    Node left = new Node(nodeValue, parentNode, null, null);

                    if (parentNode.left == null) parentNode.left = left;
                    else graphs.addFirst(nodeValue);

                    parentNode = parentNode.left;
                }
                else {
                    Node right = new Node(nodeValue, parentNode, null, null);

                    if (parentNode.right == null) parentNode.right = right;
                    else graphs.addFirst(nodeValue);

                    parentNode = parentNode.right;
                }
            }

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
        Node root;
        Node left;
        Node right;

        public Node(Integer value, Node root, Node left, Node right) {
            this.value = value;
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }
}