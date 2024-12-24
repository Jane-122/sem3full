import java.util.Scanner;

class LeapYearException extends Exception
{
	public LeapYearException(String message)
	{
		super(message);
	}
}

class Student
{
	private String name;
	priavte int graduationYear;

	public Student(String name, int graduationYear)
	{
		this.name=name;
		this.graduationYear=graduationYear;
	}

	public int getName()
	{
		return name;
	}

	public int getGraduationYear()
	{
		return graduationYear;
	}

	public void checkLeapYear() throws LeapYearException
	{
		if ((graduationYear%4==0 && graduationYear%100!=0) || (graduationYear%400==0))
		{
			throw new LeapYearException("Graduation year "+graduationYear+" is a leap year ");
		}
	}
}

public class LeapYearCheck
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		try{
			System.out.println("Enter student name ");
			String name=in.nextLine();
			System.out.println("Enter graduation year ");
			int graduationYear=in.nextInt();
			Student student=new Student(name,graduationYear);
			student.checkLeapYear();
			System.out.println("Student "+student.getName()+" has a non leap graduation year "+ student.getGraduationYear());			
		}
		catch(LeapYearException e){
			System.out.println(e.getMessage());
		}
		finally{
			scanner.close();
		}
	}
}




































































