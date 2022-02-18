package staff.m03_Inventorylist;

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


/**
 * Servlet implementation class RequestManagementServlet
 */
@WebServlet("/m03_InventoryList/InventoryListServlet")
public class InventoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<staff.bean.InventoryListBean> Ilist = new ArrayList<staff.bean.InventoryListBean>();
			
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/teamb");
			Connection con = ds.getConnection();
			PreparedStatement ILst = con.prepareStatement("select r.reception_id , s.email , r.reception_date from Reception as r join Student as s on r.student_no = s.student_no join Division as d on r.division_id = d.division_id where d.division_id ='R30' ");
			ResultSet ILrs = ILst.executeQuery();
			System.out.println("start");
			while(ILrs.next()) {
			staff.bean.InventoryListBean IBean = new staff.bean.InventoryListBean();
			
			IBean.setReception_id(ILrs.getString("reception_id"));
			IBean.setEmail(ILrs.getString("Email"));
			IBean.setReception_date(ILrs.getString("reception_date"));
			
			
			Ilist.add(IBean);
			}
			ILst.close();
			con.close();
			
			request.setAttribute("Ilist", Ilist);
			request.getRequestDispatcher("/WEB-INF/staff/M03/InventoryList.jsp").forward(request, response);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
