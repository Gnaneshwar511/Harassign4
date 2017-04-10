package employeeType.subTypes;

import datastructures.ArrayList;
import employeeType.employee.Employee;
import exceptions.InvalidCharacterException;
//Name	 	: Mohammad Aldhahri
//Class 	: 1620-005
//Program # 	: 3
//Due Date  	: March 16th, 2017
//
//Honor Pledge:  On my honor as a student of the University
// of Nebraska at Omaha, I have neither given nor received
// unauthorized help on this homework assignment.
//
//NAME: Mohammad Aldhahri	
//NUID: 664
//EMAIL: maldhahri@unomaha.edu
import exceptions.InvalidEmployeeNumberException;
import exceptions.InvalidSizeException;
import exceptions.MaximumCapacityException;

//Partners:  None
//class creates an array of Employee objects and uses various methods to manipulate each Employee stored in the array.

public class EmployeeManager {
	private ArrayList<Employee> employees;
	//private Employee[] employees;
	
	//private final int employeeMax = 10;
	
	//private int currentEmployees;
	
	/*Method Name : EmployeeManager
		 Parameters : None
		 Return value(s) : None
		 Partners : None
		 Description : Constructor, creates the Employee array, sets currentEmployees to 0.*/
	
	public EmployeeManager() {
		try {
			employees = new ArrayList<Employee>(3);
		} catch (InvalidSizeException e) {
			employees = new ArrayList<Employee>();
		}
	}

	/* Method Name : addEmployee
		 Parameters : type,firstName,lastName,gender,employeeNum,
		 fullTime/partTime,salary
		 Return value(s) : None
		 Partners : None
		 Description : This Method represents the type of Employee to be added (1
		 Hourly, 2 Salary, 3 Commission) as well as the required data to
		 create that Employee.*/
	
	public void addEmployee(int type, String fn, String ln, char m, char g,
			int en, boolean ft, double amount) throws InvalidEmployeeNumberException, MaximumCapacityException {
		if (type == 1) {
			employees.addItem(new HourlyEmployee(fn, ln, m, g, en,
					ft, amount));
			//currentEmployees++;
		} else if (type == 2) {
			employees.addItem(new SalaryEmployee(fn, ln, m, g, en,
					ft, amount));
			//currentEmployees++;
		} else if (type == 3) {
			employees.addItem(new CommissionEmployee(fn, ln, m, g,
					en, ft, amount));
			//currentEmployees++;
		}
	}

	/* Method Name : removeEmployee
		 Parameters : index
		 Return value(s) : None
		 Partners : None
		 Description : This Method removes an Employee located at the given index
		 from the Employee array.*/
	public void removeEmployee(int index) {
		/*employees[index] = employees[currentEmployees - 1];
		currentEmployees--;*/
		employees.removeItem(index);
	}

	/*Method Name : listAll
		 Parameters : None
		 Return value(s) : None
		 Partners : None
		 Description : This Method lists all the current Employees*/
	public void listAll() {
		if (employees.isEmpty())
			System.out.println("No Employees");
		for (int i = 0; i < employees.lengthIs(); i++) {
			System.out.println(employees.getItem(i));
		}
	}

	/* Method Name : listHourly
		 Parameters : None
		 Return value(s) : None
		 Partners : None
		 Description : This Method lists all the hourly employees in the array.*/
	public void listHourly() {
		int empCount = 0;
		for (int i = 0; i < employees.lengthIs(); i++) {
			if (employees.getItem(i) instanceof HourlyEmployee)
				empCount++;
		}
		if (empCount == 0)
			System.out.println("No Employees");
		for (int i = 0; i < employees.lengthIs(); i++) {
			if (employees.getItem(i) instanceof HourlyEmployee)
				System.out.println(employees.getItem(i));
		}
	}

	/* Method Name : listSalary
		 Parameters : None
		 Return value(s) : None
		 Partners : None
		 Description : This Method lists all the Salary employees in the array.*/

	public void listSalary() {
		int empCount = 0;
		for (int i = 0; i < employees.lengthIs(); i++) {
			if (employees.getItem(i) instanceof SalaryEmployee)
				empCount++;
		}
		if (empCount == 0)
			System.out.println("No Employees");
		for (int i = 0; i < employees.lengthIs(); i++) {
			if (employees.getItem(i) instanceof SalaryEmployee)
				System.out.println(employees.getItem(i));
		}
	}

	/* Method Name : listCommission
		 Parameters : None
		 Return value(s) : None
		 Partners : None
		 Description : This Method lists all the Commission employees in the
		 array.*/
	public void listCommission() {
		int empCount = 0;
		for (int i = 0; i < employees.lengthIs(); i++) {
			if (employees.getItem(i) instanceof CommissionEmployee)
				empCount++;
		}
		if (empCount == 0)
			System.out.println("No Employees");
		for (int i = 0; i < employees.lengthIs(); i++) {
			if (employees.getItem(i) instanceof CommissionEmployee)
				System.out.println(employees.getItem(i));
		}
	}


