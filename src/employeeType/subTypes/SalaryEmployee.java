package employeeType.subTypes;

//Name	 	: Mohammad Aldhahri
//Class 	: 1620-005
//Program # 	: 3
//Due Date  	: March 16th, 2017
//
//Honor Pledge:  On my honor as a student of the University
//   of Nebraska at Omaha, I have neither given nor received
//   unauthorized help on this homework assignment.
//
//NAME: Mohammad Aldhahri	
//NUID: 664
//EMAIL: maldhahri@unomaha.edu

//Partners:  None
//This class extends employee class implements the pay based upon a yearly salary
 
import employeeType.employee.Employee;
import exceptions.InvalidEmployeeNumberException;
public class SalaryEmployee extends Employee {

	private double salary = 0;

	/* Method Name : SalaryEmployee
	   Parameters : fn,ln,m,g,empNum,ft,s
	   Return value(s) : None
	   Partners : None
	   Description : Constructor of SalaryEmployee class */
	public SalaryEmployee(String fn, String ln, char m, char g, int empNum,
			boolean ft, double s) throws InvalidEmployeeNumberException {
		super(fn, ln, m, g, empNum, ft);
		if (salary >= 0) {
			salary = s;
		} else {
			salary = 0;
		}
	}

	/* Method Name : toString
	   Parameters : None
	   Return value(s) : String
	   Partners : None
	   Description : returns String of the SalaryEmployee */
	public String toString() {

		return String.format("\n%sSalary: %.2f", super.toString(), salary);

	}

	/* Method Name : calculateWeeklyPay
	   Parameters : None
	   Return value(s) : calculate weekly pay
	   Partners : None
	   Description : Returns amount earned in the week by dividing salary by 52*/
	public double calculateWeeklyPay() {
		return salary / 52;
	}

	/* Method Name : annualRaise
	   Parameters : None
	   Return value(s) : none
	   Partners : None
	   Description : In this method, Salary is increased by 6%*/
	public void annualRaise() {
		salary = salary + salary * .06;
	}

	/* Method Name : holidayBonus
	   Parameters : None
	   Return value(s) : holiday bonus
	   Partners : None
	   Description : This method will return 3% of salary*/
	public double holidayBonus() {

		return salary * .03;

	}

	/* Method Name : resetWeek
	   Parameters : None
	   Return value(s) : none
	   Partners : None
	   Description : No change */
	public void resetWeek() {
	}

}
