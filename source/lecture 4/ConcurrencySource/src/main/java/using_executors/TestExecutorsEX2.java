package using_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Creates a fixed thread pool containing up to n worker threads.
 *
 * - The pool creates threads as tasks are submitted, up to a maximum of n.
 * - If all n threads are busy, additional tasks wait in a queue until a
 *   thread becomes available.
 * - When a thread finishes a task, it can be reused to execute another task.
 * - The pool limits the number of worker threads, helping to control resource
 *   usage when executing multiple tasks concurrently.
 *
 * This is useful when you want to execute tasks concurrently while limiting
 * the maximum number of threads being used.
 */
public class TestExecutorsEX2 {

    public static void main(String[] args) {

       //Creates a thread pool containing up to 2 worker threads.
       ExecutorService exe = Executors.newFixedThreadPool(2);

        exe.submit(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Hello " + i);
            }
        });

        exe.submit(() -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Goodbye " + i);
            }
        });

        try {
            System.out.println("Attempting to shutdown");
            exe.shutdown();
            exe.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Tasks Interrupted" + e);
        } finally {
            if (!exe.isTerminated()) {
                System.err.println("All running tasks have been cancelled");
            }
            exe.shutdownNow();
            System.out.println("Shutdown complete");
        }

    }//end main
    
}
