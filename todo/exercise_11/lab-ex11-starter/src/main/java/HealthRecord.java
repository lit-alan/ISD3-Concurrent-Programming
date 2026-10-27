public class HealthRecord {
    private int id;
    private int age;
    private String gender;
    private double heightCm;
    private double weightKg;
    private double bmi;
    private double avgSleepHours;
    private double exerciseMinsPerWeek;
    private double dietQuality;
    private String smoker;
    private double alcoholUnitsPerWeek;
    private double systolicBp;
    private double diastolicBp;
    private double cholesterolMgDl;
    private double glucoseMgDl;
    private String hasHypertension;
    private String hasDiabetes;
    private String region;
    private double stressLevel;
    private double mentalHealthScore;

    public HealthRecord(
            int id, int age, String gender, double heightCm, double weightKg, double bmi,
            double avgSleepHours, double exerciseMinsPerWeek, double dietQuality, String smoker,
            double alcoholUnitsPerWeek, double systolicBp, double diastolicBp,
            double cholesterolMgDl, double glucoseMgDl,
            String hasHypertension, String hasDiabetes, String region,
            double stressLevel, double mentalHealthScore
    ) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.heightCm = heightCm;
        this.weightKg = weightKg;
        this.bmi = bmi;
        this.avgSleepHours = avgSleepHours;
        this.exerciseMinsPerWeek = exerciseMinsPerWeek;
        this.dietQuality = dietQuality;
        this.smoker = smoker;
        this.alcoholUnitsPerWeek = alcoholUnitsPerWeek;
        this.systolicBp = systolicBp;
        this.diastolicBp = diastolicBp;
        this.cholesterolMgDl = cholesterolMgDl;
        this.glucoseMgDl = glucoseMgDl;
        this.hasHypertension = hasHypertension;
        this.hasDiabetes = hasDiabetes;
        this.region = region;
        this.stressLevel = stressLevel;
        this.mentalHealthScore = mentalHealthScore;
    }

    //Getters for all fields
    public int getId() { return id; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public double getHeightCm() { return heightCm; }
    public double getWeightKg() { return weightKg; }
    public double getBmi() { return bmi; }
    public double getAvgSleepHours() { return avgSleepHours; }
    public double getExerciseMinsPerWeek() { return exerciseMinsPerWeek; }
    public double getDietQuality() { return dietQuality; }
    public String getSmoker() { return smoker; }
    public double getAlcoholUnitsPerWeek() { return alcoholUnitsPerWeek; }
    public double getSystolicBp() { return systolicBp; }
    public double getDiastolicBp() { return diastolicBp; }
    public double getCholesterolMgDl() { return cholesterolMgDl; }
    public double getGlucoseMgDl() { return glucoseMgDl; }
    public String getHasHypertension() { return hasHypertension; }
    public String getHasDiabetes() { return hasDiabetes; }
    public String getRegion() { return region; }
    public double getStressLevel() { return stressLevel; }
    public double getMentalHealthScore() { return mentalHealthScore; }

    @Override
    public String toString() {
        return "HealthRecord{" +
                "id=" + id +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", heightCm=" + heightCm +
                ", weightKg=" + weightKg +
                ", bmi=" + bmi +
                ", avgSleepHours=" + avgSleepHours +
                ", exerciseMinsPerWeek=" + exerciseMinsPerWeek +
                ", dietQuality=" + dietQuality +
                ", smoker='" + smoker + '\'' +
                ", alcoholUnitsPerWeek=" + alcoholUnitsPerWeek +
                ", systolicBp=" + systolicBp +
                ", diastolicBp=" + diastolicBp +
                ", cholesterolMgDl=" + cholesterolMgDl +
                ", glucoseMgDl=" + glucoseMgDl +
                ", hasHypertension='" + hasHypertension + '\'' +
                ", hasDiabetes='" + hasDiabetes + '\'' +
                ", region='" + region + '\'' +
                ", stressLevel=" + stressLevel +
                ", mentalHealthScore=" + mentalHealthScore +
                '}';
    }
}
