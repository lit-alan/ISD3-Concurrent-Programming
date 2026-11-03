import ISD3_2025.HighBMIRunnable;
import ISD3_2025.LifestyleSummaryRunnable;
import ISD3_2025.RegionHealthScoreCallable;
import model.HealthRecord;
import service.HealthDataLoader;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = "data/health_and_wellness_dataset.csv";
        List<HealthRecord> data = HealthDataLoader.load(filePath);

        if (data.isEmpty()) {
            System.err.println("No data loaded. Please check your CSV path or format.");
            return;
        }

        System.out.println("Loaded " + data.size() + " health records.\n");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //TASK ONE
        final int BMI_THRESHOLD = 37;
        Runnable highBmiTask = new HighBMIRunnable(data, BMI_THRESHOLD);
        executor.submit(highBmiTask);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //TASK TWO
        Runnable lifestyleTask = new LifestyleSummaryRunnable(data);
//        executor.submit(lifestyleTask);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////




        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //TASK THREE
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Create an instance of the callable
        Callable<Map<String, Double>> regionScoreTask = new RegionHealthScoreCallable(data);

        //Submit the callable to the executor and get a Future
        Future<Map<String, Double>> regionFuture = executor.submit(regionScoreTask);

        //Retrieve the result (blocking call until the computation is complete)
        Map<String, Double> regionScores = regionFuture.get();

        //Display results in a structured format
//        System.out.println("\n=== Average Mental Health Scores by Region ===");
//        regionScores.forEach((region, score) ->
//                System.out.printf("%-10s : %.2f%n", region, score)
//        );



        executor.shutdown();

    }
}