

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentInsert
 */
public class StudentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public StudentInsert() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  int regno=Integer.parseInt(request.getParameter("regno"));
	  String name=request.getParameter("name");
	  StudentBean sb=new StudentBean();
	  sb.setRegno(regno);
	  sb.setName(name);
	
	  //PrintWriter pw=response.getWriter();
	  //pw.print(regno+"    "+name);
	  StudentDAO dao=new StudentDAO();
	  try {
		int i=dao.studentInsert(sb);
		if (i>0) {
			RequestDispatcher rd=request.getRequestDispatcher("studentDisplay");
			request.setAttribute("studentbean",sb);
			rd.forward(request, response);
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