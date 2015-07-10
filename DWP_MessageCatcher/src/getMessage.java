

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.MessageDB;
import model.Message;
import java.sql.Timestamp;

/**
 * Servlet implementation class getMessage
 */
@WebServlet("/getMessage")
public class getMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		Message message = new Message();
		boolean isDuplicate = false;
		String url = "/displayMessages.jsp";
		String name = null;
		String messageText = null;
		Date date = new Date();
		Timestamp postTime = new Timestamp(date.getTime());
		
		name = request.getParameter("username");
		messageText = request.getParameter("messageContent");
		
		String path = request.getPathInfo();
		
		message.setUsername(name);
		message.setMessage(messageText);
		message.setPostingTime(postTime);
		
		if(session.getAttribute("lastRecNo") != null)
		{
			long testLong = (long)session.getAttribute("lastRecNo");
			System.out.println("Value of last rec ID : " + testLong);
		}
		
		if(session.getAttribute("lastRecNo") != null)
		{
			Message lastMessage = MessageDB.getMessageById((long)session.getAttribute("lastRecNo"));
			
			if((lastMessage.getUsername().equals(message.getUsername())) && (lastMessage.getMessage().equals(message.getMessage())))
			{
				isDuplicate = true;				
			}
		}
		
		// insert created message object only if it is not a duplicate
		if (!isDuplicate)
		{
			long idReturned = MessageDB.insertMessage(message);	// message not a duplicate
			session.setAttribute("lastRecNo", idReturned);		// save newly inserted message id for next iteration
		}
		
		List<Message> messages = MessageDB.getMessages();
		
		request.setAttribute("messages", messages);
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
