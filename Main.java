import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {

        Counter counter = new Counter();
        SyncCounter syncCounter = new SyncCounter();

        int tasks = 10;
        int increments = 100_000;

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < tasks; i++) {

            executor.submit(() -> {

                for (int j = 0; j < increments; j++) {
                    counter.increment();
                    syncCounter.increment();
                }
            });
        }

        executor.shutdown();

        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Expected value: " + (tasks * increments));
        System.out.println("Counter value: " + counter.value());
        System.out.println("SyncCounter value: " + syncCounter.value());
    }
}