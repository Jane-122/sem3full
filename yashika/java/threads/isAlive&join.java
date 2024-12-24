
//isAlive()

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
		System.out.println("Main thread starting");

		Mythread to1=new Mythread("child 1");
		Mythread to2=new Mythread("child 2");

		do{
			System.out.print(".");
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException exc)
			{
					System.out.println("Main thread interrupted");
			}
		} while (to.t.isAlive() || to.t.isAlive());
		System.out.println("Main thread Ending");
	}
}

//join()

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
		System.out.println("Main thread starting");

		Mythread to1=new Mythread("child 1");
		Mythread to2=new Mythread("child 2");

		try{
			to1.t.join();
			to2.t.join();
		}
		catch(InterruptedException exc)
		{
			System.out.println("Main thread interrupted");
		}
		System.out.println("Main thread Ending");
	}
}




















