package ISD3_2025;

import model.HealthRecord;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class OutlierDetectionCallable implements Callable<List<HealthRecord>> {
    private List<HealthRecord> data;

    public OutlierDetectionCallable(List<HealthRecord> data) {
        this.data = data;
    }

    @Override
    public List<HealthRecord> call() {
        double mean = data.stream().mapToDouble(HealthRecord::getCholesterolMgDl).average().orElse(0);
        double std = Math.sqrt(data.stream()
                .mapToDouble(r -> Math.pow(r.getCholesterolMgDl() - mean, 2))
                .average()
                .orElse(0));
        double lower = mean - 2 * std;
        double upper = mean + 2 * std;

        return data.stream()
                .filter(r -> r.getCholesterolMgDl() < lower || r.getCholesterolMgDl() > upper)
                .collect(Collectors.toList());
    }
}