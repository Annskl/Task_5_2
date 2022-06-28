package task5.tree;

public class SimpleBinaryTree<K extends Comparable<K>> {
    private Node<K> root; //корень
    private int size;

    public SimpleBinaryTree() {}

    static class Node<K> {
        K key;          //значение
        Node<K> left;  //левый
        Node<K> right; //правый

        public Node(K key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "" + key;
        }
    }

    //добавление
    public void add(K key) {
        Node<K> newNode = new Node<>(key);

        if (root == null) {
            root = newNode;
            return;
        }

        Node<K> current = root;
        while (true) {
            if (key.compareTo(current.key) > 0) {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                }
                current = current.right;
            } else if (key.compareTo(current.key) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    break;
                }
                current = current.left;
            } else {
                return;
            }
        }
        size++;
    }

    public void printTree(){
        StringBuilder treeBuilder = new StringBuilder();
        printTree(treeBuilder, "", "", root, false);
        System.out.println(treeBuilder);
    }

    private void printTree(StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.key);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.right != null) ? "├──" : "└──";

            printTree(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            printTree(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }

    public void removeHalfNodes(){
        root = removeHalfNodes(root);
    }

    private Node<K> removeHalfNodes(Node<K> node) {
        if (node == null){
            return null;
        }

        node.left = removeHalfNodes(node.left);
        node.right = removeHalfNodes(node.right);

        //если узел является листом, то не изменяем его
        if (node.left == null && node.right == null){
            return node;
        }

        //если потомок правый, то заменяем удаляемый узел им
        if (node.left == null) {
            return node.right;
        }

        //если потомок левый, то заменяем удаляемый узел им
        if (node.right == null) {
            return node.left;
        }

        return node;
    }
}


