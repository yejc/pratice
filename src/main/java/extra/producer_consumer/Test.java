package extra.producer_consumer;

import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) {
        DataManager manager = new DataManager(10);

        int loop = 20;
        // 模拟生产者推数据
        for (int i = 0; i < loop; i++) {
            int id = i;
            new Thread(() -> {
                Data data = new Data();
                data.setId(id);
                data.setNumbers(LongStream.rangeClosed(0, id).toArray());
                manager.put(data);
            }).start();
        }

        // 模拟消费者消费数据
        while (true) {
            manager.takeAndProcessData();
        }
    }
}
