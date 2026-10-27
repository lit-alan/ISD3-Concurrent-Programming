# Lab Exercise 11 - Health and Wellness Analysis Guide

> [!NOTE]  
> this exercise is a previous assignment two.

The file `health_and_wellness_dataset.csv` contains 4,000 synthetic
health records with demographic, lifestyle, and physiological data.

Each record represents an individual participant and includes fields
such as age, gender, BMI, exercise minutes, and diet quality. You will
use this dataset to perform concurrent data analyses using Java
`Runnables` and `Callables`.

## Dataset columns


| Field Name | Description |
|---|---|
| `id` | Unique identifier for each participant record. |
| `age` | Participant’s age in years. |
| `gender` | Gender identity of the participant. |
| `height_cm` | Participant’s height in centimeters. |
| `weight_kg` | Participant’s weight in kilograms. |
| `bmi` | Body Mass Index, calculated from height and weight. |
| `avg_sleep_hours` | Average number of hours the participant sleeps per night. |
| `exercise_mins_per_week` | Total minutes of exercise performed by the participant each week. |
| `diet_quality` | A self-reported diet quality score ranging from 1 (poor) to 10 (excellent). |
| `smoker` | Indicates whether the participant is a smoker (“Yes” or “No”). |
| `alcohol_units_per_week` | Number of alcoholic drinks consumed per week. |
| `systolic_bp` | Systolic blood pressure (top number in mmHg). |
| `diastolic_bp` | Diastolic blood pressure (bottom number in mmHg). |
| `cholesterol_mg_dl` | Total cholesterol level measured in milligrams per deciliter. |
| `glucose_mg_dl` | Fasting blood glucose level in milligrams per deciliter. |
| `has_hypertension` | Indicates whether the participant has been diagnosed with hypertension (“Yes” or “No”). |
| `has_diabetes` | Indicates whether the participant has been diagnosed with diabetes (“Yes” or “No”). |
| `region` | Participant’s geographic region (e.g., North, South, East, West, Central). |
| `stress_level` | Self-reported stress rating on a scale from 1 (low) to 10 (high). |
| `mental_health_score` | A composite wellbeing score between 0 and 100, representing overall mental health. |


## Starter code

The `HealthRecord` class represents one record (or row) from the
dataset. It serves as the core data entity that all analysis operates
on. Each field corresponds to a specific attribute from the dataset. The
class includes appropriate getter methods for each property.

The starter code contains:

-   The dataset `health_and_wellness_dataset.csv`.
-   The `HealthRecord` class, which models a record from the file.
-   A class called `HealthDataLoader`, which contains one method called
    `load`. This method reads the CSV file and converts each line into a
    `HealthRecord` object, returning a list of all records.

## Task One - BMI threshold analysis (25 marks)

Create a `Runnable` that identifies and reports participants whose Body
Mass Index (BMI) exceeds a specified threshold.

The runnable should accept two parameters:

-   A list of `HealthRecord` objects.
-   A numeric BMI threshold (e.g., `25.0`, `30.0`).

The runnable should print the total number of individuals who meet or
exceed the threshold to the console, along with each qualifying
participant's ID and BMI.

If the threshold is `35`, then **220 records** will be displayed. For
example:

<img width="865" height="461" alt="image" src="https://github.com/user-attachments/assets/7d98f1d9-22ad-4d4c-bd2a-f433d679f779" />

<br>  

   

 
If the threshold is `37`, then **128 records** will be displayed. For
example:

<img width="910" height="556" alt="image" src="https://github.com/user-attachments/assets/899c3a34-30ed-4dfc-b071-8ab69560d50f" />


## Task Two - Lifestyle analysis by smoking status (35 marks)

Create a `Runnable` that analyses lifestyle habits by calculating and
reporting the average exercise time and average diet quality for two
participant groups: smokers and non-smokers.

The analysis should focus on two measures of healthy living:

1.  Exercise minutes per week.
2.  Diet quality score.

When executed, the runnable should:

-   Determine the average weekly exercise time for smokers and
    non-smokers.
-   Determine the average diet quality score for smokers and
    non-smokers.
-   Present these findings in a clear, structured console report showing
    the group names and their corresponding averages.
-   Include an appropriate title and summary formatting that makes the
    output easy to interpret.

The runnable should accept one parameter: a list of `HealthRecord`
objects.

The results should give a concise, comparative view of lifestyle
differences between smokers and non-smokers within the dataset. All
average values should be displayed to **two decimal places**.

<img width="910" height="149" alt="image" src="https://github.com/user-attachments/assets/990972a8-1b1e-4853-a258-7fc4f21c453a" />


## Task Three - Mental health scores by region (40 marks)

Create a `Callable` to examine patterns in mental wellbeing across
different geographic regions by calculating and presenting the average
mental health score for participants in each region.

The callable should analyse the dataset to determine how mental health
scores vary by region and perform a comparative analysis across all
regions represented in the dataset (there are five regions). It should
then return the results in a structured format that can be displayed in
the console.

The callable should:

-   Group participants by region, based on the region value in each
    record.
-   Calculate the average mental health score for each region.
-   Return a mapping of region names to average mental health scores
    (for example, a key--value structure where the key is the region and
    the value is the calculated average score).

The callable should accept one parameter: a `List<HealthRecord>` object
containing the full dataset.

<img width="818" height="308" alt="image" src="https://github.com/user-attachments/assets/2b8c83c9-b64a-43a1-b9d7-c465062e6235" />


## Indicative marking breakdown
| Task  | Marks |
|-------|------:|
| One   | 25    |
| Two   | 35    |
| Three | 40    |
| **Total** | **100** |
