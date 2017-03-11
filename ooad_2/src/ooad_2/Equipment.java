//not really building any new machines, so no builder.

package whattheactualfact;


public class Equipment 
{
	public enum WorkingStatuses
	{
		RUNNING,STOPPED,MALFUNCTION,WAITING_FOR_STOCK
	}
	
	
	
	private WorkingStatuses status= WorkingStatuses.STOPPED;
	
	private int[] stock = new int[4]; //0 electronics, 1 display, 2 case, 3 battery
	
	private int numberOfUnitsPending =0;
	private int numberOfUnitsCompleted=200;
	private int unitsCurrentlyInLineStart = 0;
	private int unitsCurrentlyInLineEnd = 16;//Machine processes 4 laptops in each section
	
	public Equipment()
	{
		
	}
	
	public Equipment(WorkingStatuses _status, int[] _stock,int _unitsPending, int _unitsCompleted, int _unitsCurrentlyInLineStart,int _stock_e,int _stock_d,int _stock_c,int _stock_b)
	{
		this.status=_status;
		this.stock= _stock;
		this.numberOfUnitsPending=_unitsPending;
		this.numberOfUnitsCompleted=_unitsCompleted;
		this.unitsCurrentlyInLineEnd=_unitsCurrentlyInLineStart;
		this.unitsCurrentlyInLineEnd=this.unitsCurrentlyInLineStart+16;
	}

	public WorkingStatuses getStatus() {
		return status;
	}

	public void setStatus(WorkingStatuses status) {
		this.status = status;
	}
	
	

	public int[] getWholeStock() {
		return stock;
	}

	public void setWholeStock(int[] stock) {
		this.stock = stock;
	}

	public int getSpecificStock(int stock_number) {
		return this.stock[stock_number];
	}
	
	public void editStock(int stock_number, int stock_value) {
		this.stock[stock_number] = stock_value;
	}

	public int getNumberOfUnitsPending() {
		return numberOfUnitsPending;
	}

	public void setNumberOfUnitsPending(int unitsPending) {
		this.numberOfUnitsPending = unitsPending;
	}

	public int getNumberOfUnitsCompleted() {
		return numberOfUnitsCompleted;
	}

	public void setNumberOfUnitsCompleted(int unitsCompleted) {
		this.numberOfUnitsCompleted = unitsCompleted;
	}

	public int getUnitsCurrentlyInLineStart() {
		return unitsCurrentlyInLineStart;
	}

	public void setUnitsCurrentlyInLineStart(int unitsCurrentlyInLineStart) {
		this.unitsCurrentlyInLineStart = unitsCurrentlyInLineStart;
	}

	public int getUnitsCurrentlyInLineEnd() {
		return unitsCurrentlyInLineEnd;
	}

}
