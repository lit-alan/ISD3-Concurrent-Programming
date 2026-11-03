package concurrency;


import model.HealthRecord;

import java.util.List;

public class BasicStatisticsRunnable implements Runnable {

    private List<HealthRecord> data;

    public BasicStatisticsRunnable(List<HealthRecord> data) {
        this.data = data;
    }

    @Override
    public void run() {
        double meanAge = data.stream().mapToInt(HealthRecord::getAge).average().orElse(0);
        double meanSleep = data.stream().mapToDouble(HealthRecord::getAvgSleepHours).average().orElse(0);
        double meanExercise = data.stream().mapToDouble(HealthRecord::getExerciseMinsPerWeek).average().orElse(0);
        double smokerPct = data.stream()
                .filter(p -> p.getSmoker().equalsIgnoreCase("Yes"))
                .count() * 100.0 / data.size();
        double meanDiet = data.stream().mapToDouble(HealthRecord::getDietQuality).average().orElse(0);

        //helper formatter to format the data to 2 decimal places
        java.util.function.DoubleFunction<String> fmt = v -> String.format("%.2f", v);

        System.out.println("=== Basic Statistics ===");
        System.out.println("Mean Age: " + fmt.apply(meanAge));
        System.out.println("Mean Sleep Hours: " + fmt.apply(meanSleep));
        System.out.println("Mean Exercise Minutes: " + fmt.apply(meanExercise));
        System.out.println("Mean Diet Quality: " + fmt.apply(meanDiet));
        System.out.println("Smoker Percentage: " + fmt.apply(smokerPct) + "%");
        System.out.println();
    }
}