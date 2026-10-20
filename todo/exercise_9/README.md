## Lab Exercise 9️⃣ - Web Scraping with Concurrency

Observe the starter code for this lab exercise. It reads a list of URLs from a file called `sites.txt` and processes each URL by retrieving the webpage title. It uses `HttpClient` to send `HTTP` requests to the
URLs and receive the HTML response. The title of each webpage is extracted using `Jsoup`, a Java HTML parser library. The program measures the time taken to retrieve each title and prints both the
title and the time taken. Additionally, it measures the total execution time of the entire application.


  

Error handling is included to manage any issues with reading URLs or sending requests.


     
For this exercise, refactor the original code to improve efficiency and scalability by using multithreading. Instead of processing each URL sequentially, implement an `ExecutorService` with a thread pool to process multiple URLs concurrently. 

You have the option to implement the task as either a `Runnable` or a `Callable`. A `Runnable` allows you to run tasks without returning a result, while a `Callable` can return results, such as the webpage title, which you can retrieve later. Refactor the
existing logic for retrieving and printing webpage titles into either a `Runnable` or `Callable` class, and then submit each task to the thread pool. If you choose `Callable`, consider how you will retrieve and print the results after task completion using `Future`.

  
You should notice a speed-up in the application's performance after refactoring it to use multithreading. In the original sequential version, the program processes one URL at a time, meaning that each HTTP request must complete before the next one can start. This can result in
significant delays, especially when network latency or server response times are high.

  
By using multithreading with an `ExecutorService`, the program can process multiple URLs concurrently, taking advantage of the available CPU cores and network resources. Since most of the task involves waiting for HTTP responses having multiple threads working in parallel allows the
program to initiate and handle multiple requests simultaneously, improving throughput and reducing the overall execution time.

  
If only a few URLs are being processed, the difference in performance between the starter code and the refactored version may not be significant. For a larger set of URLs, the improvement should be more noticeable.

_`HttpClient` is a class in the Java Standard Library, introduced in Java 11, that provides an efficient way to send HTTP requests and handle HTTP responses._
