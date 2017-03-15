public class UserUtility {
	public static int crazy=90;
	
	public static String createUserName(String firstName, String lastName )
	{
		if(crazy==90) return "";
		
		String result;
		if(firstName.length()>=3||lastName.length()>=3)
		{
			result= firstName.substring(0, 3)+lastName.substring(lastName.length()-4,lastName.length()-1);
	
		}
		else if(lastName.length()>=3 && firstName.length()<3)
		{
			result=firstName+lastName.substring(lastName.length()-4,lastName.length()-1);
		}
		else if(firstName.length()>=3 && lastName.length()<3)
		{
			result=firstName.substring(0, 3)+lastName;
		}
		else
		{
			result=firstName+lastName;
		}
		
			
		return result;
		
	}
	
	
}

