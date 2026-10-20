# Java Concurrency Cheat Sheet 👇

## Executors, Runnable, Callable and Future


🧵 Concurrency allows a program to work on multiple tasks at the same time, rather than completing one task before starting another. It is important because it can make applications faster and more responsive, especially when handling multiple users, accessing databases or downloading data from the internet.

   

## 1. Runnable

A `Runnable` represents a task that can be executed by a thread. It does not return a result and cannot declare checked exceptions in its `run()` method.

```java
Runnable task = () -> {
    System.out.println("Task is running");
};

task.run(); //executes directly on the current thread
```

To execute it using a thread:

```java
Thread thread = new Thread(task);
thread.start();
```

Or submit it to an executor:

```java
ExecutorService executor =
        Executors.newFixedThreadPool(4);

executor.submit(task);
executor.shutdown();
```

**Key points**
- Method: `run()`
- Return type: `void`
- Cannot return a result.
- Cannot declare checked exceptions in `run()` - A checked exception is an error that Java requires you to handle when writing your code. You must either use a try-catch block to handle it or declare that the method can throw it using throws.
- Suitable for tasks such as printing output, processing data or even retrieving webpage titles 👀


---

## 2. Callable

A `Callable` represents a task that can return a result and throw a checked exception.

```java
Callable<Integer> task = () -> {
    return 10 + 20;
};
```

A `Callable` can also be written as:

```java
Callable<String> task = () -> "Hello";
```

To execute it using an executor:

```java
ExecutorService executor =
        Executors.newFixedThreadPool(4);

Future<Integer> future = executor.submit(task);

executor.shutdown();
```

**Key points**
- Method: `call()`
- Return type: a generic type, such as `Integer` or `String`.
- Can return a result.
- Can declare checked exceptions.
- Suitable for calculations, database queries or tasks where a result is required.

### Runnable vs Callable

| Feature | Runnable | Callable |
|---|---|---|
| Method | `run()` | `call()` |
| Return value | None (`void`) | Yes |
| Checked exceptions | Cannot declare them in `run()` | Allowed |
| Typical use | Perform an action | Compute or retrieve a result |
| Executor submission | `submit()` or `execute()` | `submit()` |

---

## 3. ExecutorService

An `ExecutorService` manages the execution of tasks. It allows you to submit tasks without manually creating and managing individual threads.

### Creating an executor

```java
ExecutorService executor =
        Executors.newFixedThreadPool(4);
```

This creates a thread pool with four worker threads.

Other common options:

```java
Executors.newSingleThreadExecutor();
Executors.newCachedThreadPool();
```

- `newFixedThreadPool(n)` - a fixed number of worker threads.
- `newSingleThreadExecutor()` - executes tasks sequentially using one worker thread.
- `newCachedThreadPool()` - creates and reuses threads as needed.

### Submitting tasks

Using `execute()`:

```java
executor.execute(() -> {
    System.out.println("Running task");
});
```

Using `submit()`:

```java
Future<?> future = executor.submit(() -> {
    System.out.println("Running task");
});
```

The main difference is that `submit()` returns a `Future`, whereas `execute()` does not return one.

### Shutting down an executor

```java
executor.shutdown();
```

This stops the executor from accepting new tasks but allows previously submitted tasks to finish.

```java
executor.shutdownNow();
```

This requests interruption of running tasks and attempts to cancel tasks that have not started.

**Important:** `shutdownNow()` does not guarantee that running tasks terminate immediately.

### Waiting for completion

```java
executor.shutdown();

try {
    if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
        System.out.println("All tasks completed");
    } else {
        System.out.println("Timeout waiting for tasks");
        executor.shutdownNow();
    }
} catch (InterruptedException e) {
    executor.shutdownNow();
    Thread.currentThread().interrupt();
}
```

`awaitTermination()` waits for the executor to terminate, provided it has been shut down. It returns `true` if termination occurs within the specified time, otherwise `false`.

---

## 4. Future

A `Future` represents the eventual result of a task submitted to an executor. The result might not be available immediately.

### Obtaining a Future

```java
Callable<Integer> task = () -> 100;

Future<Integer> future = executor.submit(task);
```

### Retrieving the result

```java
Integer result = future.get();

System.out.println(result);
```

`get()` waits until the result is available if the task has not finished.

It can throw:
- `InterruptedException` — the waiting thread is interrupted.
- `ExecutionException` — the task throws an exception.

### Checking whether a task has finished

```java
if (future.isDone()) {
    System.out.println("Task has completed");
}
```

`isDone()` returns `true` if the task has completed, failed or been cancelled. It does not necessarily mean the task succeeded.

### Cancelling a task

```java
future.cancel(true);
```

The argument `true` requests interruption if the task is running. Whether it stops depends on how the task handles interruption.

### Timed result retrieval

```java
try {
    Integer result = future.get(5, TimeUnit.SECONDS);
    System.out.println(result);
} catch (TimeoutException e) {
    System.out.println("Result not available within five seconds");
} catch (ExecutionException e) {
    System.out.println("Task failed: " + e.getCause());
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
```

**Important:** a timeout on `future.get()` stops the calling thread from waiting; it does not automatically cancel the underlying task.

---

## 5. How the components work together

