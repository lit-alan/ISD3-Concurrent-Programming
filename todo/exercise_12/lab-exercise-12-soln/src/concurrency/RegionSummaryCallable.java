package concurrency;

import model.HealthRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class RegionSummaryCallable implements Callable<Map<String, Double>> {

    private final List<HealthRecord> data;
    private final String region;

    public RegionSummaryCallable(List<HealthRecord> data, String region) {
        this.data = data;
        this.region = region;
    }

    @Override
    public Map<String, Double> call() {

        // Filter dataset to only include participants in the specified region
        List<HealthRecord> regionData = data.stream()
                .filter(r -> r.getRegion().equalsIgnoreCase(region))
                .collect(Collectors.toList());

        Map<String, Double> summary = new HashMap<>();

        int total = regionData.size();
        if (total == 0) {
            // Avoid divide-by-zero problems
            summary.put("alcohol_high_pct", 0.0);
            summary.put("metabolic_syndrome_pct", 0.0);
            summary.put("sample_size", 0.0);
            return summary;
        }

        // Alcohol above recommended limits
        // Simple threshold: > 14 units per week
        double alcoholHighPct = regionData.stream()
                .filter(p -> p.getAlcoholUnitsPerWeek() > 14)
                .count() * 100.0 / total;

        // Metabolic Syndrome Markers %
        // Criteria: MUST meet >= 3 of these:
        // 1. BMI ≥ 30
        // 2. Systolic ≥ 130 OR Diastolic ≥ 85
        // 3. Cholesterol ≥ 200
        // 4. Glucose ≥ 100
        // 5. Exercise < 90
        double metabolicSyndromePct = regionData.stream()
                .filter(p -> {
                    int count = 0;
                    if (p.getBmi() >= 30) count++;
                    if (p.getSystolicBp() >= 130 || p.getDiastolicBp() >= 85) count++;
                    if (p.getCholesterolMgDl() >= 200) count++;
                    if (p.getGlucoseMgDl() >= 100) count++;
                    if (p.getExerciseMinsPerWeek() < 90) count++;
                    return count >= 3;
                })
                .count() * 100.0 / total;

        // Populate output map
        summary.put("alcohol_high_pct", alcoholHighPct);
        summary.put("metabolic_syndrome_pct", metabolicSyndromePct);
        summary.put("sample_size", (double) total);

        return summary;
    }
}
