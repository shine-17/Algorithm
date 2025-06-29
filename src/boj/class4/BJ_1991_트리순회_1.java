package boj.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1991_트리순회_1 {
    static Node parentNode;
    static Map<Character, Node> map = new HashMap<>();
    static StringBuilder order = new StringBuilder();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            int n = Integer.parseInt(br.readLine());

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                Character current = st.nextToken().charAt(0);
                Character left = st.nextToken().charAt(0);
                Character right = st.nextToken().charAt(0);

                Node leftNode = map.get(left);
                if (left == '.') left = null;
                else if (!map.containsKey(left)) {
                    leftNode = new Node(left, null, null, null);
                    map.put(left, leftNode);
                }

                Node rightNode = map.get(right);
                if (right == '.') right = null;
                else if (!map.containsKey(right)) {
                    rightNode = new Node(right, null, null, null);
                    map.put(right, rightNode);
                }

                Node node = new Node(current, null, leftNode, rightNode);
                if (!map.containsKey(current)) {
                    map.put(current, node);
                }
                else {
                    map.get(current).left = leftNode;
                    map.get(current).right = rightNode;
                }

                if (map.containsKey(left)) map.get(left).parent = node;
                if (map.containsKey(right)) map.get(right).parent = node;

                if (current == 'A') parentNode = node;
            }

            StringBuilder result = new StringBuilder();

            preOrder(parentNode);
            result.append(order).append("\n");
            order.setLength(0);

            inOrder(parentNode);
            result.append(order).append("\n");
            order.setLength(0);

            postOrder(parentNode);
            result.append(order).append("\n");
            order.setLength(0);

            System.out.println(result);

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    static void preOrder(Node node) {
        if (node == null) return;

        order.append(node.value);

        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        order.append(node.value);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        order.append(node.value);
    }

    static class Node {
        Character value;
        Node parent;
        Node left;
        Node right;

        public Node(Character value, Node parent, Node left, Node right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
