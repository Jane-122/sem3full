class ExcDemo
{
	//main
	{
		int num={//some values..............};
		int den=(//some less values....);

		for (int i=0; i<num.length; i++)
		{
			try{
				System.out.println(num[i]+"/"+den[i]+" is "+ num[i]/den[i]);

			}
			catch(ArrayIndexOutOfBoundsException exc)
			{
				System.out.println("no matching element");
			}
			ctach (Throwable exc)
			{
				System.out.println("exception");
			}
		}
	}
}