package staff.m01_requestmanagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class FlagChangeServlet
 */
@WebServlet("/m01_requestmanagement/FlagChangeServlet")
public class FlagChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlagChangeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			String id = request.getParameter("Recid");

			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/teamb");
			Connection con = ds.getConnection();
			PreparedStatement Fcst = con.prepareStatement(
					"SELECT d.division_id from division as d join reception as r on d.division_id = r.division_id where reception_id = ?");
			Fcst.setString(1, id);
			ResultSet Fcrs = Fcst.executeQuery();
			Fcrs.next();

			PreparedStatement Fcst2 = con
					.prepareStatement("update reception set division_id = ? where reception_id = ?");
			Fcst2.setString(2, id);

			switch (Fcrs.getString("division_id")) {
			case "R10":
				Fcst2.setString(1, "R20");
				break;

			case "R20":
				Fcst2.setString(1, "R30");
				break;

			case "R30":
				Fcst2.setString(1, "R40");
				break;

			case "R40":
				Fcst2.setString(1, "R40");
				break;
			default:
				break;
			}
			Fcst2.executeUpdate();

			Fcst.close();
			con.close();
			request.getRequestDispatcher("/m01_requestmanagement/RequestManagementServlet").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