	/* Method Name : resetWeek
	 Parameters : None
	 Return value(s) : None
	 Partners : None
	 Description : This Method resets the week of an employee.*/
	public void resetWeek() {
		for (int i = 0; i < employees.lengthIs(); i++)
			employees.getItem(i).resetWeek();
	}
	/* Method Name : calculatePayout
		 Parameters : None
		 Return value(s) : totalpay
		 Partners : None
		 Description : This Method calculates payout of an employee.*/
	public double calculatePayout() {
		double totalPay = 0.0;
		for (int i = 0; i < employees.lengthIs(); i++)
			totalPay += employees.getItem(i).calculateWeeklyPay();
		return totalPay;
	}
	   /*Method Name : removeRedundancies
		 Parameters : None
		 Return value(s) : None
		 Partners : None
		 Description : This Method removes redundant employee.*/
	/*public void removeRedundancies() {
		if (employees.lengthIs() != 1) {
			for (int i = 0; i < employees.lengthIs() - 1; i++) {
				for (int j = i + 1; j < employees.lengthIs(); j++) {
					if (employees.getItem(i).getEmployeeNumber() == employees.getItem(j)
							.getEmployeeNumber()) {
						employees[j] = employees.getItem(j+1);
						currentEmployees--;
					}
				}
			}
		}
	}*/

	/* Method Name : getIndex
		 Parameters : employee number, a int
		 Return value(s) : None
		 Partners : None
		 Description : This Method gets index of passed employee number.*/
	public int getIndex(int empNum) {
		int i;
		for (i = 0; i < employees.lengthIs(); i++) {
			if (employees.getItem(i).getEmployeeNumber() == empNum)
				return i;
		}
		return -1;
	}

	/* Method Name : sortNumber
		 Parameters : None
		 Return value(s) : None
		 Partners : None
		 Description : This Method sorts employees by number.*/
	/*public void sortNumber() {
		Employee temp;
		for (int i = 0; i < employees.lengthIs() - 1; i++) {
			for (int j = i + 1; j < employees.lengthIs(); j++) {
				if (employees.getItem(i).getEmployeeNumber() > employees.getItem(j)
						.getEmployeeNumber()) {
					temp = employees.getItem(i);
					employees[i] = employees.getItem(index)[j];
					employees[j] = temp;
				}
			}
		}

	}*/

	/* Method Name : sortName
		 Parameters : None
		 Return value(s) : None
		 Partners : None
		 Description : This Method sorts employees by name.*/

	/*public void sortName() {
		Employee emp1;
		Employee emp2;
		for (int i = 0; i < currentEmployees - 1; i++) {
			for (int j = i + 1; j < currentEmployees; j++) {
				if (employees[i].getLastName().compareTo(
						employees[j].getLastName()) == 0) {
					if (employees[i].getFirstName().compareTo(
							employees[j].getFirstName()) > 0) {
						emp1 = employees[i];
						employees[i] = employees[j];
						employees[j] = emp1;
					}
				} else if (employees[i].getLastName().compareTo(
						employees[j].getLastName()) > 0) {
					emp2 = employees[i];
					employees[i] = employees[j];
					employees[j] = emp2;
				}
			}
		}
	}*/
	/*Method Name : annualRaises
		 Parameters : None
		 Return value(s) : None
		 Partners : None
		 Description : This Method raises annual salary of an employee.*/

	public void annualRaises() {
		for (int i = 0; i < employees.lengthIs(); i++)
			employees.getItem(i).annualRaise();
	}

	/*Method Name : holidayBonuses
		 Parameters : None
		 Return value(s) : totalBonus, a double
		 Partners : None
		 Description : This Method calculates total bonus of an employee.*/

	public double holidayBonuses() {
		double totalBonus = 0.0;
		for (int i = 0; i < employees.lengthIs(); i++) {
			totalBonus += employees.getItem(i).holidayBonus();
			System.out.println(employees.getItem(i).toString());
			System.out.println(String.format("%s%.2f", "Bonus Amount: ",
					employees.getItem(i).holidayBonus()));
		}
		System.out.println();
		return totalBonus;
	}

	/* Method Name : increaseHours
		 Parameters : index, amount
		 Return value(s) : None
		 Partners : None
		 Description : This Method increases hours of a hourly employee.*/

	public void increaseHours(int index, double amount) {

		if (employees.getItem(index) instanceof HourlyEmployee)
			((HourlyEmployee) employees.getItem(index)).increaseHours(amount);
	}
	/* Method Name : increaseSales
		 Parameters : index, amount
		 Return value(s) : None
		 Partners : None
		 Description : This Method increases sales of commission employee.*/

