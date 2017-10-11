package ca.mcgill.cs.swdesign.m2;

@SuppressWarnings("serial")
public class EmptyDeckException extends Exception
{

	public EmptyDeckException()
	{}

	public EmptyDeckException(String pMessage)
	{
		super(pMessage);
	}

	public EmptyDeckException(Throwable pException)
	{
		super(pException);
	}

	public EmptyDeckException(String pMessage, Throwable pException)
	{
		super(pMessage, pException);
	}

	public EmptyDeckException(String arg0, Throwable arg1, boolean arg2, boolean arg3)
	{
		super(arg0, arg1, arg2, arg3);
	}

}
