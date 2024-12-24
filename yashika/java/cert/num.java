//NUMERIC TYPES

//NUM00-J DETECT OR PREVENT INTEGER FLOW

//non compliant
public static int mulAccount(int oldAcc, int newVal, int scale)
{
	return oldAcc+(newVal*scale);
}

//compliant - precondition testing
public static int mulAccount(int oldAcc, int newVal, int scale) throws ArithmeticException
{
	return safeAdd(oldAcc,safeMultiply(newVal,scale));
}

//compliant - upcasting
public static long intRangeCheck(long value) throws ArithmeticException
{
	if ((value<Integer.MIN_VALUE) || (value>Integer.MAX_VALUE))
	{
		throw new ArithmeticExceptiom("Integer Overflow");
	}
	return value;
}
public static int mulAccount(int oldAcc, int newVal, int scale) throws ArithmeticException
{
	final long res=intRangeCheck( (long) oldAcc + intRangeCheck( (long) newVal*(long) scale) );
	return (int) res;
}


//NUM02-J ENSURE THAT DIVISION AND MODULO OPERATIONS DONT RESULT IN DIVIDE-BY-XERO ERRORS

//divison

//non compliant
long num1,num2,result;
result=num1/num2;

//compliant
long num1,num2,result;
if (num2==0)
{
	//handle error
}
else
	result=num1/num2;

//modulo

//non compliant
long num1,num2,result;
result=num1%num2;

//compliant
long num1,num2,result;
if (num2==0)
{
	//handle error
}
else
	result=num1%num2;


//NUM04-J DONT USE FLOATING POINT NUMBERS IF PRECISE COMPUTATION IS REQUIRED

//non compliant
double dollar=1.00;
double dime=0.10;
int number=7;
System.out.println("a dollar less"+number+"dimes is $"+ (dollar-number*dime));

//compliant
long dollar=100;
long dime=10;
int number=7;
System.out.println("a dollar less"+number+"dimes is"+ (dollar-number*dime)+"cents");




















































