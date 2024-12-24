//METHODS

//METOO-J VALIDATE METHOD ARGUMENTS

//non compliant
private Object myState = null;

// Sets some internal state in the library
void setState(Object state) {
    myState = state;
}

// Performs some action using the state passed earlier
void useState() {
    // Perform some action here
}


//compliant
private Object myState = null;

// Sets some internal state in the library
void setState(Object state) {
    if (state == null) {
        // Handle null state
    }
    myState = state;
}

// Performs some action using the state passed earlier
void useState() {
    if (myState == null) {
        // Handle no state (e.g. null) condition
    }
    // Perform action with myState
}


//METOO3-J METHODS THAT PERFORM SECURITY CHECKS MUST BE DECLARED PRIVATE OR FINAL

//non compliant
public void readSensitiveFile()
{
	try{
		SecurityManager sm=System.getSecurityManager()'
		if (sm!=null)
		{
			//check for permission to read file
			sm.checkRead("/temp/tempFile");
		}
	}
	catch (SecurityException se)
	{
		//Log exception
	}
}

//compliant
public final void readSensitiveFile()
{
	try{
		SecurityManager sm=System.getSecurityManager()'
		if (sm!=null)
		{
			//check for permission to read file
			sm.checkRead("/temp/tempFile");
		}
	}
	catch (SecurityException se)
	{
		//Log exception
	}
}


//METOO4-J DONT INCREASE ACCESSIBILITY OF OVERRRIDDEN OR HIDDEN METHODS


//non compliant
class Super
{
	protected void doLogic()
	{
		System.out.println("Super invoked");
	}
}

public class Sub extends Super{
	public void doLogic()
	{
		System.out.println("Sub invoked");
	}
}


//compliant
class Super
{
	protected final void doLogic()
	{
		System.out.println("Super invoked");
	}
}
























