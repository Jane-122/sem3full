 
 class Numeric<T extends Number>
 {
 	T num;

 	Numeric(T n)
 	{
 		num=n;
 	}

 	double reciprocal()
 	{
 		return 1/num.doubleValue();
 	}

 	double fraction()
 	{
 		return num.doubleValue()-num.intValue();
 	}
 }

 class Boundedtypes
 {
 	public static void main(String args[])
 	{
 		Numeric<Integer> iOb=new Numeric<Integer>(5);
 	}

 	System.out.println("Reciprocal is "+iOb.reciprocal());
 	System.out.println("Fraction is "+iOb.fraction());
 }


//using two type parameters

 class Pair<T,V extends T>
 {
 	T first;
 	V second;

 	Pair(T a, V b)
 	{
 		first=a;
 		second=b;
 	}
 }

 //in class main
 Pair<Integer,Integer> x=new Pair<Integer, Integer>(1,2);

 Pair<Number,Integer> y=new Pair<Number, Integer>(10.4,12);
 




























