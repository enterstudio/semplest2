package semplest.dmoz.objects;

public class AddSemplestTreeRequest {
	private Long DMOZSemplestPK;
	private Long DMOZURLDataPK;
	private String Domain;
	
	public Long getDMOZSemplestPK() {
		return DMOZSemplestPK;
	}
	public void setDMOZSemplestPK(Long dMOZSemplestPK) {
		DMOZSemplestPK = dMOZSemplestPK;
	}
	public Long getDMOZURLDataPK() {
		return DMOZURLDataPK;
	}
	public void setDMOZURLDataPK(Long dMOZURLDataPK) {
		DMOZURLDataPK = dMOZURLDataPK;
	}
	public String getDomain() {
		return Domain;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}
	
}
