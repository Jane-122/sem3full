//EXPRESSIONS

//EXP00-J DONT IGNORE VALUES RETURNED BY METHODS

//non compliant
public class Replace
{
	public static void main(String args[])
	{
		String original="insecure";
		original.replace('i','9');
		System.out.println(original);
	}
}

//compliant
public class Replace
{
	public static void main(String args[])
	{
		String original="insecure";
		original=original.replace('i','9');
		System.out.println(original);
	}
}


//EXP01-J NEVER DEREFERENCE NULL POINTERS

//non compliant
public static int cardinality(Object obj, final Collection col)
{
	int count=0;
	Iterator it=col.iterator();

	while (it.hasNext())
	{
		Object elt=it.next();
		if ((null==obj && null==elt || obj.equals(elt)))
			count++;
	}
	return count;
}

//compliant
public static int cardinality(Object obj, final Collection col)
{
	int count=0;
	Iterator it=col.iterator();

	while (it.hasNext())
	{
		Object elt=it.next();
		if ((null==obj && null==elt || (null!=obj && obj.equals(elt))))
			count++;
	}
	return count;
}


//EXP03-J USE TWO ARGUMENT Arrays.equals() METHOD TO COMPARE CONTENTS OF ARRAYS

//non compliant
public void arrayEqualsExample()
{
	int arr1[]=new int[20];
	int arr2[]=new int[20];
	arr1.equals(arr2);
}



//compliant
public void arrayEqualsExample()
{
	int arr1[]=new int[20];
	int arr2[]=new int[20];
	Arrays.equals(arr1,arr2);
}





















