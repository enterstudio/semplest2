package semplest.service.msn.adcenter;

public class NameServiceUniqueMsnPsuedoRandom implements NameServiceUniqueMsn {
	
	@Override
	public String getNextUserName() {
		StringBuilder name = new StringBuilder("U");
		long currentTimeMillis = System.currentTimeMillis();
		name.append(currentTimeMillis);
		return name.toString();
	}
	
	@Override
	public String getNextAdGroupName() {
		StringBuilder name = new StringBuilder("A");
		long currentTimeMillis = System.currentTimeMillis();
		name.append(currentTimeMillis);
		return name.toString();
	}
}
