
public class DriverProgram
{
	
	private int numGoals;
	public int getNumGoals() {
		return numGoals;
	}
	public void setNumGoals(int numGoals) {
		this.numGoals = numGoals;
	}
	public static void main(String args[])
	{
		//UserUtility.crazy=100;
		
		System.out.println(new UserUtility().crazy);
		//System.out.println((UserUtility.crazy));
	}
}