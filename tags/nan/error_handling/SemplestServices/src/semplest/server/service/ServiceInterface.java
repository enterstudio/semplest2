package semplest.server.service;

import semplest.other.SemplestServiceException;
import semplest.other.SemplestSystemException;


public interface ServiceInterface
{
	public String ServiceGet(String methodName, String jsonStr) throws SemplestServiceException, SemplestSystemException;

}
