package topK;

public class TopKTest {
    public static void main(String[] args) {
        int top = 3;
        MinPQ pq = new MinPQ(top);
        int[] data = {12, 1, 4, 22, 7, 4, 7, 54};
        for (int i = 0; i < data.length; i++) {
            if (i < top) {
                pq.insert(data[i]);
            } else {
                if (pq.showMin() < data[i]) {
                    pq.delMin();
                    pq.insert(data[i]);
                }
            }
        }
        System.out.println("前" + top + "大的数字为：");
        for (int i = 0; i < top; i++) {
            System.out.print(pq.delMin() + " ");
        }

    }
}
