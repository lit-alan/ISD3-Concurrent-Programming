import concurrency.BasicStatisticsRunnable;
import concurrency.HypertensionRiskCallable;
import model.HealthRecord;
import concurrency.RegionSummaryCallable;
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

        //TASK 1
        executor.submit(new BasicStatisticsRunnable(data));


        //TASK 2
        //test with element 1 in the data list
        Future<String> hypertensionRisk = executor.submit(new HypertensionRiskCallable(data.get(1)));

//        System.out.println(hypertensionRisk.get());



        //TASK 3
        Future<Map<String, Double>> regionSummary =
                executor.submit(new RegionSummaryCallable(data, "South"));

        Map<String, Double> summary = regionSummary.get();
//
//        System.out.println("\n=== Region Summary (South) ===");
//        summary.forEach((k, v) ->
//                System.out.println(k + ": " + String.format("%.2f", v)));



        executor.shutdown();

    }
}