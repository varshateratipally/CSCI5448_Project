package whattheactualfact;

public class SalesAndInventory
{
	public enum LaptopModels
	{
		X86V1,X86V2,X64V1,X64V2,X128V1
	}
	
	private int[] currentMonthSales=new int[5];
	private int[] currentStock=new int[5];
	private int[] currentSellPrice=new int[5];
	private int[] currentCostPrice=new int[5];
	
	private int[] inventory= new int[] {0,0,0,0};
	
	
	private LaptopModels model = null;
	
	public SalesAndInventory()
	{
		
	}
	
	public SalesAndInventory(LaptopModels _model)
	{
		this.model=_model;
		
	}

}
