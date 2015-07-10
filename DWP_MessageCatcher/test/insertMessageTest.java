import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;

import model.Message;

import mytools.DBUtil;

import org.junit.Test;

import data.MessageDB;


public class insertMessageTest
{

	@Test
	public void testInsertMessage()
	{

		Message originalMessage = new Message();
		Date date = new Date();
		Timestamp postTime = new Timestamp(date.getTime());
		originalMessage.setUsername("Fred Flintstone");
		originalMessage.setMessage("This is our test message!");
		originalMessage.setPostingTime(postTime);
		
		try 
		{
			long insertId = MessageDB.insertMessage(originalMessage);
			
			Message retrievedMessage = MessageDB.getMessageById(insertId);
			
			boolean test = ((originalMessage.getUsername().equals(retrievedMessage.getUsername())) &&
					(originalMessage.getMessage().equals(retrievedMessage.getMessage())));
			
			assertEquals (true, test);
		} 
		catch (Exception e)
		{
			fail("Method getCustEmail failed: " + e.getMessage());
		}	
		finally
		{
		
		}
	}

	@Test
	public void testGetMessageById()
	{
		
		Message originalMessage = new Message();
		Date date = new Date();
		Timestamp postTime = new Timestamp(date.getTime());
		originalMessage.setUsername("Fred Flintstone");
		originalMessage.setMessage("HWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
		originalMessage.setPostingTime(postTime);
		
		try 
		{
			long insertId = MessageDB.insertMessage(originalMessage);
			
			boolean test = (insertId == 0);
			
			System.out.println("After the test " + test);
			
			assertEquals (true, test);
		} 
		catch (Exception e)
		{
			fail("Method getCustEmail failed: " + e.getMessage());
		}	
		finally
		{
		}
		}
}