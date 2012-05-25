package semplest.server.protocol.adengine;

public class TargetedDailyBudget
{
	private Long TargetedDailyMicroBudget;
	private Integer TargetedDailyClicks;
	
	public TargetedDailyBudget(){
	}
	
	public TargetedDailyBudget(Long TargetedDailyMicroBudget, Integer TargetedDailyClicks){
		this.TargetedDailyMicroBudget = TargetedDailyMicroBudget;
		this.TargetedDailyClicks = TargetedDailyClicks;
	}
	
	public Long getTargetedDailyMicroBudget()
	{
		return TargetedDailyMicroBudget;
	}
	public void setTargetedDailyMicroBudget(Long targetedDailyMicroBudget)
	{
		TargetedDailyMicroBudget = targetedDailyMicroBudget;
	}
	public Integer getTargetedDailyClicks()
	{
		return TargetedDailyClicks;
	}
	public void setTargetedDailyClicks(Integer targetedDailyClicks)
	{
		TargetedDailyClicks = targetedDailyClicks;
	}

}
