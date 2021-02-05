

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
@WebServlet("/RegisterInsert")
public class RegisterInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterInsert() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  int regno=Integer.parseInt(request.getParameter("regno"));
	  String name=request.getParameter("name");
	  String email=request.getParameter("email");
	  String passwd=request.getParameter("passwd");
	  int year=Integer.parseInt(request.getParameter("year"));
	  int sec=Integer.parseInt(request.getParameter("sec"));
	  RegisterBean sb=new RegisterBean();
	  sb.setRegno(regno);
	  sb.setName(name);
	  sb.setEmail(email);
	  sb.setPasswd(passwd);
	  sb.setYear(year);
	  sb.setSec(sec);
	  
	  //PrintWriter pw=response.getWriter();
	  //pw.print("Welcome"+"  "+name);
	
	  RegisterDAO dao=new RegisterDAO();
	  try {
		int i=dao.RegisterInsert(sb);
		if (i>0) {
			RequestDispatcher rd=request.getRequestDispatcher("RegisterDisplay");
			request.setAttribute("Registerbean",sb);
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