// Show the contents of the id[] array and the number of times the array
// is accessed for each input pair when you use quick-find, quick-union,
// and weighted quick-union for the sequence
// 9-0 3-4 5-8 7-2 2-1 5-7 0-3 4-2.
//TO RUN: java-algs4 UnionFindVariations input.txt //TODO change this towards end

import edu.princeton.cs.algs4.In;
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

    public boolean quickFind_connected(int p, int q) {
        return quickFind_find(p) == quickFind_find(q);
    }

    //quickFind -->
    public int quickFind_find(int p) {
        return id[p];
    }

    public void quickFind_union(int p, int q) {
        int qID = quickFind_find(p);
        int pID = quickFind_find(q);
        if (pID == qID)
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == qID)
                id[i] = pID;
        }
        count--;

    }
    
    //quickUnion
    //weightedQuickUnion

    public static void main(String[] args) {
        In in = new In(args[0]);
        int N = in.readInt();
        UnionFindVariations uF = new UnionFindVariations(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (uF.quickFind_connected(p, q)) {
                continue;
            } //need to change this t ofit other UF variations
            uF.quickFind_union(p, q); //same here; what's the best way to do this?
            StdOut.println(p + " " + q);
        }
        StdOut.println(uF.count() + " components");
    }

    //quick find
}
