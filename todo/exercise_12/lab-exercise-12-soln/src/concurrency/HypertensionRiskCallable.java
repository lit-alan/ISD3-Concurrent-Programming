package concurrency;

import model.HealthRecord;

import java.util.concurrent.Callable;

public class HypertensionRiskCallable implements Callable<String> {

    private HealthRecord record;

    public HypertensionRiskCallable(HealthRecord record) {
        this.record = record;
    }

    @Override
    public String call() {

        double sys = record.getSystolicBp();
        double dia = record.getDiastolicBp();
        int age = record.getAge();
        String risk;

        if (sys < 120 && dia < 80) {
            risk = "Low";
        } else if (120 <= sys && sys < 130 && dia < 80) {
            risk = "Medium";
        } else if ((130 <= sys && sys < 140) || (80 <= dia && dia < 90)) {
            risk = "Medium";
        } else {
            risk = "High";
        }

        // Age factor
        if (age > 60) {
            if (risk.equals("Low")) risk = "Medium";
            else if (risk.equals("Medium")) risk = "High";
        }

        return "Participant " + record.getId() + " Hypertension Risk: " + risk;
    }
}

