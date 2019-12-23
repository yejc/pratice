package extra.producer_consumer;

import java.util.concurrent.*;

/**
 * 数据管理器，负责生产数据和消费数据
 */
public class DataManager {
    /**
     * 生产者
     */
    private Producer producer;

    /**
     * 消费者
     */
    private Consumer consumer;

    private ExecutorService executorService = new ThreadPoolExecutor(10, 20, 100, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    public DataManager(int maxLength) {
        BlockingQueue<Data> dataQueue = new ArrayBlockingQueue<>(maxLength);
        producer = new Producer(dataQueue);
        consumer = new Consumer(dataQueue);
    }

    public void put(Data data) {
        producer.put(data);
    }

    public void takeAndProcessData() {
        // 消费者采用线程池执行
        executorService.execute(() -> {
            Data data = consumer.take();
            processData(data);
        });
    }

    private void processData(Data data) {
        ForkJoinHandler handler = new ForkJoinHandler();
        long result = handler.handle(data);
        System.out.println("result is " + result);
    }
}
