//Name	 	: Mohammad Aldhahri
//Class 	: 1620-005
//Program # 	: 3
//Due Date  	: March 16th, 2017
//
//Honor Pledge:  On my honor as a student of the University
//         of Nebraska at Omaha, I have neither given nor received
//         unauthorized help on this homework assignment.
//
//NAME: Mohammad Aldhahri	
//NUID: 664
//EMAIL: maldhahri@unomaha.edu
package employeeType.employee;

//Partners:  None

//This is an abstract class where other employees are inherited from

import exceptions.InvalidEmployeeNumberException;

//public abstract class Item<T> implements Comparable<Item<T>>
public abstract class Employee implements Comparable<Employee> {

	private String firstName;
	private String lastName;
	private char middleInitial;
	private boolean fulltime;
	private char gender;
	private int employeeNum;

	/*
	 * Method Name : Employee Parameters : fn,ln,m,g,empNum,ft Return value(s) :
	 * None Partners : None Description : Employee class constructor
	 */

	public Employee(String fn, String ln, char m, char g, int empNum, boolean ft)
			throws InvalidEmployeeNumberException {
		this.firstName = fn;
		this.lastName = ln;
		this.middleInitial = m;
		this.fulltime = ft;
		setEmployeeNumber(empNum);
		setGender(g);
	}

	/*
	 * Method Name : getEmployeeNumber Parameters : None Return value(s) :
	 * employee number, a int Partners : None Description : returns employee
	 * number
	 */
	public int getEmployeeNumber() {
		return employeeNum;
	}

	/*
	 * Method Name : setEmployeeNumber Parameters : empNum Return value(s) :
	 * None Partners : None Description : sets employee number
	 */
	public void setEmployeeNumber(int empNum) throws InvalidEmployeeNumberException {
		// Scanner in = new Scanner(System.in);
		if (empNum >= 10000 && empNum <= 99999) {
			employeeNum = empNum;
		} else {
			throw new InvalidEmployeeNumberException(empNum);
			/*
			 * do { //throw new InvalidEmployeeNumberException(empNum);
			 * System.out.print("Employee Number invalid, please re-enter.");
			 * empNum = in.nextInt(); } while (empNum < 10000 || empNum >
			 * 99999);
			 */
		}
	}

	/*
	 * Method Name : getFirstName Parameters : None Return value(s) : first
	 * name, a string Partners : None Description : this will return first name
	 * of the employee
	 */

	public String getFirstName() {
		return firstName;
	}

	/*
	 * Method Name : getLastName Parameters : None Return value(s) : last name,
	 * a string Partners : None Description : this will return last name of the
	 * employee
	 */
	public String getLastName() {
		return lastName;
	}

	/*
	 * Method Name : setFirstName Parameters : fn, a string Return value(s) :
	 * None Partners : None Description : this will set the first name of the
	 * employee
	 */
	public void setFirstName(String fn) {
		firstName = fn;

	}

	/*
	 * Method Name : setLastName Parameters : ln, a string Return value(s) :
	 * None Partners : None Description : this will set the last name of the
	 * employee
	 */
	public void setLastName(String ln) {
		lastName = ln;
	}

	/*
	 * Method Name : setMiddleI Parameters : m, a char Return value(s) : None
	 * Partners : None Description : this will set the middle initial of the
	 * employee
	 */
	public void setMiddleI(char m) {
		middleInitial = m;
	}

	/*
	 * Method Name : setGender Parameters : g, a char Return value(s) : None
	 * Partners : None Description : this will set the gender of the employee
	 */
	public void setGender(char gen) {
		if (gen == 'M' || gen == 'F') {
			gender = gen;
		} else {
			gender = 'F';
		}
	}

	/*
	 * Method Name : equals Parameters : e2 which is object Return value(s) :
	 * employee object, a boolean Partners : None Description : Returns true if
	 * the employeeNum of the two instances are equal, false otherwise
	 */
	public boolean equals(Object e2) {
		if (this.employeeNum == ((Employee) e2).employeeNum)
			return true;
		else
			return false;
	}

	/*
	 * Method Name : toString Parameters : None Return value(s) : employee
	 * details, a string Partners : None Description : Returns the formatted
	 * string of the Employee
	 */

	public String toString() {
		String formatEmployee = "";
		formatEmployee = employeeNum + "\n" + lastName + ", " + firstName + " " + middleInitial + ".\n" + "Gender: "
				+ gender + "\nStatus: ";

		if (fulltime) {
			formatEmployee = formatEmployee + "Full Time\n";
		} else {
			formatEmployee = formatEmployee + "Part Time\n";
		}

		return formatEmployee;
	}

	/*
	 * This is the abstract method to calculate the weekly pay and implemented
	 * by subclass
	 * 
	 * @return the value of weekly pay
	 */
	public abstract double calculateWeeklyPay();

	/*
	 * This method calculates the annual raise and implemented by subclass
	 */
	public abstract void annualRaise();

	/*
	 * This method calculates the holiday bonus and implemented by subclass
	 * 
	 * @return bonus
	 */
	public abstract double holidayBonus();

	/*
	 * This method is to reset the values of an employee in a week
	 */
	public abstract void resetWeek();

	public int compareTo(Employee e) {
		if (this.employeeNum > e.employeeNum) {
			return 1;
		} else if (this.employeeNum < e.employeeNum) {
			return -1;
		} else {
			return 0;
		}
	}

}
