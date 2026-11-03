package ISD3_2025;

import model.HealthRecord;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
public class RegionHealthScoreCallable implements Callable<Map<String, Double>> {
    private List<HealthRecord> data;

    public RegionHealthScoreCallable(List<HealthRecord> data) {
        this.data = data;
    }

    @Override
    public Map<String, Double> call() {

        //Group by region and compute averages in one step
        return data.stream()
                .collect(Collectors.groupingBy(
                        r -> (r.getRegion() != null && !r.getRegion().isEmpty()) ? r.getRegion() : "Unknown",
                        Collectors.averagingDouble(HealthRecord::getMentalHealthScore)
                ));
    }
}