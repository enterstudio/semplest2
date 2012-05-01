package semplest.server.protocol.adengine;

public class BudgetObject
{
	private Double remainingBudgetInCycle;
	private Integer remainingDays;
	public Double getRemainingBudgetInCycle()
	{
		return remainingBudgetInCycle;
	}
	public void setRemainingBudgetInCycle(Double remainingBudgetInCycle)
	{
		this.remainingBudgetInCycle = remainingBudgetInCycle;
	}
	public Integer getRemainingDays()
	{
		return remainingDays;
	}
	public void setRemainingDays(Integer remainingDays)
	{
		this.remainingDays = remainingDays;
	}

}
