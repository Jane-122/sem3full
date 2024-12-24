
//implementing runnable

class Mythread implements Runnable
{
	String tname;

	Mythread(String name)
	{
		tname=name;
	}

	//entry point of thread
	public void run()
	{
		System.out.println(tname+"starting");
		try{
			for (int i=0; i<=10; count++)
			{
				Thread.sleep(400);
				System.out.println("In"+tname+", count is "+i);
			}
		}
		catch(InterruptedException exc)
		{
			System.out.println(tname+"interrupted");
		}
		System.out.println(tname+"terminating")
	}
}

class Main
{
	public static void main(String args[])
	{
		System.out.println("Main thread starting")

		//create runnable object
		Mythread to=new Mythread("Child");

		//construct thread on the object
		Thread t=new Thread(to);

		t.start();

		for (int i=0; i<50; i++)
		{
			System.out.println(".");
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException exc)
			{
				System.out.println("Main thread interrupted");
			}
		}
		System.out.println("Main thread ending");
	}
}

//to have main thread finish last

class Mythread implements Runnable
{
	Thread t; //reference to the thread stored in t

	Mythread(String name)
	{
		t=new Thread(this,name);
		t.start();
	}

	//entry point of thread
	public void run()
	{
		System.out.println(tname+"starting");
		try{
			for (int i=0; i<=10; i++)
			{
				Thread.sleep(400);
				System.out.println("In"+t.getName()+", count is "+i);
			}
		}
		catch(InterruptedException exc)
		{
			System.out.println(t.getName()+"interrupted");
		}
		System.out.println(t.getName()+"terminating")
	}
}

class Main
{
	public static void main(String args[])
	{
		System.out.println("Main thread starting")

		//create runnable object
		Mythread to=new Mythread("Child");

		for (int i=0; i<50; i++)
		{
			System.out.println(".");
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException exc)
			{
				System.out.println("Main thread interrupted");
			}
		}
		System.out.println("Main thread ending");
	}
}

//extend Thread

class Mythread extends Thread
{
	Mythread(String name)
	{
		super(name);
		start();
	}

	public void run()
	{
		System.out.println(getName()+"starting");
		try{
			for (int i=0; i<=10; i++)
			{
				Thread.sleep(400);
				System.out.println("In"+getName()+", count is "+i);
			}
		}
		catch(InterruptedException exc)
		{
			System.out.println(getName()+"interrupted");
		}
		System.out.println(getName()+"terminating")
	}
}


class Main
{
	public static void main(String args[])
	{
		System.out.println("Main thread starting")

		//create runnable object
		Mythread to=new Mythread("Child");

		for (int i=0; i<50; i++)
		{
			System.out.println(".");
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException exc)
			{
				System.out.println("Main thread interrupted");
			}
		}
		System.out.println("Main thread ending");
	}
}














































































