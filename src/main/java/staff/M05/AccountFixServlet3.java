package staff.M05;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/AccountFix3")
public class AccountFixServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccountFixServlet3() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//アカウントを削除する機能
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String flg;
		int flg1 = 0;

		try {
			InitialContext ic = new InitialContext();
			DataSource  ds = (DataSource)ic.lookup("java:/comp/env/jdbc/teamb");
			Connection con=ds.getConnection();
			//管理者のアカウントの削除SQL
			PreparedStatement st =
					con.prepareStatement(
							"delete from account where account_id = ? and 1 < ? "
						);
			//管理者アカウントの人数取得SQL
			PreparedStatement st2 =
					con.prepareStatement(
							"select  count(*) as number from account where admin_flag = 1 "
						);
			//非管理者アカウントの削除SQL
			PreparedStatement st3 =
					con.prepareStatement(
							"delete from account where account_id = ? "
						);
			//管理者アカウントの判定SQL
			PreparedStatement st4 =
					con.prepareStatement(
							"select admin_flag from account where account_id = ? "
						);
			
			//管理者アカウントの判定処理
			st4.setString(1, id);
			ResultSet result = st4.executeQuery();
			result.next();
			flg = result.getString("admin_flag");
			
			//管理者アカウントの人数取得			
			ResultSet result2 = st2.executeQuery();
			result2.next();
			flg1 = result2.getInt("number");
			
			//アカウントの判別
			if(flg.equals("1")) {				
				
				if(flg1 < 1) {
			//管理者アカウントが2人以上いる場合は管理者アカウントを削除	
					st.setString(1, id);
					st.setString(2, flg);
					st.executeUpdate();
				}				
			
			}else {
			//非管理者アカウントの削除処理
					
					st3.setString(1, id);
					st3.executeUpdate();
				}
			
			
			System.out.println(id);
			
			
			con.close();
			
			
			request.getRequestDispatcher("Administrator").forward(request,response);
			response.getWriter().append("Served at: ").append(request.getContextPath());
			doGet(request, response);
			
			} catch (SQLException e ) {
				
				e.printStackTrace();
				
			} catch (Exception e) {
				
				e.printStackTrace();
		}
	}
}
