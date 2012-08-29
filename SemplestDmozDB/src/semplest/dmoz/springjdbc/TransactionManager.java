package semplest.dmoz.springjdbc;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

public class TransactionManager extends JdbcDaoSupport
{

	public static TransactionTemplate txTemplate;
	private static final Logger logger = Logger.getLogger(TransactionManager.class);

	public void setTransactionManager(PlatformTransactionManager txManager)
	{
		txTemplate = new TransactionTemplate(txManager);
		txTemplate.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
		logger.info("Spring JDBC Transaction manager initialized");
	}

	/*
	public TransactionTemplate getTxTemplate()
	{
		return txTemplate;
	}

*/
}
