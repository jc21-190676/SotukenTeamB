package staff.M05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/AccountFix2")
public class AccountFixServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AccountFixServlet2() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		doPost(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//指定したアカウントを表示するプログラム
		String id = request.getParameter("id");

		try {
			InitialContext ic = new InitialContext();
			DataSource  ds = (DataSource)ic.lookup("java:/comp/env/jdbc/teamb");
			Connection con=ds.getConnection();
			PreparedStatement st =
					con.prepareStatement(
							"select account_name,email,admin_flag,account_id from account where account_id = ?"
						);
			
			System.out.println(id);
			st.setString(1, id);
			
			ResultSet result = st.executeQuery();
			List<String[]> list = new ArrayList<>();
			
			while( result.next() == true) {
				
				String[] s = new String[4];
				s[0] = result.getString("account_name");
				s[1] = result.getString("email");
				s[2] = result.getString("admin_flag");
				s[3] = result.getString("account_id");
				list.add(s);
			}	
			
			con.close();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/staff/M05/AccountFix2.jsp").forward(request,response);



		} catch (SQLException e ) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
