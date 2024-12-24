
class A
{
	
}

class B extends A
{
	
}

class C extends A
{
	
}

class D
{
	
}


class Gen<T>
{
	T ob;

	Gen(T o)
	{
		ob=o;
	}
}

static void test(Gen<? extends A> o)
{

}

class BoundedWildcards
{
	public static void main(String args[])
	{
		A a=new A();
		B b=new B();
		C c=new C();
		D d=new D();
	}

	Gen<A> w1=new Gen<A>(a);
	//w2,w3,w4

	test(w);
	//for w2, w3

	//w4 - error
}

//upper bound
//<? extends superclass>

//lower bound
//<? super subclass>



















































