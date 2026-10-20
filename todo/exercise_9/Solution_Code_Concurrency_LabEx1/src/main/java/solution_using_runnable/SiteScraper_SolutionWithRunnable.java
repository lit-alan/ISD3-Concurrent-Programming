package solution_using_runnable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SiteScraper_SolutionWithRunnable {

    public static void main(String[] args) {

        //Start the time measurement
        long appStartTime = System.nanoTime();

        Path p = Paths.get("sites.txt");
        List<String> urls = new ArrayList<>(200);

        try {
            urls = Files.readAllLines(p);
        } catch (IOException ioe) {
            System.out.println("Error reading sites.txt: "
                    + ioe.getMessage());
            return;
        }

        //Get the number of cores on the machine
        int availableCores =
                Runtime.getRuntime().availableProcessors();


        //Start with twice the number of available cores
        int threadCount = availableCores * 2;

        //Create an ExecutorService to manage a thread pool
        ExecutorService executor =
                Executors.newFixedThreadPool(threadCount);

        //Submit a Runnable for each URL
        for (String url : urls) {
            executor.submit(new WebTitleRetrieverTask(url));
        }

        //No more tasks will be submitted
        executor.shutdown();

        try {
            // Wait up to three minutes for all tasks to finish
            if (executor.awaitTermination(3, TimeUnit.MINUTES)) {
                System.out.println("All tasks completed.");
            } else {
                System.out.println(
                        "Some tasks did not finish within three minutes."
                );

                // Request cancellation of unfinished tasks
                executor.shutdownNow();

                // Wait briefly for tasks to terminate
                if (!executor.awaitTermination(
                        5, TimeUnit.SECONDS)) {
                    System.out.println(
                            "Some tasks are still running."
                    );
                }
            }

        } catch (InterruptedException e) {
            System.out.println(
                    "Waiting for task termination was interrupted."
            );

            executor.shutdownNow();
            Thread.currentThread().interrupt();
        } finally {
            long appEndTime = System.nanoTime();

            double timeTakenInSeconds =
                    (appEndTime - appStartTime)
                            / 1_000_000_000.0;

            System.out.println(
                    "Time taken in seconds: "
                            + timeTakenInSeconds
            );
        }
    }


}

//A Runnable task to retrieve and print a webpage title
class WebTitleRetrieverTask implements Runnable {

    private final String url;

    //HttpClient for sending the requests
    private HttpClient client =
            HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(5))
                    .build();

    public WebTitleRetrieverTask(String url) {
        this.url = url;
    }

    @Override
    public void run() {

        long startTime = System.nanoTime();

        try {
            // Build the HTTP request with a five-second timeout
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofSeconds(5))
                    .build();

            // Send the request and receive the response
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            // Extract the title from the HTML
            String title = extractTitle(response.body());

            long timeTaken =
                    (System.nanoTime() - startTime)
                            / 1_000_000;

            System.out.println(
                    "Title from " + url + ": "
                            + title
                            + " (Time taken: "
                            + timeTaken + " ms)"
            );

        } catch (HttpTimeoutException e) {
            System.out.println(
                    "Skipped " + url
                            + " (request timed out after 5 seconds)"
            );

        } catch (InterruptedException e) {
            System.out.println(
                    "Task interrupted for: " + url
            );

            Thread.currentThread().interrupt();

        } catch (Exception e) {
            System.out.println(
                    "Error connecting to: " + url
                            + " (" + e.getMessage() + ")"
            );
        }
    }

    //Extract the title from the HTML content
    private static String extractTitle(String html) {

        Document doc = Jsoup.parse(html);
        String title = doc.title();

        if (title == null || title.isEmpty()) {
            return "No title found";
        }

        return title;
    }
}