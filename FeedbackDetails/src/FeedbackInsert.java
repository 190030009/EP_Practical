

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterInsert
 */
@WebServlet("/FeedbackInsert")
public class FeedbackInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FeedbackInsert() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  String r1=request.getParameter("r1");
	  String r2=request.getParameter("r2");
	  String r3=request.getParameter("r3");
	  String r4=request.getParameter("r4");
	  String r5=request.getParameter("r5");
	  FeedbackBean sb=new FeedbackBean();
	  PrintWriter pw=response.getWriter();
	  sb.setR1(r1);
	  sb.setR2(r2);
	  sb.setR3(r3);
	  sb.setR4(r4);
	  sb.setR5(r5);
	  
	  //PrintWriter pw=response.getWriter();
	  //pw.print("Welcome"+"  "+name);
	
	  FeedbackDAO dao=new FeedbackDAO();
	  try {
		int i=dao.FeedbackInsert(sb);
		if (i>0) {
			pw.write("WELCOME");
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("error.html");
			rd.include(request, response);
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}