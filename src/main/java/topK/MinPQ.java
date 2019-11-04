package topK;

public class MinPQ {
    private int[] pq;
    private int N = 0;

    public MinPQ(int maxN) {
        pq = new int[maxN + 1];
    }

    public void insert(int c) {
        pq[++N] = c;
        swim(N);
    }

    public int delMin() {
        int v = pq[1];
        exch(1, N);
        pq[N--] = 0;
        sink(1);
        return v;
    }

    public int showMin() {
        return pq[1];
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && pq[j] > pq[j + 1]) {
                j++;
            }
            if (pq[j] >= pq[k]) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && pq[k / 2] > (pq[k])) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    private void exch(int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
