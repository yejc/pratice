package extra.producer_consumer;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 */
@lombok.Data
public class Producer {
    private BlockingQueue<Data> dataQueue;

    public Producer(BlockingQueue<Data> blockingQueue) {
        this.dataQueue = blockingQueue;
    }

    public void put(Data data) {
        try {
            dataQueue.put(data);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
