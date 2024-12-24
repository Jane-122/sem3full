
class Mythread implements Runnable
{
	Thread t;

	boolean suspended,stopped;

	Mythread(String name)
	{
		t=new Thread(this,name);
		suspended=false;
		suspended=false;
		t.start()
	}

	public void run()
	{
		System.out.println(t.getName()+" starting");

		try{
			//printing numbers bullshit

			synchronized(this)
			{
				while(suspended)
				{
					wait();
				}
				if (stopped) break;
			}
		}//catch

		System.out.println(t.getName()+"exiting")
	}

	synchronized void mystop()
	{
		stopped=true;

		suspended=false;
		notify()''
	}

	synchronized void mysuspend()
	{
		suspended=true;
	}

	synchronized void myresume()
	{
		suspended=false;
		notify();
	}
}

class Suspend
{
	//main
	Mythread to=new Mythread("My thread");

	try{
		Thread.sleep(1000);

		to.mysuspend();
		Thread.sleep(1000);

		to.myresume();
		Thread.sleep(1000);
		to.mystop();
	}//catch for main interrupt

	try{
		to.t.join();
	}//catch for main interrupt

	System.out.println("Main thread exiting ");
}



































