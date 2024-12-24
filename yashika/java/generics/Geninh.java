
//class Sub<T,V> extends Sup<T>

//simple generic class hierarchy

class Gen<T>
{
	T ob;

	Gen(T o)
	{
		ob=o;
	}

	T getOb()
	{
		return ob;
	}
}

class Gen2<T> extends Gen<T>
{
	Gen2(T o)
	{
		super(o);
	}
}

public class Whatever
{
	public static void main(String args[])
	{
		Gen2<Integer> num=new Gen2<Integer>(100);
		System.out.println("CLass gen data member "+num.getOb());
	}
}


//class hierarchy with non generic superclass

class Nongen
{
	int num

	Nongen(int i)
	{
		num=i
	}

	int getNum()
	{
		return num;
	}
}

class Gen2<T> extends Nongen
{
	T ob;

	Gen2(T o, int i)
	{
		super(i);
		ob=o;
	}

	T getOb()
	{
		return ob;
	}
}

public class Whatever
{
	public static void main(String args[])
	{
		Gen2<Integer> num=new Gen2<Integer>(100,200);
		System.out.println("Class non gen data member "+num.getNum());
		System.out.println("Class Gen2 data member "+num.getOb());
	}
}


//class hierarchy with method overriding

class Gen<T>
{
	T ob;

	Gen(T o)
	{
		ob=o;
	}

	T getOb()
	{
		System.out.println("Gen's getOb() ");
		return ob;
	}
}

class Gen2<T> extends Gen<T>
{
	Gen2(T o)
	{
		super(o);
	}

	T getOb()
	{
		System.out.println("Gen2's getOb() ")
		ewturn ob;
	}
}

public class Whatever
{
	public static void main(String args[])
	{
		Gen<?> gRef;

		Gen<Integer> iob1=new Gen<Integer>(90);
		Gen2<Integer> iob2=new Gen2<Integer>(100);

		gRef=iob1;
		System.out.println(gRef.getOb());

		gRef=iob2;
		System.out.println(gRef.getOb());
	}
}




























