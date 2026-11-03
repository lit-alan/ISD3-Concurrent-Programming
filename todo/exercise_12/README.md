Using the starter code for `Lab Exercise 11`carry out the following tasks, submitting each to a suitable Executor service.

## Task ONE

Create a Runnable that computes and reports several key health-related statistics across the entire dataset. The runnable should accept one parameter:

- A List<HealthRecord> object containing the dataset.

The runnable should calculate and print the following values to the console:

- The average age of participants.
- The average number of hours slept per night.
- The average minutes of exercise per week.
- The average diet quality score.
- The percentage of participants who are smokers.

The runnable should format the results clearly, printing each statistic on a separate line.

This task focuses on basic aggregation, iteration, and summarization of numeric data. All reported numerical statistics should be formatted to exactly two decimal places. For example:


  

<img width="404" height="243" alt="image" src="https://github.com/user-attachments/assets/9bad9d86-1fad-46d9-bfd5-8ba534c47447" />




## Task TWO

Create a Callable that evaluates hypertension risk using simple rule-based logic derived from participants’ systolic and diastolic blood pressure values.

The callable should accept one parameter:

- A single HealthRecord object representing the participant to be evaluated.

The callable must classify a participant’s hypertension risk using a clearly defined set of rule-based thresholds. It should evaluate the participant’s systolic and diastolic blood pressure values and assign a risk category according to the criteria below. After the initial categorisation, the callable must also factor in age as an additional risk modifier. The classification rules are as follows:

### 1. Initial Risk Classification (Based on Blood Pressure Only)

Evaluate the participant’s systolic and diastolic blood pressure values and assign one of the following categories:

Assign a category of “Low Risk” if both of these conditions are true:

- systolic < 120
- diastolic < 80

Assign a category of “Medium Risk” if any of the following are true:

- systolic is between 120 and 129 and diastolic < 80
- systolic is between 130 and 139
- diastolic is between 80 and 89

Assign a category of “High Risk” if either of the following is true:

- systolic ≥ 140
- diastolic ≥ 90

After determining the risk category from blood pressure if the participant is over 60 years old, increase their risk by one level.

- Low → Medium
- Medium → High
- High remains High

The callable should return a String containing the participant’s ID along with their evaluated hypertension risk classification which should be displayed on the console. For example:

<img width="529" height="60" alt="image" src="https://github.com/user-attachments/assets/4460f84f-c7e4-4eaf-9fa0-788a5efc0612" />


When the first object (index = 0) is passed to the Callable.


   
<img width="507" height="57" alt="image" src="https://github.com/user-attachments/assets/dec72d43-c6a6-4de7-a0b9-73ecda6b7c10" />


When the second object (index = 1) is passed to the Callable.

## Task THREE

Create a Callable that generates a comparative health summary for a specific geographic region (there are five regions in  the dataset - North, South, East, West, Central). The callable must accept two parameters:

1. A List<HealthRecord> containing the full dataset
2. A String representing the region to be analysed (e.g., "North", "South", "East", "West", "Central")

The callable should perform a focused analysis on the participants whose records match the specified region.

The callable must:

### 1. Filter the dataset by region

- Select only the HealthRecord objects whose region field matches the region parameter (case-insensitive).

### 2. Calculate the following statistics for that region:

- Sample size (the total number of participants in the specified region).
- Percentage of participants who consume alcohol above recommended limits.  
  (recommended limit can be defined as >14 units per week).
- Percentage of participants exhibiting metabolic syndrome markers.

  A participant is considered to show metabolic syndrome markers if they meet three or more of the following clinical criteria:

  - BMI ≥ 30.
  - Systolic blood pressure ≥ 130 or diastolic blood pressure ≥ 85.
  - Total cholesterol ≥ 200.
  - Fasting glucose ≥ 100.
  - Exercise minutes per week < 90.

The callable should return the calculated statistics in a structured format of your choosing. All numeric values must be formatted to two decimal places when displayed.

  
<img width="409" height="190" alt="image" src="https://github.com/user-attachments/assets/04ca88e6-69d2-43d6-881d-6474b88556e2" />


When the specified region is “north”.

    
<img width="400" height="173" alt="image" src="https://github.com/user-attachments/assets/0dffc1fc-6131-4529-8dee-1f694a69cf03" />


When the specified region is “south”.

An indicative breakdown of the marks is as follows:

| Task | Marks |
|---|---:|
| One | 35 |
| Two | 30 |
| Three | 35 |
