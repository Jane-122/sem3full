
class TickTock
{
	String state;

	synchronized void tick(boolean running)
	{
		if (!running)
		{
			state="ticked";
			notify();
			return;
		}

		Sytem.out.println("Tick");

		state="ticked";

		notify();

		try{
			while(!state.equals("tocked"))
				wait();
		}//catch
	}

	synchronized void tock(boolean running)
	{
		if (!running)
		{
			state="tocked";
			notify();
			return;
		}

		System.out.println("Tock");

		state="tocked";

		notify();

		try{
			while(!state.equals("ticked"))
				wait();
		}//catch
	}
}

class Mythread implments Runnable
{
	Thread t;
	TickTock tt;

	Mythread(String name, TickTock tt)
	{
		t=new Thread(this,name);
		this.tt=tt;
		t.start();
	}

	public void run()
	{
		if (t.getName().compareTo("Tick")==0)
		{
			for (int i=0; i<5; i++)
			{
				tt.tick(true);
			}
			tt.tick(false);
		}
		else{
			for (int i=0; i<5; i++)
			{
				t.tock(true);
			}
			t.tock(false);
		}
	}
}


class Main
{
	public static void main(String args[])
	{
		TickTock tt=new TickTock();
		Mythread to1=new Mythread("Tick",tt);
		//for tock

		try{
			to1.1.join();
			to2.t.join()
		}//catch
	}
}









































