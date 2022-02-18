package staff.m01_requestmanagement;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import staff.bean.RequestBean;


/**
 * Servlet implementation class RequestManagementServlet
 */
@WebServlet("/m01_requestmanagement/RequestManagementServlet")
public class RequestManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			List<staff.bean.RequestBean> list = new ArrayList<staff.bean.RequestBean>();

			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/teamb");
			Connection con = ds.getConnection();
			PreparedStatement Recst = con.prepareStatement("SELECT r.reception_id,r.student_no,r.reception_date,d.division_name,d.division_id FROM Reception as r JOIN Division as d ON r.division_id = d.division_id where d.division_id <> 'R40' order by r.reception_id");
			ResultSet Recrs = Recst.executeQuery();
			
			while(Recrs.next()) {
			RequestBean Rbean = new RequestBean();
			
			Rbean.setReception_id(Recrs.getString("reception_id"));
			Rbean.setStudent_no(Recrs.getString("student_no"));
			Rbean.setReception_date(Recrs.getString("reception_date"));
			Rbean.setDivision_flag(Recrs.getString("division_name"));
			
			switch(Recrs.getString("division_id")) {
				case "R10": Rbean.setNext_flag("発行準備中");
							
				break;
				case "R20": Rbean.setNext_flag("発行準備完了");
				break;
				case "R30": Rbean.setNext_flag("受渡し済み");
				break;
				case "R40": Rbean.setNext_flag("受渡し済み");
				break;
				default:break;
			}
			
			list.add(Rbean);
			}
			Recst.close();
			con.close();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/staff/M01/RequestManagement.jsp").forward(request, response);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
