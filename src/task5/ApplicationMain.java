package task5;

import task5.tree.SimpleBinaryTree;

public class ApplicationMain {
    public static void main(String[] args) {
        int[] elements = {20, 15, 30, 5, 40, 35, 45, 38};
        SimpleBinaryTree<Integer> tree = new SimpleBinaryTree<>();
        for(int el : elements){
            tree.add(el);
        }

        tree.printTree();
        tree.removeHalfNodes();
        tree.printTree();
    }
}
