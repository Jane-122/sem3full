
//class C<T> implements I<T>
//class D implements I<String>

interface Containment<T>
{
	public boolean contains(T o);
}

class Myclass<T> implements Containment<T>
{
	T array[];

	Myclass(T o[])
	{
		array=o;
	}

	public boolean contains(T o)
	{
		for (T x : array)
		{
			if (x.equals(o)) return true;
			return false;
		}
	}
}


public class Geninterface
{
	public static void main(String args[])
	{
		Integer x[]={1,2,3};
		Myclass<Integer> ob=new Myclass<Integer>(x);

		if (ob.contains(2))
		{
			System.out.println("2 is in ob");
		}
		else{
			System.out.println("2 not in ob");
		}
	}
}

//interface Containment<T extends Number>
//class Myclass<T extends Number> implements Containment<T>
























