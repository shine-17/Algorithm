package boj.class4;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1991_트리순회 {
    static HashMap<Character, Node> tree;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {

            tree = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                Character name = st.nextToken().charAt(0);

                char leftTemp = st.nextToken().charAt(0);
                char rightTemp = st.nextToken().charAt(0);

                Character left = leftTemp == '.' ? null : leftTemp;
                Character right = rightTemp == '.' ? null : rightTemp;

                Node parentNode = new Node(name, null, null, null);

                if (left != null) tree.put(left, new Node(left, parentNode, null, null));
                if (right != null) tree.put(right, new Node(right, parentNode, null, null));

                parentNode.left = tree.getOrDefault(left, null);
                parentNode.right = tree.getOrDefault(right, null);

                if (tree.get(name) != null) {
                    Node node = tree.get(name);
                    node.left = tree.getOrDefault(left, null);
                    node.right = tree.getOrDefault(right, null);
                }
                else {
                    tree.putIfAbsent(name, parentNode);
                }
            }

//            for (Map.Entry<Character, Node> entry : tree.entrySet()) {
//                System.out.println(entry.getKey() + " : " + entry.getValue());
//            }

            StringBuilder result = new StringBuilder();

            // 전위 순회
            preorder(tree.get('A'), result).append("\n");
            // 중위 순회
            inorder(tree.get('A'), result).append("\n");
            // 후위 순회
            postorder(tree.get('A'), result);

            System.out.println(result);

        } catch (Exception ignored) {}
    }

    // 전위 순회
    static StringBuilder preorder(Node node, StringBuilder result) {
        result.append(node.name);
        if (node.left != null) preorder(node.left, result);
        if (node.right != null) preorder(node.right, result);

        return result;
    }

    // 중위 순회
    static StringBuilder inorder(Node node, StringBuilder result) {
        if (node.left != null) inorder(node.left, result);
        result.append(node.name);
        if (node.right != null) inorder(node.right, result);

        return result;
    }

    // 후위 순회
    static StringBuilder postorder(Node node, StringBuilder result) {
        if (node.left != null) postorder(node.left, result);
        if (node.right != null) postorder(node.right, result);
        result.append(node.name);

        return result;
    }

    static class Node {
        Character name;
        Node parent;
        Node left;
        Node right;

        public Node(Character name, Node parent, Node left, Node right) {
            this.name = name;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name=" + name +
                    ", parent=" + (parent != null ? parent.name : null) +
                    ", left=" + (left != null ? left.name : null) +
                    ", right=" + (right != null ? right.name : null) +
                    '}';
        }
    }
}