The typical workflow is:

1. Define a task using `Runnable` or `Callable`.
2. Create an `ExecutorService`.
3. Submit the task to the executor.
4. Receive a `Future` if using `submit()`.
5. Retrieve the result or check task completion if required.
6. Shut down the executor when no more tasks will be submitted.

### Example: Multiple Callable tasks

```java
import java.util.concurrent.*;

public class ExecutorExample {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        Callable<Integer> task1 = () -> 10 + 20;
        Callable<Integer> task2 = () -> 30 + 40;
        Callable<Integer> task3 = () -> 50 + 60;

        Future<Integer> f1 = executor.submit(task1);
        Future<Integer> f2 = executor.submit(task2);
        Future<Integer> f3 = executor.submit(task3);

        executor.shutdown();

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("Task failed: " + e.getCause());
        }
    }
}
```

Possible output:

```text
30
70
110
```

The tasks can execute concurrently, although the calls to `get()` retrieve their results in the order shown in the code.

---

## 6. Quick reference

| Method | Purpose |
|---|---|
| `executor.execute(task)` | Submit a `Runnable`, without a returned `Future` |
| `executor.submit(task)` | Submit a task and return a `Future` |
| `future.get()` | Retrieve the result, waiting if necessary |
| `future.get(time, unit)` | Wait for a result up to a specified duration |
| `future.isDone()` | Check whether a task has completed |
| `future.cancel(true)` | Request cancellation and interruption |
| `executor.shutdown()` | Stop accepting new tasks; finish submitted tasks |
| `executor.shutdownNow()` | Request interruption and attempt to cancel queued tasks |
| `executor.isShutdown()` | Check whether shutdown has been initiated |
| `executor.isTerminated()` | Check whether all tasks have completed after shutdown |
| `executor.awaitTermination(time, unit)` | Wait for executor termination |

## 7. Common mistakes

**Mistake 1: Shutting down before submitting tasks**

```java
executor.shutdown();
executor.submit(task); // RejectedExecutionException
```

Correct order:

```java
executor.submit(task);
executor.shutdown();
```

**Mistake 2: Assuming `get()` is non-blocking**

```java
int result = future.get();
```

This may block until the task completes.

**Mistake 3: Assuming `shutdown()` kills running threads**

It does not. Previously submitted tasks are allowed to finish.

**Mistake 4: Assuming a `Future` contains the result immediately**

The result may not yet be available when the `Future` is returned.

**Mistake 5: Forgetting exception handling**

`Callable.call()` can throw checked exceptions, and exceptions thrown during task execution are reported through `ExecutionException` when the result is retrieved using `Future.get()`.

## 8. Putting it all together

> [!NOTE]  
>This program creates a list of five student objects and submits two tasks to an `ExecutorService` for concurrent execution. The first task implements Runnable and prints the details of each student, while the second implements `Callable` and calculates the average mark across all students. Both tasks receive the same list through their constructors. The `Callable` returns its result through a `Future`, allowing the main thread to retrieve the average mark using `get()`. This example demonstrates how multiple tasks can work with the same data, and highlights the key difference between `Runnable`, which does not return a result, and `Callable`, which does.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//Student class
class Student {

    private String name;
    private int studentId;
    private double mark;

    public Student(String name, int studentId, double mark) {
        this.name = name;
        this.studentId = studentId;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getMark() {
        return mark;
    }
}

//Runnable: prints all student records
class StudentDetailsTask implements Runnable {

    private List<Student> students;

    public StudentDetailsTask(List<Student> students) {
        this.students = students;
    }

    @Override
    public void run() {
        for (Student student : students) {
            System.out.println(
                    student.getStudentId() + " - "
                    + student.getName() + " - "
                    + student.getMark()
            );
        }
    }
}

//Callable: calculates the average mark
class AverageMarkTask implements Callable<Double> {

    private List<Student> students;

    public AverageMarkTask(List<Student> students) {
        this.students = students;
    }

    @Override
    public Double call() {
        double total = 0;

        for (Student student : students) {
            total += student.getMark();
        }

        return total / students.size();
    }
}

//main class
public class Main {

    public static void main(String[] args) {

        //Create a list of students
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice Murphy", 1001, 70));
        students.add(new Student("Brian Kelly", 1002, 85));
        students.add(new Student("Claire Walsh", 1003, 90));
        students.add(new Student("David Ryan", 1004, 65));
        students.add(new Student("Emma Doyle", 1005, 80));

        //Create the executor
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //reate tasks, passing the student list to each
        StudentDetailsTask runnableTask = new StudentDetailsTask(students);

        AverageMarkTask callableTask = new AverageMarkTask(students);

        //submit both tasks
        executor.submit(runnableTask);

        Future<Double> future = executor.submit(callableTask);

        //no more tasks will be submitted
        executor.shutdown();

        //Retrieve the average mark
        try {
            System.out.println("Average mark: " + future.get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("Task failed: " + e.getCause());
        }
    }
}

```

The output should be as follows:

```text
1001 - Alice Murphy - 70.0
1002 - Brian Kelly - 85.0
1003 - Claire Walsh - 90.0
1004 - David Ryan - 65.0
1005 - Emma Doyle - 80.0
Average mark: 78.0
```
```

