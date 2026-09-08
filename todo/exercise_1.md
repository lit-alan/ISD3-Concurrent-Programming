## Lab Exercise One - Collections and Generics :point_down:

For this exercise, use the `FutureInvestmentsStarter` project provided in this repository. The project contains two classes in the `isd3.ui` package.

*Console* – This class is used for input/output from/to the console. You will not need to make any
changes to this class.

*Main* – This is the main/driver class for the application. When you run this application, it will
continually prompt you to enter a monthly investment amount, yearly interest rate and a number of
years (that the amount will be invested for). The user can signal their intent to stop entering data
(investments) at the prompt.

You must add another class (called *Investment* to the project). Add this class to the _isd3.model_ package in the project.

Add the following three (private) instance variables to this class:
- monthlyInvestment (a double)
- yearlyInterestRate (a double)
- years (an int).

_You must add appropriate getters/setters for these three instance variables to the Investment class._

You must also add two constructors to this class.

1. The first must be a default (no-args) constructor. It should initialise the three instance variables to their default values.
2. The second must be an all-args constructor that accepts values for the monthly investment, yearly interest rate, and number of years. It should use these values to initialise the corresponding instance variables.

Finally add the following utility method to the `Investment` class.

```java
public double calculateFutureValue() {
    // Convert yearly values to monthly values
    double monthlyInterestRate = yearlyInterestRate / 12 / 100;
    int months = years * 12;

    // Calculate the future value
    double futureValue = 0;

    for (int i = 1; i <= months; i++) {
        futureValue += monthlyInvestment;

        double monthlyInterestAmount =
                futureValue * monthlyInterestRate;

        futureValue += monthlyInterestAmount;
    }

    return futureValue;
}

```
_This method calculates and returns (as a double) the future value of a given investment._

> [!NOTE]
> You may (if you wish) override the _**toString**_ method in the `Investment` class as it could prove useful.

----
To Do (in the Main class):
1. Add an `ArrayList` to store `Investment` objects.
2. Create five `Investment` objects and add them to the `ArrayList`. The user must enter the data for
these objects via the keyboard. Test data appears on the next page.
3. Output the details of the five investment objects along with their future value.
4. Increase the interest rate for each investment object by 2% and again display the details of the five
investment objects (including their new future value).
5. Remove from the `ArrayList`, any investment object which has a future value of below €25,000.
6. Display the details of the remaining objects left in the `ArrayList`.


All input/output should be achieved using the various static methods of the Console class (which I have provided).
Ensure that the appearance of any monetary and percentage values in your output is formatted appropriately (the [NumberFormat](https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html) class should help with this).
Ensure that your ArrayList can only store Investment objects.

> [!IMPORTANT]
> Use the following data to test your application when you are finished: 

<img width="496" height="882" alt="image" src="https://github.com/user-attachments/assets/1a680677-90b0-434b-bbb9-5654bdb1bfaf" />
