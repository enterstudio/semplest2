package semplest.server.queue.test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TestQueueListener implements MessageListener
{
	private String name = null;
	public TestQueueListener(String name)
	{
		this.name = name;
	}
    public void onMessage( final Message message )
    {
        if ( message instanceof TextMessage )
        {
            final TextMessage textMessage = (TextMessage) message;
            try
            {
                System.out.println( name + ":" + textMessage.getText() );
            }
            catch (final JMSException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
        	System.out.println("MQ message rec but not processed");
        }
    }
}
