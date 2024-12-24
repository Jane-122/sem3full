
public static <T> void printArray(T inputArray)
{
	for (T element : inputArray)
	{
		System.out.print(" "+element);
	}
	System.out.println();
}

public static void main(String args[])
{
	Integer intArray[]={1,2,3,4,5};
	Character charArray={'H','I'};

	System.out.println("Integer array contents");
	printArray(intArray);

	System.out.println("Character array contents");
	printArray(charArray);

}