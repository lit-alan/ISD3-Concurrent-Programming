package using_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Creates a cached thread pool that manages threads for executing tasks.
 *
 * How it works:
 * - The pool initially contains zero threads.
 * - When a task is submitted, the pool reuses an idle thread if one is available.
 * - If no idle thread is available, the pool creates a new thread to execute the task.
 * - When a thread finishes a task, it becomes available to execute another task.
 * - Threads that remain idle for approximately 60 seconds can be removed from the pool.
 * - The pool has no fixed maximum number of threads and can create additional
 *   threads as demand increases.
 *
 * Using a cached thread pool avoids repeatedly creating new threads when existing
 * threads can be reused. However, submitting many tasks simultaneously can cause
 * the pool to create a large number of threads, potentially consuming excessive
 * system resources.
 *
 * Example:
 * ExecutorService executor = Executors.newCachedThreadPool();
 */

public class TestExecutorsEX1 {

    public static void main(String[] args) {
      
        Runnable goodbye = () -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Goodbye " + i);
            }

        };

        Runnable hello = () -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Hello " + i);
            }

        };
        
        ExecutorService exe = Executors.newCachedThreadPool();
        exe.submit(hello);
        exe.submit(goodbye);
        
      
    }//end main
    
}
