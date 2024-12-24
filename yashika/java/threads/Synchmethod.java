
class SumArray
{
	private int sum;

	synchronized int sumArray(int nums[])
	{
		sum=0;

		for (int i=0; i<nums.length, i++)
		{
			sum+=nums[i];

			System.out.println("Running total for "+Thread.currentThread().getName()+"is"+sum);

			try
			{
				Thread.sleep(10);
			}
			catch(InterruptedException exc)
			{
				System.out.println("Thread interrupted");
			}
		}
		return sum;
	}
}

class Mythread implements Runnable
{
	Thread t;
	SumArray sa=new SumArray();
	int a[];
	int answer;

	Mythread(String name, int nums[])
	t=new Thread(this,name);
	a=nums;
	t.start();

	public void run()
	{
		int sum;

		System.out.println(t.getName()+"starting");

		answer=sa.sumArray(a);

		System.out.println(t.getName()+"terminating");
	}
}

class Main
{
	public static void main(String args[])
	{
		int a[]={1,2,3,4,5};

		Mythread to1=new Mythread("Child 1",a);
		Mythread to1=new Mythread("Child 2",a);

		try{
			to1.t.join();
			to2.t.join();
		}
	}
	//catch for main interrupted
}
















































