package io.github.toandv.algs4.week01;

/**
 * Created by toan on 5/31/16.
 */
public interface UF {
    void union(int a, int b);

    boolean connected(int a, int b);

    default public String toString(int[] ids) {
        StringBuilder numBuf = new StringBuilder();
        StringBuilder idBuf = new StringBuilder();
        for (int i = 0; i < ids.length; i++) {
            numBuf.append(" " + i + " ");
            idBuf.append("[" + ids[i] + "]");
        }
        return numBuf + "\n" + idBuf;
    }
}
