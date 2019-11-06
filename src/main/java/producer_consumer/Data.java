package producer_consumer;

/**
 * 数据实体
 */
@lombok.Data
public class Data {
    /**
     * 数据唯一id
     */
    private Integer id;

    /**
     * 数据内容列表，内有大量的数据需要累加
     */
    private long[] numbers;
}
