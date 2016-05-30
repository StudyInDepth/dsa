package io.github.toandv.algs4.week01;

/**
 * Created by toan on 5/31/16.
 */
public class QuickUnionUF implements UF {
    private int[] id;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    @Override
    public void union(int a, int b) {
        // set a's root's parent to b's root
        int aRoot = root(a);
        id[aRoot] = root(b);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return toString(id);
    }

    private int root(int i) {
        // if id[a] == a => root of a = a
        // else if id[id[a]] == id[a] => root of a = id[a]
        // ...  id[id[..[id[a]]..]] == id[..[id[a]..]] => root of a = id[..[id[a]]..]
        while (i != id[i]) {
           i = id[i];
        }
        return i;
    }

    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(10);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(2, 3);
        System.out.println(uf.connected(2, 4));
        System.out.println(uf.connected(2, 5));
    }
}
