import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = "data/health_and_wellness_dataset.csv";
        List<HealthRecord> data = HealthDataLoader.load(filePath);

        if (data.isEmpty()) {
            System.err.println("No data loaded. Please check the file path or format.");
            return;
        }

        System.out.println("Loaded " + data.size() + " health records.\n");



    }
}