import java.util.*

abstract class Emp
{
	private String name;
	Emp(String s)
	{
		name=s;
	}

	String getName()
	{
		return name;
	}

	abstract void computeSal();
}

class RegEmp extends Emp
{
	int salary;
	RegEmp(String n, int s)
	{
		super(n);
		salary=s;
	}
	void computeSal()
	{
		System.out.println("Name: "+getName()+" Salary: "+salary);

	}
}

class PartEmp extends RegEmp
{
	static int rate=500;
	int no_hrs;

	PartEmp(String s, int n)
	{
		super(s);
		no_hrs=n;
	}

	void computeSal()
	{
		double sal;
		if (no_hrs>40)
			sal=((no_hrs-40)*1.5+40)*rate;
		else sal=no_hrs*rate;
		System.out.println("Name "+getName()+" Salary "+sal);

	}
}

class CommEmp extends Emp
{
	static double com_rate=0.05;
	int totalsales;

	CommEmp(String s, int n)
	{
		super(s);
		totalsales=n;
	}

	void computeSal()
	{
		System.out.println("Name "+getName()+" Salary "+com_rate*totalsales);

	}
}

class MSemp
{
	public static void main(String args[])
	{
		Emp e[]=new Emp[3];
		e[0]=new RegEmp("Anand",80000);
		e[1]=new PartEmp("Arun",45);
		e[2]=new CommEmp("Sushma",20000000);
		for (int i=0; i<3; i++)
		{
			e[i].computeSal();
		}
	}
}



































































