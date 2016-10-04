package io.github.toandv.algs4.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toan on 10/4/16.
 */
public class Tree<E> {

    Node<E> root;

    static class Node<E> {
        E val;
        List<Node<E>> children = new ArrayList<>();

        int size() {
            int sum = 0;
            for (Node<E> child : children) {
                // the leftest child
                sum += child.size();
                System.out.println(child.val);
            }
            return sum + 1;
        }
    }

    public Tree(E rootVal) {
        root = new Node<>();
        root.val = rootVal;
    }

    public int size() {
        return root.size();
    }

    public Tree<E> addSubTree(Tree<E> subTree) {
        root.children.add(subTree.root);
        return this;
    }

    // visit root
    // left subtree
    // visit right subtree
    static <E> void preorder(Node<E> root) {
        visit(root);
        for (Node<E> child : root.children) {
            preorder(child);
        }
    }

    // left subtree
    // visit right subtree
    // visit root
    static <E> void postorder(Node<E> root) {
        for (Node<E> child : root.children) {
            postorder(child);
        }
        visit(root);
    }

    // not well-defined for general trees
    static <E> void inorder(Node<E> root) {

    }

    static <E> void visit(Node<E> node) {
        System.out.println(node.val);
    }


    public static void main(String[] args) {

        Tree<String> root = new Tree<>("A");

        Tree<String> root1 = new Tree<>("B");
        Tree<String> child11 = new Tree<>("B.1");
        Tree<String> child12 = new Tree<>("B.2");
        Tree<String> child13 = new Tree<>("B.3");

        root1.addSubTree(child11);
        root1.addSubTree(child12);
        root1.addSubTree(child13);

        Tree<String> root2 = new Tree<>("C");
        Tree<String> child21 = new Tree<>("C.1");
        Tree<String> child22 = new Tree<>("C.2");
        root2.addSubTree(child21);
        root2.addSubTree(child22);

        root.addSubTree(root1);
        root.addSubTree(root2);

        //System.out.println(root.size());

        postorder(root.root);

    }

}
