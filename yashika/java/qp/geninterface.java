
public interface Stats<T extends Number>
{
	double avg();
}

public class StatsImpl<T extends Number> implements Stats<T>
{
	T values[];

	public StatsImpl(T values[])
	{
		this.values=values;
	}

	@Override
	public double avg()
	{
		double sum=0;
		for (T value : values)
		{
			sum+=value.doubleValue();
		}
		return sum/values.length;
	}

	public boolean compareAvg(StatsImpl<?> other)
	{
		return this.avg()==other.avg();
	}
}


public class StatsDemo
{
	//main
	Integer intVal={1,2,3};
	Double doubleVal={1.5,2.5};

	StatsImpl<Integer> intStats=new StatsImpl<>(intVal);
	//
	
	System.out.println("Average of Integer array "+intstats.avg());
	//

	boolean compare=intStats.compareAvg(doubleStats)
		
}

























