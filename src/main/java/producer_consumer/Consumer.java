package producer_consumer;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 */
public class Consumer {
    private BlockingQueue<Data> dataQueue;

    public Consumer(BlockingQueue<Data> blockingQueue) {
        this.dataQueue = blockingQueue;
    }

    public Data take() {
        try {
            return dataQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }
}
