package ISD3_2025;

import model.HealthRecord;

import java.util.*;
import java.util.stream.Collectors;


public class HighBMIRunnable implements Runnable {
        private List<HealthRecord> data;
        private double threshold;

        public HighBMIRunnable(List<HealthRecord> data, double threshold) {
            this.data = data;
            this.threshold = threshold;
        }


    @Override
        public void run() {


            List<HealthRecord> filtered = data.stream()
                    .filter(r -> r.getBmi() >= threshold)
                    .toList();

            System.out.println("Total number of individuals with a BMI >= " + threshold + " is " + filtered.size());

            filtered.forEach(r ->
                    System.out.println("ID: " + r.getId() + ", BMI: " + r.getBmi())
            );

        }
}