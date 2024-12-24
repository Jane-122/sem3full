//STRINGS

//STR04-J DONT ENCODE NON CHARACTER DATA AS STRING

//non compliant
BigInteger x=new BigInteger("530500452766");
byte byteArray[]=x.toByteArray();
String s=new String(byteArray);

//compliant
BigInteger x =new BigInteger("530500452766");
String s=x.toString();
byte byteArray=s.getBytes();


//STR02-J SPECIFY APPROPRIATE LOCALE WHILE COMPARING LOCALE DEPENDENT DATA

//non compliant
public static void processTag(String tag)
{
	if (tag.toUpperCase().equals("SCRIPT"))
	{
		return;
	}

	//Process tag
}

//compliant
public static void processTag(String tag)
{
	if (tag.toUpperCase(Locale.ENGLISH).equals("SCRIPT"))
	{
		return;
	}

	//Process tag
}




















