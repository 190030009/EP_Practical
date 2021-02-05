import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginInsert")
public class LoginInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public LoginInsert() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String passwd = request.getParameter("pswd");
		PrintWriter pw=response.getWriter();
		
		
		try {
			Connection con=DBConn.DBConnection();		
			PreparedStatement ps = con.prepareStatement("select * from feedback where email=? and passwd=?");
			ps.setString(1,email);
            ps.setString(2,passwd);
            ResultSet rs = ps.executeQuery();
            String email1,passwd1;
			
			if(rs.next()) 
			{
				email1 = rs.getString("email");
				passwd1 = rs.getString("passwd");
				if (email1.equals(email1) && passwd1.equals(passwd1)) 
			         {
						//pw.write("WELCOME");
						RequestDispatcher rd=request.getRequestDispatcher("feedback.html");
						rd.forward(request, response);
			          }
				else 
				{
					pw.write("INVALID CREDENTIALS");	
				}
			con.close();
			}
		}
		catch (ClassNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} // sb have details of client

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}