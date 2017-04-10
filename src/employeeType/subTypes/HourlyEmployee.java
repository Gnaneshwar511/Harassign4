package employeeType.subTypes;
//Name	 	: Mohammad Aldhahri
//Class 	: 1620-005
//Program # 	: 3
//Due Date  	: March 16th, 2017
//
//Honor Pledge:  On my honor as a student of the University
//     of Nebraska at Omaha, I have neither given nor received
//     unauthorized help on this homework assignment.
//
//NAME: Mohammad Aldhahri	
//NUID: 664
//EMAIL: maldhahri@unomaha.edu

//Partners:  None
//This class extends employee class implements the abstract methods

import java.util.Scanner;

import employeeType.employee.Employee;
import exceptions.InvalidEmployeeNumberException;
public class HourlyEmployee extends Employee {

	private double wage;
	private double hoursWorked;

	
	/* Method Name : HourlyEmployee
	   Parameters : fn,ln,m,g,empNum,ft,w
	   Return value(s) : None
	   Partners : None
	   Description : Constructor of HourlyEmployee class */
	public HourlyEmployee(String fn, String ln, char m, char g, int empNum,	boolean ft, double wage) throws InvalidEmployeeNumberException {
		super(fn, ln, m, g, empNum, ft);
		Scanner input = new Scanner(System.in);
		if (wage >= 0)
			this.wage = wage;
		else {
			do {
				System.out.print("\nInvalid wage, please enter again. ");
				wage = input.nextDouble();
			} while (wage < 0);
			this.wage = wage;
		}
		hoursWorked = 0.0;
	}

	/* Method Name : toString
	   Parameters : None
	   Return value(s) : String
	   Partners : None
	   Description : returns String of the HourlyEmployee */
	public String toString() {
		return String.format("\n%sWage: %.2f\nHours Worked: %.2f",super.toString(), wage, hoursWorked);
	}
	
	/* Method Name : calculateWeeklyPay
	// Parameters : None
	// Return value(s) : calculated weekly pay, a double
	// Partners : None
	// Description : Returns amount earned in the week using wage and hoursWorked, any hours worked over 40 give double pay */
	
	public double calculateWeeklyPay() {
		double weeklyPay = 0;
		if (hoursWorked <= 40) {
			weeklyPay = wage * hoursWorked;
		} else {
			weeklyPay = wage * 40;
			hoursWorked = hoursWorked - 40;
			weeklyPay = weeklyPay + (wage * 2) * hoursWorked;
		}
		return weeklyPay;
	}
	/* Method Name : annualRaise
	   Parameters : None
	   Return value(s) : None
	   Partners : None
	   Description : this method will wage is increased by 5% */
	public void annualRaise() {
		wage += wage * .05;
	}
	/* Method Name : holidayBonus
	   Parameters : None
	   Return value(s) : holiday bonus, a double
	   Partners : None
	   Description : Return amount of 40 hours worked */
	
	public double holidayBonus() {
		return wage * 40;
	}

	/* Method Name : resetWeek
	   Parameters : None
	   Return value(s) : none
	   Partners : None
	   Description : Resets hours worked to 0*/
	public void resetWeek() {
		hoursWorked = 0;
	}

	/* Method Name : increaseHours
	   Parameters : hours, a double
	   Return value(s) : increased hours, a string
	   Partners : None
	   Description : this method will increase the hours worked*/
	public void increaseHours(double hours) {
		if (hours >= 0) {
			hoursWorked = hoursWorked + hours;
		} else {
			System.out.print("\nError. Requested to increase hours by a negative value.\n");
		}
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
