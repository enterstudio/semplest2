package semplest.server.service.springjdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionManager extends JdbcDaoSupport
{

	public static TransactionTemplate txTemplate;

	public void setTransactionManager(PlatformTransactionManager txManager)
	{
		txTemplate = new TransactionTemplate(txManager);
		txTemplate.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
	}

	/*
	public TransactionTemplate getTxTemplate()
	{
		return txTemplate;
	}

*/
}
