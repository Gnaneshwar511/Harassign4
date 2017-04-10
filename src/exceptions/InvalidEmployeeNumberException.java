package exceptions;

@SuppressWarnings("serial")
public class InvalidEmployeeNumberException extends Exception
{
   public InvalidEmployeeNumberException(int num)
   {
      super(num + " is not a valid EmployeeNumber\n");
   }
}
