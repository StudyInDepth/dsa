package io.github.toandv.algs4.week01;

/**
 * Created by toan on 5/30/16.
 */
public class QuickFindUF implements UF {
    private int[] id;

    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int a, int b) {
        int aid = id[a];
        int bid = id[b];

        if (aid == bid) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if(id[i] == bid) {
                id[i] = aid;
            }
        }

        System.out.println(this);
    }

    // if no init
    public void union1(int a, int b) {
        rangeCheck(a, b);
        if (id[a] == 0 && id[b] == 0) {
            id[a] = a + 1;
            id[b] = a + 1;
        } else if (id[a] == 0) {
            id[a] = id[b];
        } else if (id[b] == 0) {
            id[b] = id[a];
        } else {
            if (id[a] == id[b]) {
                return;
            }
            for (int i = 0; i < id.length; i++) {
                if (id[i] == id[b]) {
                    id[i] = id[a];
                }
            }
        }
        System.out.println(this);
    }

    private void rangeCheck(int a, int b) {
        if (a > id.length || b > id.length) {
            throw new IllegalArgumentException("Max value is: " + id.length);
        }
    }

    @Override
    public boolean connected(int a, int b) {
        rangeCheck(a, b);
        return id[a] == id[b];
    }

    @Override
    public String toString() {
        return toString(id);
    }

    public static void main(String[] args) {
        QuickFindUF uf = new QuickFindUF(10);
        System.out.println(uf);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(5, 6);
        uf.union(7, 8);
        uf.union(1, 9);
        uf.union(3, 9);
        System.out.println(uf.connected(1, 2));
        System.out.println(uf.connected(1, 8));

    }



}
