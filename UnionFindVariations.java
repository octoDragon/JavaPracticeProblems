// Show the contents of the id[] array and the number of times the array
// is accessed for each input pair when you use quick-find, quick-union,
// and weighted quick-union for the sequence
// 9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-2.
//TO RUN: java-algs4 UnionFindVariations input.txt //TODO change this towards end

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindVariations {
    private int[] id;
    private int count;

    //used by every variation
    public UnionFindVariations(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //quickFind -->
    public int quickFind_find(int p) {
    }

    public int quickFind_union(int p, int q) {

    }

    //quickUnion
    //weightedQuickUnion

    public static void main(String[] args) {
        In in = new In(args[0]);
        int N = in.readInt();
        UnionFindVariations uF = new UnionFindVariations(N);
        while (!in.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uF.connected(p, q)) continue;
            uF.union(p, q);
            StdOut.println(p + " " + q);
        }

    }

    //quick find
}
