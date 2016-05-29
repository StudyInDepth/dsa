package io.github.toandv.algs4.week0;

/**
 * Created by toan on 5/29/16.
 * http://stackoverflow.com/questions/141525/what-are-bitwise-shift-bit-shift-operators-and-how-do-they-work
 */
public class BinarySearch {

    public static int bsearch1(int[] a, int key) {
        return rsearch(a, key, 0, a.length - 1);
    }

    public static int bsearch2(int[] a, int key) {
        return search(a, key, 0, a.length - 1);
    }

    /**
     * Recursive implementation
     */
    static int rsearch(int[] a, int key, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) >>> 1;
        printMid(a, mid);
        if (key == a[mid]) {
            return mid;
        }
        if (key < a[mid]) {
            return rsearch(a, key, lo, mid - 1);
        } else {
            return rsearch(a, key, mid + 1, hi);
        }
    }

    static int search(int[] a, int key, int fromIndex, int toIndex) {
        int lo = fromIndex;
        int hi = toIndex;
        // lo = hi => (lo - hi) / 2 = 0 => mid is empty
        while (lo <= hi) {
            // Divide by 2.
            int mid = (hi + lo) >>> 1;
            // printMid(a, mid);
            int midVal = a[mid];
            if (key < midVal) {
                hi = mid - 1;
            } else if (key > midVal) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 2, 4};
        //int in = bsearch1(a, 2);
        //System.out.println(in);
        // a = removeDuplicates(a);
        printMid(a, 0);
        int j = removeDuplicatesNaive(a);
        printMid(a, j);

    }

    public static void printMid(int[] a, int mid) {
        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < a.length; i++) {
            if (i == mid) {
                sb.append("[" + a[i] + "] ");
            } else {
                sb.append(a[i] + " ");
            }
        }
        sb.append("}");
        System.out.println(sb);
    }


    public static int[] removeDuplicates(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int dupIndex;
            while ((dupIndex = search(a, a[i], i + 1, a.length - 1)) != -1) {
                a = remove(a, dupIndex);
            }
        }
        return a;
    }

    public static int[] remove(int[] a, int del) {
        int[] result = new int[a.length - 1];
        System.arraycopy(a, 0, result, 0, del);
        System.arraycopy(a, del + 1, result, del, a.length - del - 1);
        return result;
    }

    // Manipulate original array
    // http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-array-java/
    public static int removeDuplicatesNaive(int[] a) {
        if (a.length < 2)
            return a.length;
        int less = 0;
        int greater = 1;
        // {1, 1, 1, 2, 2, 2, 4};
        while (greater < a.length) {
            if (a[less] == a[greater]) {
                greater++;
            } else {
                less++;
                a[less] = a[greater];
                greater++;
            }
        }
        return less + 1;
    }

}
