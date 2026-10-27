import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class HealthDataLoader {

    public static List<HealthRecord> load(String filePath) {
        List<HealthRecord> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); //Skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                //Ensure correct column count
                if (parts.length < 20) continue;

                try {
                    int id = Integer.parseInt(parts[0]);
                    int age = Integer.parseInt(parts[1]);
                    String gender = parts[2];
                    double heightCm = Double.parseDouble(parts[3]);
                    double weightKg = Double.parseDouble(parts[4]);
                    double bmi = Double.parseDouble(parts[5]);
                    double avgSleepHours = Double.parseDouble(parts[6]);
                    double exerciseMinsPerWeek = Double.parseDouble(parts[7]);
                    double dietQuality = Double.parseDouble(parts[8]);
                    String smoker = parts[9];
                    double alcoholUnitsPerWeek = Double.parseDouble(parts[10]);
                    double systolicBp = Double.parseDouble(parts[11]);
                    double diastolicBp = Double.parseDouble(parts[12]);
                    double cholesterolMgDl = Double.parseDouble(parts[13]);
                    double glucoseMgDl = Double.parseDouble(parts[14]);
                    String hasHypertension = parts[15];
                    String hasDiabetes = parts[16];
                    String region = parts[17];
                    double stressLevel = Double.parseDouble(parts[18]);
                    double mentalHealthScore = Double.parseDouble(parts[19]);

                    HealthRecord record = new HealthRecord(
                            id, age, gender, heightCm, weightKg, bmi, avgSleepHours,
                            exerciseMinsPerWeek, dietQuality, smoker, alcoholUnitsPerWeek,
                            systolicBp, diastolicBp, cholesterolMgDl, glucoseMgDl,
                            hasHypertension, hasDiabetes, region, stressLevel, mentalHealthScore
                    );

                    records.add(record);

                } catch (NumberFormatException e) {
                    System.err.println("Skipping malformed row: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }

        return records;
    }
}
