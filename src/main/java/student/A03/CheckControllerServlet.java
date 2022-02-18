package student.A03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.DBConnection;
import student.bean.StudentBean;

/**
 * 入力された情報をチェックし、データベースに登録
 */
@WebServlet("/Check")
public class CheckControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckControllerServlet() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String btnState = request.getParameter("btnState");
		if (btnState == null) {
			request.getRequestDispatcher("/WEB-INF/student/ERROR/Error.jsp").forward(request, response);
		}

		HttpSession session = request.getSession();
		StudentBean sb = (StudentBean) session.getAttribute("sb");
		if (sb == null) {
			request.getRequestDispatcher("/WEB-INF/ERROR/Error.jsp").forward(request, response);
		}

		try {
			DBConnection dbc = new DBConnection();
			// 受付明細表に登録
			if (btnState.equals("top")) { // トップページに遷移
				request.getRequestDispatcher("/Top").forward(request, response);
			} else if (btnState.equals("send")) {
				// 学生表に登録
				dbc.executeInsertUpdateStudentQuery(sb);
				// 受付表に登録
				int reception_id = dbc.executeInsertSelectReceptionQuery(sb);
				// 受付明細表に登録
				dbc.executeInsertReceptionDetailsQuery(sb, reception_id);
				dbc.close();
				request.setAttribute("reception_id", reception_id);
				request.getRequestDispatcher("/WEB-INF/student/A04/Complete.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/ERROR/Error.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/WEB-INF/ERROR/Error.jsp").forward(request, response);
		}
	}

}
