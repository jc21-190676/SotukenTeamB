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

@WebServlet("/AccountFix4")
public class AccountFixServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccountFixServlet4() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//アカウントの情報を修正するプログラム
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String flg = request.getParameter("flg");

		try {
			InitialContext ic = new InitialContext();
			DataSource  ds = (DataSource)ic.lookup("java:/comp/env/jdbc/teamb");
			Connection con=ds.getConnection();
			PreparedStatement st =
					con.prepareStatement(
							"update account set account_name = ?,email = ?,admin_flag = ? where account_id = ?"
						);
			
			if(flg == null) {
				flg = "0";
				
			}
			
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, flg);
			st.setString(4, id);			
			st.executeUpdate();
			con.close();
			
			request.getRequestDispatcher("Administrator").forward(request,response);
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			} catch (SQLException e ) {
					
					e.printStackTrace();
					
			} catch (Exception e) {
					
					e.printStackTrace();
			}
		
	}

}
