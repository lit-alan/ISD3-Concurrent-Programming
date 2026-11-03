package ISD3_2025;

import model.HealthRecord;

import java.util.*;
import java.util.stream.*;

public class LifestyleSummaryRunnable implements Runnable {
    private List<HealthRecord> data;

    public LifestyleSummaryRunnable(List<HealthRecord> data) {
        this.data = data;
    }

    @Override
    public void run() {

        //Variables to store the total exercise minutes for each group.
        //We maintain separate totals for smokers and non-smokers.
        double smokerExercise = 0;
        double nonSmokerExercise = 0;

        //Variables to store the total diet quality scores for each group.
        double smokerDiet = 0;
        double nonSmokerDiet = 0;

        //Counters to keep track of the number of records in each group.
        //these will be used to calc the average for each grp.
        int smokerCount = 0;
        int nonSmokerCount = 0;

        //Print a heading for the summary.
        System.out.println("=== Lifestyle Summary by Smoking Status ===");

        //iterate through every HealthRecord object in the data collection.
        for (HealthRecord record : data) {

            //check whether the current person is a smoker.
            if (record.getSmoker().equalsIgnoreCase("Yes")) {

                //add this person's weekly exercise minutes to the running total for smokers.
                smokerExercise += record.getExerciseMinsPerWeek();

                //ad this person's diet quality score to the running total for smokers.
                smokerDiet += record.getDietQuality();

                //incr the smoker counter because we have processed another smoker's record.
                smokerCount++;
            }
            else {

                //this person is not a smoker so add their weekly exercise minutes to the running total for non-smokers.
                nonSmokerExercise += record.getExerciseMinsPerWeek();

                //add their diet quality score to the running total for non-smokers.
                nonSmokerDiet += record.getDietQuality();

                //incr the non-smoker counter.
                nonSmokerCount++;
            }
        }

        //calculate and display the averages for smokers.
        //We must check that at least one smoker was found to avoid dividing by zero.
        if (smokerCount > 0) {

            //average = total exercise minutes / number of smokers.
            double avgExercise = smokerExercise / smokerCount;

            //average = total diet quality / number of smokers.
            double avgDiet = smokerDiet / smokerCount;

            //display the results to two decimal places.
            System.out.printf(
                    "Smokers -> Avg Exercise: %.2f mins/week, Avg Diet Quality: %.2f%n",
                    avgExercise, avgDiet
            );
        }

        //calculate and display the averages for non-smokers.
        //Again, we must check that the group contains at least one record.
        if (nonSmokerCount > 0) {

            //calculate the average weekly exercise minutes.
            double avgExercise = nonSmokerExercise / nonSmokerCount;

            //cCalculate the average diet quality score.
            double avgDiet = nonSmokerDiet / nonSmokerCount;

            //display the results to two decimal places.
            System.out.printf(
                    "Non-Smokers -> Avg Exercise: %.2f mins/week, Avg Diet Quality: %.2f%n",
                    avgExercise, avgDiet
            );
        }

        // Print a closing separator.
        System.out.println("==============================================================");


    }

    /*alternative to above using maps*/

//    @Override
//    public void run() {
//        System.out.println("=== Lifestyle Summary by Smoking Status ===");
//
//        //Group the HealthRecord objects by smoking status (Yes/No) and calculate
//        //the average weekly exercise minutes for each group.
//        //The resulting Map uses the smoking status as the key and the average
//        //exercise minutes as the value.
//        //Map<String, Double> avgExercise = data.stream()
//            .collect(Collectors.groupingBy(
//                HealthRecord::getSmoker,
//                Collectors.averagingDouble(HealthRecord::getExerciseMinsPerWeek)
//            ));
//
//       //Group the HealthRecord objects by smoking status (Yes/No) and calculate
//       //the average diet quality score for each group.
//       //The resulting Map uses the smoking status as the key and the average
//       //diet quality score as the value.
//        Map<String, Double> avgDiet = data.stream()
//            .collect(Collectors.groupingBy(
//                HealthRecord::getSmoker,
//                Collectors.averagingDouble(HealthRecord::getDietQuality)
//            ));
//
//        avgExercise.forEach((smoker, exercise) -> {
//            System.out.printf("%s -> Avg Exercise: %.2f mins/week, Avg Diet Quality: %.2f%n",
//                smoker, exercise, avgDiet.get(smoker));
//        });
//
//        System.out.println("==============================================================");
//    }
}