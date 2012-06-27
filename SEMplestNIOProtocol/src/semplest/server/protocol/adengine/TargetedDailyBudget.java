package semplest.server.protocol.adengine;

public class TargetedDailyBudget
{
	private Long TargetedDailyMicroBudget;
	private Integer TargetedDailyClicks;
	private Long TargetedCPC;
	
	public TargetedDailyBudget(){
	}
	
	public TargetedDailyBudget(Long TargetedDailyMicroBudget, Integer TargetedDailyClicks, Long TargetedCPC){
		this.TargetedDailyMicroBudget = TargetedDailyMicroBudget;
		this.TargetedDailyClicks = TargetedDailyClicks;
		this.TargetedCPC = TargetedCPC;
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
	public Long getTargetedCPC() {
		return TargetedCPC;
	}

	public void setTargetedCPC(Long targetedCPC) {
		TargetedCPC = targetedCPC;
	}

}
