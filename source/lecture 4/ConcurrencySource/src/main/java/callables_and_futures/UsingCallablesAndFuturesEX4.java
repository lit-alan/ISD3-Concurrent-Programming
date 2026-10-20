package callables_and_futures;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class UsingCallablesAndFuturesEX4 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Callable<String>> callables = Arrays.asList(
                prepareCallable("Monday", ThreadLocalRandom.current().nextInt(1, 5 + 1)),
                prepareCallable("Tuesday", ThreadLocalRandom.current().nextInt(1,  5 + 1)),
                prepareCallable("Wednesday", ThreadLocalRandom.current().nextInt(1,  5 + 1)),
                prepareCallable("Thursday", ThreadLocalRandom.current().nextInt(1,  5 + 1)),
                prepareCallable("Friday", ThreadLocalRandom.current().nextInt(1,  5 + 1)),
                prepareCallable("Saturday", ThreadLocalRandom.current().nextInt(1,  5 + 1)),
                prepareCallable("Sunday", ThreadLocalRandom.current().nextInt(1, 5 + 1)));

        String future = executor.invokeAny(callables);

        System.out.println(future);

        executor.shutdownNow();

    }

    static Callable<String> prepareCallable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }
}