	public void increaseSales(int index, double amount) {

		if (employees.getItem(index) instanceof CommissionEmployee)
			((CommissionEmployee) employees.getItem(index)).increaseSales(amount);
	}
	/* Method Name : RabinKarp
		 Parameters : name, find
		 Return value(s) : int
		 Partners : None
		 Description : This method does the preprocessing of finding the has for the substring*/

	
		private int RabinKarp(String name, String find) {
			if (find.length() > name.length()) {
				return -1;
			}
			int[] hashed = new int[name.length()];
			int hashedFind = stringHash(find);
			RabinKarpHashes(name, hashed, 0, find.length());
			return linearSearchRecursive(hashed, hashedFind, 0);
		}

		
		/* Method Name : stringHash
		 Parameters : s
		 Return value(s) : int
		 Partners : None
		 Description : Given a string, this method return the hash value of the entire String.*/
		private int stringHash(String s) {
			int tempLength = s.length();
			int temp = 0;
			for (int i = 0; i < s.length(); i++) {
				temp += (charNumericValue(s.charAt(i)) * Math.pow(26, tempLength - 1));
				tempLength--;
			}
			return temp;
		}
		
		/* Method Name : charNumericValue
		 Parameters : c
		 Return value(s) : int
		 Partners : None
		 Description : Given a character, this method returns the numeric value of the character, starting with A – 0 up to Z – 25.*/
		
		private int charNumericValue(char c) {
			int parts = 0;
			try {
				switch (c) {
				case 'A':
				case 'a':
					parts = 0;
					break;
				case 'B':
				case 'b':
					parts = 1;
					break;
				case 'C':
				case 'c':
					parts = 2;
					break;
				case 'D':
				case 'd':
					parts = 3;
					break;
				case 'E':
				case 'e':
					parts = 4;
					break;
				case 'F':
				case 'f':
					parts = 5;
					break;
				case 'G':
				case 'g':
					parts = 6;
					break;
				case 'H':
				case 'h':
					parts = 7;
					break;
				case 'I':
				case 'i':
					parts = 8;
					break;
				case 'J':
				case 'j':
					parts = 9;
					break;
				case 'K':
				case 'k':
					parts = 10;
					break;
				case 'L':
				case 'l':
					parts = 11;
					break;
				case 'M':
				case 'm':
					parts = 12;
					break;
				case 'N':
				case 'n':
					parts = 13;
					break;
				case 'O':
				case 'o':
					parts = 14;
					break;
				case 'P':
				case 'p':
					parts = 15;
					break;
				case 'Q':
				case 'q':
					parts = 16;
					break;
				case 'R':
				case 'r':
					parts = 17;
					break;
				case 'S':
				case 's':
					parts = 18;
					break;
				case 'T':
				case 't':
					parts = 19;
					break;
				case 'U':
				case 'u':
					parts = 20;
					break;
				case 'V':
				case 'v':
					parts = 21;
					break;
				case 'W':
				case 'w':
					parts = 22;
					break;
				case 'X':
				case 'x':
					parts = 23;
					break;
				case 'Y':
				case 'y':
					parts = 24;
					break;
				case 'Z':
				case 'z':
					parts = 25;
					break;
				default:
					throw new InvalidCharacterException(c);
				}
			} catch (InvalidCharacterException exThrown) {
				System.out.println(exThrown + "\nPlease enter a letter");
			}
			return parts;
		}
		
		
		/* Method Name : linearSearchRecursive
		 Parameters : data, key, pos
		 Return value(s) : int
		 Partners : None
		 Description : This is a recursive linear search. Return the position of key in the data array, or -1 if it is not present.*/
		
		private int linearSearchRecursive(int[] data, int key, int pos) {
			if (data[pos] == key) {
				return pos;
			} else if (pos == (data.length - 1)) {
				return -1;
			} else {
				return linearSearchRecursive(data, key, (pos + 1));
			}
		}

		/* Method Name : RabinKarpHashes
		 Parameters : s, hashes, int pos, int length
		 Return value(s) : int
		 Partners : None
		 Description : This method finds the hash values of all substrings of size length in the String s, starting at index pos and down.*/
		
		private int RabinKarpHashes(String s, int[] hashes, int pos, int length) {
			if (pos == s.length() - length) {
				hashes[pos] = stringHash(s.substring(pos, (pos + length)));
				return 1;
			} else if (pos == 0) {
				hashes[pos] = stringHash(s.substring(0, length));
				return RabinKarpHashes(s, hashes, (pos + 1), length);
			} else {
				int previousHash = (stringHash(s.substring(pos - 1, pos + (length - 1))));
				int previousChar = (int) ((charNumericValue(s.charAt(pos - 1))) * Math.pow(26, (length - 1)));
				hashes[pos] = 26 * (previousHash - previousChar) + charNumericValue(s.charAt(pos + (length - 1)));
				return RabinKarpHashes(s, hashes, (pos + 1), length);
			}
		}

		/* Method Name : findAllBySubstring
		 Parameters : find
		 Return value(s) : Employee[]
		 Partners : None
		 Description :  This method will return an array of all the Employees in the EmployeeManager that contain the substring passed.*/
		public ArrayList<Employee> findAllBySubstring(String find) {
			int pos = 0;
			System.out.println(employees.lengthIs());
			for (int i = 0; i < employees.lengthIs(); i++) {
				String tempName = (employees.getItem(i).getFirstName() + employees.getItem(i).getLastName());
				if (RabinKarp(tempName, find) != -1) {
					employees.setItem(pos, employees.getItem(i)); 
					pos++;
				}
			}
			return employees;
		}
		
		public void sort() {
			employees.sort();
		}
	
}
