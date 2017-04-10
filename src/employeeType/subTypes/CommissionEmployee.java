package employeeType.subTypes;
//Name	 	: Mohammad Aldhahri
//Class 	: 1620-005
//Program # 	: 3
//Due Date  	: March 16th, 2017
//
//Honor Pledge:  On my honor as a student of the University
//       of Nebraska at Omaha, I have neither given nor received
//       unauthorized help on this homework assignment.
//
//NAME: Mohammad Aldhahri	
//NUID: 664
//EMAIL: maldhahri@unomaha.edu

//Partners:  None
// This class extends employee class implements pay which is based upon a commission rate and sales amount
 
import employeeType.employee.Employee;
import exceptions.InvalidEmployeeNumberException;
public class CommissionEmployee extends Employee {
		private double sales;
	    private double rate;

	    /* Method Name : CommissionEmployee
		   Parameters : fn,ln,m,g,empNum,ft,r
		   Return value(s) : None
		   Partners : None
		   Description : Constructor of CommissionEmployee class */
	public CommissionEmployee(String fn, String ln, char m, char g, int empNum,	boolean ft, double rate) throws InvalidEmployeeNumberException {
		super(fn, ln, m, g, empNum, ft);
		sales = 0;				
		if (rate >= 0)
        {
            this.rate = rate;
        }

        else
        {
            this.rate = 0.0;
        }
	}

	/* Method Name : toString
	   Parameters : None
	   Return value(s) : String
	   Partners : None
	   Description : returns String of the CommissionEmployee */
	
	public String toString() {

		return String.format("\n%sRate: %.2f\nSales: %.2f", super.toString(),rate, sales);

	}
	/* Method Name : calculateWeeklyPay
	   Parameters : None
	   Return value(s) : weekly pay, a double
	   Partners : None
	   Description : This will calculate weekly pay*/	
	
	public double calculateWeeklyPay() {
		double temp = 0;
		temp = rate * 0.01;
		return sales * temp;
	}

	/* Method Name : annualRaise
	   Parameters : None
	   Return value(s) : none
	   Partners : None
	   Description : rate percentage increased*/

	public void annualRaise() {
		rate += rate * .02;
	}
	/* Method Name : holidayBonus
	   Parameters : None
	   Return value(s) : bonus
	   Partners : None
	   Description : This method returns the holiday bonus*/
	 
	public double holidayBonus() {
		return 0;
	}

	/* Method Name : resetWeek
	   Parameters : None
	   Return value(s) : none
	   Partners : None
	   Description : resets sales to 0.0*/
	public void resetWeek() {
		sales = 0;
	}

	/* Method Name : increaseSales
	   Parameters : sales, a double
	   Return value(s) : increased sales, a double
	   Partners : None
	   Description : This method will increase the sales*/
	
	public void increaseSales(double sales) {
		if (sales >= 0) {
			this.sales = this.sales + sales;
		} else {
			System.out.print("\n Requested to increase sales by a negative value.No change and report the error.");
		}
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
