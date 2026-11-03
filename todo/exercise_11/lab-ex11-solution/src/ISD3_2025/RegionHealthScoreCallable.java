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

        //Group the HealthRecord objects by region. If a record has a null or empty
        //region, assign it to the "Unknown" group. For each region, calculate the
        //average mental health score by retrieving the score from each record,
        //summing the scores and dividing by the number of records in that group.
        //Store the results in a Map where the region is the key and the average
        //mental health score is the value.
        return data.stream()
                .collect(Collectors.groupingBy(
                        r -> (r.getRegion() != null && !r.getRegion().isEmpty()) ? r.getRegion() : "Unknown",
                        Collectors.averagingDouble(HealthRecord::getMentalHealthScore)
                ));

        //groupingBy() returns a Map, using the region as the key and the of the second collector (averagingDouble()) as the value.
    }
}