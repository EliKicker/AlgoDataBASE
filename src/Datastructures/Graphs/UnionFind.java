package Datastructures.Graphs;

/*
    UNION FIND DATASTRUCTURE
 */

public class UnionFind {

    int[] parent;
    int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (size[a] > size[b]) {
            parent[b] = a;
            size[a] += size[b];
        } else {
            parent[a] = b;
            size[b] += size[a];
        }
    }
}