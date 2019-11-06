package producer_consumer;

public interface Handler {
    long handle(Data data);
}