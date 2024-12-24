
public class Car 
{
	private String carname;

	public Car()
	{
		this.carname="";
	}

	public Car(String carname)
	{
		this.carname=carname;
	}

	public String getCarname()
	{
		return carname;
	}

	public void setCarname(String carname)
	{
		this.carname=carname;
	}

	public void displayCar()
	{
		System.out.println("Car Name "+carname);
	}
}

public class Model
{
	private String modelname;

	public Model()
	{
		this.modelname="";
	}

	public Model(String modelname)
	{
		this.modelname=modelname;
	}

	public String getModelname()
	{
		return modelname;
	}

	public void setModelname(String modelname)
	{
		this.modelname=modelname;
	}

	public void displayModel()
	{
		System.out.println("Model Name "+modelname);
	}
}

class Result
{
	public void merge(Car car, Model model)
	{
		String merged=car.getCarname()+" "+model.getModelname();
		System.out.println("Concatenated Result "+merged);

	}
}


class Main
{
	public static void main(String args[])
	{
		Car car=new Car("Toyota");
		Model model=new Model("Corolla");

		System.out.println("before");

		car.displayCar();
		model.displayModel();

		System.out.println("after");

		Result r=new Result();

		r.merge(car, model);
	}
}























































