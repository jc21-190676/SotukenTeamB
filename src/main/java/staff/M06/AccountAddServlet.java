package staff.M06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AccountAdd")
public class AccountAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AccountAddServlet() {
        super();
    }
       

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/staff/M06/AccountAdd.jsp").forward(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
