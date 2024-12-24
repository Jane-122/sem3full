class InvalidTransactionException extends Exception
{
	public InvalidTransactionException(String message)
	{
		super(message);
	}
}

class InsufficientBalanceException extends InvalidTransactionException
{
	public InsufficientBalanceException(String message)
	{
		super(message);
	}
}

class DailyLimitExceededException extends InvalidTransactionException
{
	public DailyLimitExceededException(String message)
	{
		super(message);
	}
}

public class BankTransaction
{
	private static final String VALID_ACCOUNT_NUMBER="12345678";
	private static final double DAILY_LIMIT=50000.0;
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		try{
			System.out.println("Enter account number ");
			String accountNo=in.nextLine();
			try{
				if (!accountNo.equals(VALID_ACCOUNT_NUMBER))
				{
					throw new InvalidTransactionException("Invalid account number entered");
				}

				System.out.println("Enter current balance ");
				double currentBalance=in.nextDouble();

				System.out.println("Enter withdrawal amount ");
				double withdrawalAmount=in.nextDouble();

				try{
					if (withdrawalAmount>DAILY_LIMIT)
					{
						throw new DailyLimitExceededException("Withdrawal exceeds the dialty limit of 50000 units");
					}

					if (withdrawalAmount>currentBalance)
					{
						throw new InsufficientBalanceException("Insufficient balance for withdrawal");
					}

					currentBalance-=withdrawalAmount;
					System.out.println("Transaction successful! Updated Balance - "+currentBalance);
				} catch (InsufficientBalanceException | DailyLimitExceededException e)
				System.out.println("Error "+e.getMessage());
			} catch (InvalidTransactionException e)
			{
				System.out.println("Error "+e.getMessage());
			}
		}
	}
}




















