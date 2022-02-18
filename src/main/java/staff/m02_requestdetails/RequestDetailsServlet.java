package staff.m02_requestdetails;

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

import staff.bean.RequestDetailsBean;

/**
 * Servlet implementation class RequestDetailsServlet
 */
@WebServlet("/m02_requestdetails/RequestDetailsServlet")
public class RequestDetailsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/teamb");
			Connection con = ds.getConnection();
			PreparedStatement Rdst = con.prepareStatement("select r.reception_id , r.reception_date, r.student_no, r.reception_date, s.name, s.birthday, r.school_grade, d.dept_name, c.certificate_name, rd.quantity , r.total_price from reception as r join reception_details as rd on r.reception_id = rd.reception_id join certificate as c  on rd.certificate_id = c.certificate_id join dept as d on r.dept_id = d.dept_id join student as s on r.student_no = s.student_no where r.reception_id = ?" );
		
			int  id  = Integer.parseInt(request.getParameter("id"));
			Rdst.setInt(1,id);
			
			ResultSet Rdrs = Rdst.executeQuery();
			
			List<RequestDetailsBean> RDlist = new ArrayList<RequestDetailsBean>();
			System.out.println("start");
			while(Rdrs.next()) {
			RequestDetailsBean Rbean = new RequestDetailsBean();
			
			Rbean.setReception_id(Rdrs.getString("reception_id"));
			Rbean.setStudent_no(Rdrs.getString("student_no"));
			Rbean.setReception_date(Rdrs.getString("reception_date"));
			Rbean.setName(Rdrs.getString("name"));
			Rbean.setBirthday(Rdrs.getString("birthday"));
			Rbean.setSchool_grade(Rdrs.getString("school_grade"));
			Rbean.setDept_name(Rdrs.getString("dept_name"));
			Rbean.setCertificate_name(Rdrs.getString("certificate_name"));
			Rbean.setQuantity(Rdrs.getString("quantity"));
			Rbean.setTotal_price(Rdrs.getString("total_price"));
			
			RDlist.add(Rbean);
			}
			
			Rdst.close();
			con.close();
			
			request.setAttribute("RDlist", RDlist);
			request.getRequestDispatcher("/WEB-INF/staff/M02/RequestDetails.jsp").forward(request, response);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
