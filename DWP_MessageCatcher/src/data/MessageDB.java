package data;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Message;
import mytools.DBUtil;

public class MessageDB
{
	
	public static long insertMessage (Message message)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		long idReturned = 0;
		try
		{
			trans.begin();
			em.persist(message);
			em.flush();
			idReturned = message.getMessageId();
			trans.commit();
			return idReturned;
		}
		catch (Exception e)
		{
			trans.rollback();
			System.out.println("A problem occurred while inserting message: " + e);
			return 0;
		}
		finally 
		{
			em.close();
		}
	}
	
	public static List<Message> getMessages()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT m FROM Message m ORDER BY m.postingTime DESC";
		TypedQuery<Message> q = em.createQuery(qString, Message.class);
				
		
		List<Message> messages = null;
		
		try	// actually get the scores from the database
		{
			messages = q.getResultList();
			if (messages == null || messages.isEmpty())
				messages = null;
			return messages;
		}
		catch (Exception e)
		{
			System.out.println("A problem occurred while retrieving messages: " + e);
			return null;
		}
		finally 
		{
			em.close();
		}
	}
	
	
	public static List<Message> getMessagesAscending()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT m FROM Message m ORDER BY m.postingTime";
		TypedQuery<Message> q = em.createQuery(qString, Message.class);
				
		
		List<Message> messages = null;
		
		try	// actually get the scores from the database
		{
			messages = q.getResultList();
			if (messages == null || messages.isEmpty())
				messages = null;
			return messages;
		}
		catch (Exception e)
		{
			System.out.println("A problem occurred while retrieving messages: " + e);
			return null;
		}
		finally 
		{
			em.close();
		}
	}
	
	public static Message getTopMessage()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT m FROM Message m ORDER BY m.postingTime DESC";
		TypedQuery<Message> q = em.createQuery(qString, Message.class);
		q.setFirstResult(0);
		q.setMaxResults(1);
				
		
		List<Message> messages = null;
		
		try	// actually get the scores from the database
		{
			messages = q.getResultList();
			if (messages == null || messages.isEmpty())
				messages = null;
			return messages.get(0);
		}
		catch (Exception e)
		{
			System.out.println("A problem occurred while retrieving newest message: " + e);
			return null;
		}
		finally 
		{
			em.close();
		}
	}
	
	
	public static Message getMessageById(long id)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		
		try
		{
			Message message = em.find(Message.class, id);
			return message;
		}
		finally
		{
			em.close();
		}
	}
}
