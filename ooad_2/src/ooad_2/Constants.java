package whattheactualfact;

import java.time.LocalDate;

public class Constants 
{
	public LocalDate currentDate= LocalDate.now();
	
	
	public static enum MachinesTypes
	{
		ELECTRONICS(0),DISPLAY(1),CASE(2),BATTERY(3);
		public int value;
		
		
		
		MachinesTypes(int value)
		{
			this.value=value;
		}
		public int getValue()
		{
			return this.value;
		}
		
		
	}
}
