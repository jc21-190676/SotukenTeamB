package staff.M04;

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

@WebServlet(name = "Administrator", urlPatterns = { "/Administrator" })
public class AdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdministratorServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// アカウントを一覧表示する機能

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/teamb");
			Connection con = ds.getConnection();
			PreparedStatement st = con.prepareStatement("select account_id,account_name,email  from account");
			ResultSet result = st.executeQuery();
			List<String[]> list = new ArrayList<>();

			while (result.next() == true) {

				String[] s = new String[3];
				s[0] = result.getString("account_id");
				s[1] = result.getString("account_name");
				s[2] = result.getString("email");
				list.add(s);
			}

			con.close();
			st.close();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/staff/M04/Administrator.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
