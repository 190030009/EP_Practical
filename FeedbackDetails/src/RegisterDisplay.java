

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterDisplay
 */
public class RegisterDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterDisplay() {
    }
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterBean sb=(RegisterBean) request.getAttribute("Registerbean");
		PrintWriter pw=response.getWriter();
		pw.print("Welcome"+"  "+sb.getName());
	}

}
