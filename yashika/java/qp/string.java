public class DuplicateStrings
{
	public static void main(String[] args) {
        String[] array = {"apple", "banana", "orange", "apple", "banana", "apple", "grape"};

        // Call the method to find duplicates and their occurrences
        findDuplicates(array);
    }
}

public static void findDuplicates(String array[])
{
	for (int i=0; i<array.length; i++)
	{
		int count=1;

		if (array[i]==null)
		{
			continue;
		}

		for (int j=i+1; j<array.length; j++)
		{
			if (array[i].equals(array[j])
			{
				count++
				array[j]=null;
			}
		}

		if (count>1)
		{
			System.out.println(array[i]+" "+count);
		}
	}
}